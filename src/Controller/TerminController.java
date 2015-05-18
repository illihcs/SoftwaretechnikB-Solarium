package Controller;

import Model.ITermin;
import Model.Termin;
import Model.TerminObject;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;


public class TerminController {

    private DateFormat dateFormater;

    public TerminController() {
        dateFormater =   DateFormat.getDateInstance(DateFormat.MEDIUM );
    }

    public boolean createTermin(String Datum, String UhrzeitVon, String UhrzeitBis, String Sonnenbank, String KundenName) throws SQLException, ParseException {

        ITermin terminModel = new Termin();

        Date DatumDate = dateFormater.parse(Datum);
        Date UhrzeitVonDate = dateFormater.parse(UhrzeitVon);
        Date UhrzeitBisDate = dateFormater.parse(UhrzeitBis);

        boolean TerminCreated =  terminModel.createTermin(DatumDate, UhrzeitVonDate, UhrzeitBisDate, Sonnenbank, KundenName);

        return TerminCreated;
    }

    public boolean editTermin(int ID, String Datum, String UhrzeitVon, String UhrzeitBis, String Sonnenbank, String KundenName) throws SQLException, ParseException {

        ITermin terminControler = new Termin();

        Date DatumDate = dateFormater.parse(Datum);
        Date UhrzeitVonDate = dateFormater.parse(UhrzeitVon);
        Date UhrzeitBisDate = dateFormater.parse(UhrzeitBis);

        boolean TerminCreated =  terminControler.editTermin(ID, DatumDate, UhrzeitVonDate, UhrzeitBisDate, Sonnenbank, KundenName);

        return TerminCreated;
    }

    public boolean deleteTermin(int ID) throws SQLException {
        ITermin terminControler = new Termin();
        boolean TerminCreated =  terminControler.deleteTermin(ID);

        return TerminCreated;
    }


    public LinkedList<TerminObject> getAllTermin() throws SQLException {

        ITermin terminControler = new Termin();
        LinkedList<TerminObject> allTermine =  terminControler.getAllTermin();

        return allTermine;
    }




}
