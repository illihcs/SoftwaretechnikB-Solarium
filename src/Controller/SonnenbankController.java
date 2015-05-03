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

    boolean erstelleSonnenbank(String Kabine, String Leistung, LocalDate Wartungstermin)
    {
        Sonnenbank sonnenControler = new Sonnenbank();
        boolean TerminCreated =  sonnenControler.erstelleSonnenbank(Kabine, Leistung, Wartungstermin);

        return TerminCreated;
    }

    boolean bearbeiteSonnenbank(int ID, String Kabine,  String Leistung,  LocalDate Wartungstermin)
    {
        Sonnenbank sonnenControler = new Sonnenbank();
        boolean TerminCreated =  sonnenControler.bearbeiteSonnenbank(ID, Kabine, Leistung, Wartungstermin);

        return TerminCreated;
    }

    boolean loescheSonnenbank(int ID)
    {
        Sonnenbank sonnenControler = new Sonnenbank();
        boolean TerminCreated =  sonnenControler.loescheSonnenbank(ID);

        return TerminCreated;
    }

    public LinkedList<SonnenbankObject> getAllSonnenbanken(){

        Sonnenbank SonnenbankControler = new Sonnenbank();
        LinkedList<SonnenbankObject> AllSonnenbanken =   SonnenbankControler.getAllSonnenbank();

        return AllSonnenbanken;
    }

}
