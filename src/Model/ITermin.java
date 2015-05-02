package Model;

import java.time.LocalDate;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ITermin {

    void TerminEintragen( LocalDate Datum, LocalDate UhrzeitVon,  LocalDate UhrzeitBis , int Sonnenbank, String KundenName);

    void TerminBearbeiten (LocalDate DateTime, LocalDate UhrzeitVon, LocalDate UhrzeitBis, int Sonnenbank, String KundenName);

    void TerminLöschen(int ID) ;

}
