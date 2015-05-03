package Controller;

import Model.Sonnenbank;
import Model.Termin;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.time.LocalDate;

/**
 * Created by admin on 03.05.2015.
 */
public class SonnenbankController {

    Boolean erstelleSonnenbank(String Kabine, String Leistung, LocalDate Wartungstermin)
    {
        Sonnenbank sonnenControler = new Sonnenbank();
        Boolean TerminCreated =  sonnenControler.erstelleSonnenbank(Kabine, Leistung, Wartungstermin);

        return TerminCreated;
    }

    Boolean bearbeiteSonnenbank(int ID, String Kabine,  String Leistung,  LocalDate Wartungstermin)
    {
        Sonnenbank sonnenControler = new Sonnenbank();
        Boolean TerminCreated =  sonnenControler.bearbeiteSonnenbank(ID, Kabine, Leistung, Wartungstermin);

        return TerminCreated;
    }

    Boolean loescheSonnenbank(int ID)
    {
        Sonnenbank sonnenControler = new Sonnenbank();
        Boolean TerminCreated =  sonnenControler.loescheSonnenbank(ID);

        return TerminCreated;
    }
}
