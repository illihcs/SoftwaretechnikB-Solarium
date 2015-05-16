package Controller;

import Model.Sonnenbank;
import Model.SonnenbankObject;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by admin on 03.05.2015.
 */
public class SonnenbankController {

    public boolean createSonnenbank(String Kabine, String Leistung, Date Wartungstermin) throws SQLException {
        Sonnenbank sonnenControler = new Sonnenbank();
        boolean TerminCreated =  sonnenControler.createSonnenbank(Kabine, Leistung, Wartungstermin);

        return TerminCreated;
    }

    public boolean editSonnenbank(int ID, String Kabine, String Leistung, Date Wartungstermin) throws SQLException {
        Sonnenbank sonnenControler = new Sonnenbank();
        boolean TerminCreated =  sonnenControler.editSonnenbank(ID, Kabine, Leistung, Wartungstermin);

        return TerminCreated;
    }

    public boolean deleteSunbed(int ID) throws SQLException {
        Sonnenbank sonnenControler = new Sonnenbank();
        boolean TerminCreated =  sonnenControler.deleteSunbed(ID);

        return TerminCreated;
    }

    public LinkedList<SonnenbankObject> getAllSonnenbanken() throws SQLException {

        Sonnenbank SonnenbankControler = new Sonnenbank();
        LinkedList<SonnenbankObject> AllSonnenbanken =   SonnenbankControler.getAllSonnenbank();

        return AllSonnenbanken;
    }

}
