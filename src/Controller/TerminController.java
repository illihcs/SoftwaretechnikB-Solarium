package Controller;

import Model.Termin;
import Model.TerminObject;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;


public class TerminController {

    public boolean createTermin(Date Datum, Date UhrzeitVon, Date UhrzeitBis, String Sonnenbank, String KundenName) throws SQLException {
        Termin terminModel = new Termin();
        boolean TerminCreated =  terminModel.createTermin(Datum, UhrzeitVon, UhrzeitBis, Sonnenbank, KundenName);

        return TerminCreated;
    }

    public boolean editTermin(int ID, Date Datum, Date UhrzeitVon, Date UhrzeitBis, String Sonnenbank, String KundenName) throws SQLException {
        Termin terminControler = new Termin();
        boolean TerminCreated =  terminControler.editTermin(ID, Datum, UhrzeitVon, UhrzeitBis, Sonnenbank, KundenName);

        return TerminCreated;
    }

    public boolean deleteTermin(int ID) throws SQLException {
        Termin terminControler = new Termin();
        boolean TerminCreated =  terminControler.deleteTermin(ID);

        return TerminCreated;
    }


    public LinkedList<TerminObject> getAllTermin() throws SQLException {

        Termin terminControler = new Termin();
        LinkedList<TerminObject> allTermine =  terminControler.getAllTermin();

        return allTermine;
    }




}
