package Controller;

import Model.Sonnenbank;
import Model.Termin;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.time.LocalDate;

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
}
