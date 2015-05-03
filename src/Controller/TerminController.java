package Controller;

import Model.ApplicationUser;
import Model.Sonnenbank;
import Model.Termin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by admin on 03.05.2015.
 */
public class TerminController {

    boolean erstelleTermin(LocalDate Datum, LocalDateTime UhrzeitVon, LocalDateTime UhrzeitBis, String  Sonnenbank, String KundenName)
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
}
