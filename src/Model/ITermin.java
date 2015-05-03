package Model;

import java.time.LocalDate;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ITermin {

    boolean TerminEintragen(LocalDate Datum, LocalDate UhrzeitVon,  LocalDate UhrzeitBis , String Sonnenbank, String KundenName);

    boolean TerminBearbeiten (int ID, LocalDate DateTime, LocalDate UhrzeitVon, LocalDate UhrzeitBis, String Sonnenbank, String KundenName);

    boolean TerminLoeschen(int ID) ;

}
