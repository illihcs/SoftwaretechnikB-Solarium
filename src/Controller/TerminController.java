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

    public boolean erstelleTermin(LocalDate Datum, LocalTime UhrzeitVon, LocalTime UhrzeitBis, String Sonnenbank, String KundenName)
    {
        Termin terminControler = new Termin();
        Boolean TerminCreated =  terminControler.TerminEintragen(Datum, UhrzeitVon, UhrzeitBis, Sonnenbank, KundenName);

        return TerminCreated;
    }

    Boolean bearbeiteTermin( int ID, LocalDate Datum, LocalDate UhrzeitVon, LocalDate UhrzeitBis, String Sonnenbank, String KundenName)
    {
        Termin terminControler = new Termin();
        Boolean TerminCreated =  terminControler.TerminBearbeiten(ID, Datum, UhrzeitVon, UhrzeitBis, Sonnenbank, KundenName);

        return TerminCreated;
    }

    Boolean loescheTermin(int ID)
    {
        Termin terminControler = new Termin();
        Boolean TerminCreated =  terminControler.TerminLoeschen(ID);

        return TerminCreated;
    }
}
