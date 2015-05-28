package Controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Observable;

import Model.FrontageModel;
import Model.TerminHoursADayObject;
import Model.TerminObject;
import View.ObserverViews.TerminHoursADay;


public class TerminController extends Observable{

	private static TerminController _Instance;
    private DateFormat dateFormater;
    private TerminHoursADay thadV;
    private FrontageModel frontage;

    private TerminController() throws SQLException {
        dateFormater =   DateFormat.getDateInstance(DateFormat.MEDIUM );
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
        Date DatumDate = dateFormater.parse(Datum);
        Date UhrzeitVonDate = dateFormater.parse(UhrzeitVon);
        Date UhrzeitBisDate = dateFormater.parse(UhrzeitBis);

        boolean TerminCreated =  frontage.TerminCreate(DatumDate, UhrzeitVonDate, UhrzeitBisDate, Sonnenbank, KundenName);

        //notify Observers
        if(TerminCreated == true)
        {
        	notifyAllObservers();
        }
        
        return TerminCreated;
    }

    public boolean editTermin(int ID, String Datum, String UhrzeitVon, String UhrzeitBis, String Sonnenbank, String KundenName) throws SQLException, ParseException {
        Date DatumDate = dateFormater.parse(Datum);
        Date UhrzeitVonDate = dateFormater.parse(UhrzeitVon);
        Date UhrzeitBisDate = dateFormater.parse(UhrzeitBis);

        boolean TerminCreated =  frontage.TerminEdit(ID, DatumDate, UhrzeitVonDate, UhrzeitBisDate, Sonnenbank, KundenName);

        //notify Observers
        if(TerminCreated == true)
        {
        	notifyAllObservers();
        }
        
        return TerminCreated;
    }

    public boolean deleteTermin(int ID) throws SQLException {
        boolean TerminCreated =  frontage.TerminDelete(ID);

        //notify Observers
        if(TerminCreated == true)
        {
        	notifyAllObservers();
        }        
        
        return TerminCreated;
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
			
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			
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
