package Controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Observable;

import Model.FrontageModel;
import Model.TerminHoursADayObject;
import Model.TerminObject;
import View.ObserverViews.TerminHoursADay;


public class TerminController extends Observable{

	private static TerminController _Instance;
    private DateFormat format;
    private TerminHoursADay thadV;
    private FrontageModel frontage;

    private TerminController() throws SQLException {
    	format = new SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.GERMANY);
        frontage = new FrontageModel();
    }

    public static TerminController getInstance() throws SQLException
    {
    	if(_Instance == null)
    	{
    		_Instance = new TerminController();
    	}
    	return _Instance;
    }
    

    /**
	 * @return the thadV
	 */
	public TerminHoursADay getThadV() {
		return thadV;
	}

	/**
	 * @param thadV the thadV to set
	 */
	public void setThadV(TerminHoursADay thadV) {
		this.thadV = thadV;
	}

	
	
	public boolean createTermin(String Datum, String UhrzeitVon, String UhrzeitBis, String Sonnenbank, String KundenName) throws SQLException, ParseException {
       
		Date DatumDate = format.parse(Datum + " 00:00");
		Date UhrzeitVonDate = format.parse(Datum + " " + UhrzeitVon);
		Date UhrzeitBisDate = format.parse(Datum + " " + UhrzeitBis);
		

        boolean TerminCreated =  frontage.TerminCreate(DatumDate, UhrzeitVonDate, UhrzeitBisDate, Sonnenbank, KundenName);

        //notify Observers
        if(TerminCreated == true)
        {
        	notifyAllObservers();
        }
        
        return TerminCreated;
    }

    public boolean editTermin(int ID, String Datum, String UhrzeitVon, String UhrzeitBis, String Sonnenbank, String KundenName) throws SQLException, ParseException {
        Date DatumDate = format.parse(Datum + " 00:00");
        Date UhrzeitVonDate = format.parse(Datum + " " + UhrzeitVon);
        Date UhrzeitBisDate = format.parse(Datum + " " + UhrzeitBis);

        
        
        boolean TerminEdit =  frontage.TerminEdit(ID, DatumDate, UhrzeitVonDate, UhrzeitBisDate, Sonnenbank, KundenName);

        //notify Observers
        if(TerminEdit == true)
        {
        	notifyAllObservers();
        }
        
        return TerminEdit;
    }

    public boolean deleteTermin(int ID) throws SQLException {
        boolean TerminDeleted =  frontage.TerminDelete(ID);

        //notify Observers
        if(TerminDeleted == true)
        {
        	notifyAllObservers();
        }        
        
        return TerminDeleted;
    }


    public LinkedList<TerminObject> getAllTermin() throws SQLException {
        LinkedList<TerminObject> allTermine =  frontage.TerminGetAll();

        return allTermine;
    }

    public LinkedList<String[]> getTerminHoursADay() throws SQLException {
		LinkedList<String[]> list = new LinkedList<>();
        LinkedList<TerminHoursADayObject> terminADay =  frontage.TerminGetTerminHoursADay();
        
		
		//convert all attributes of TerminHoursADayList to strings
		for(TerminHoursADayObject to : terminADay)
		{
			long hours = to.getGesamtdauer()/60;
			long minutes = to.getGesamtdauer()%60;
			String gesamtdauer = String.format("%d:%02d", hours, minutes);
			
			long hours2 = to.getDurchschnittsdauer()/60;
			long minutes2 = to.getDurchschnittsdauer()%60;
			String durchschnittsdauer = String.format("%d:%02d", hours2, minutes2);
			
			SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");
			
			String[] array = {dt.format(to.getDatum()), to.getAnzahl() + "", gesamtdauer, durchschnittsdauer};
			list.add(array);
		}
		
		
		return list;
	}

	private void notifyAllObservers() throws SQLException
	{
		setChanged();
    	notifyObservers(getTerminHoursADay());
	}


}
