package Controller;

import Model.ApplicationUser;
import Model.ApplicationUserObject;
import Model.Sonnenbank;
import Model.SonnenbankObject;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Created by admin on 03.05.2015.
 */
public class SonnenbankController {

    boolean createSonnenbank(String Kabine, String Leistung, LocalDate Wartungstermin)
    {
        Sonnenbank sonnenControler = new Sonnenbank();
        boolean TerminCreated =  sonnenControler.createSonnenbank(Kabine, Leistung, Wartungstermin);

        return TerminCreated;
    }

    boolean editSonnenbank(int ID, String Kabine,  String Leistung,  LocalDate Wartungstermin)
    {
        Sonnenbank sonnenControler = new Sonnenbank();
        boolean TerminCreated =  sonnenControler.editSonnenbank(ID, Kabine, Leistung, Wartungstermin);

        return TerminCreated;
    }

    boolean deleteSunbed(int ID)
    {
        Sonnenbank sonnenControler = new Sonnenbank();
        boolean TerminCreated =  sonnenControler.deleteSunbed(ID);

        return TerminCreated;
    }

    public LinkedList<SonnenbankObject> getAllSonnenbanken(){

        Sonnenbank SonnenbankControler = new Sonnenbank();
        LinkedList<SonnenbankObject> AllSonnenbanken =   SonnenbankControler.getAllSonnenbank();

        return AllSonnenbanken;
    }

}
