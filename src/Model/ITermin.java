package Model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ITermin {

    boolean TerminEintragen(LocalDate Datum, LocalTime UhrzeitVon,  LocalTime UhrzeitBis , String Sonnenbank, String KundenName);

    boolean TerminBearbeiten (int ID, LocalDate DateTime, LocalDate UhrzeitVon, LocalDate UhrzeitBis, String Sonnenbank, String KundenName);

    boolean TerminLoeschen(int ID) ;

}
