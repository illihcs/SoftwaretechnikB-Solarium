package Controller;

import Model.Termin;
import Model.TerminObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Created by admin on 03.05.2015.
 */
public class TerminController {

    public boolean erstelleTermin(LocalDate Datum, LocalDateTime UhrzeitVon, LocalDateTime UhrzeitBis, String Sonnenbank, String KundenName)
    {
        Termin terminControler = new Termin();
        boolean TerminCreated =  terminControler.TerminEintragen(Datum, UhrzeitVon, UhrzeitBis, Sonnenbank, KundenName);

        return TerminCreated;
    }

    boolean bearbeiteTermin( int ID, LocalDate Datum, LocalDateTime UhrzeitVon, LocalDateTime UhrzeitBis, String Sonnenbank, String KundenName)
    {
        Termin terminControler = new Termin();
        boolean TerminCreated =  terminControler.TerminBearbeiten(ID, Datum, UhrzeitVon, UhrzeitBis, Sonnenbank, KundenName);

        return TerminCreated;
    }

    boolean loescheTermin(int ID)
    {
        Termin terminControler = new Termin();
        boolean TerminCreated =  terminControler.TerminLoeschen(ID);

        return TerminCreated;
    }


    public LinkedList<TerminObject> getAllTermin(){

        Termin terminControler = new Termin();
        LinkedList<TerminObject> allTermine =  terminControler.getAllTermin();

        return allTermine;
    }




}
