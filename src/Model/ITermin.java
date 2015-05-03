package Model;

import java.time.LocalDate;
<<<<<<< HEAD
import java.time.LocalTime;
=======
import java.time.LocalDateTime;
>>>>>>> origin/master

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ITermin {

<<<<<<< HEAD
    boolean TerminEintragen(LocalDate Datum, LocalTime UhrzeitVon,  LocalTime UhrzeitBis , String Sonnenbank, String KundenName);
=======
    boolean TerminEintragen(LocalDate Datum, LocalDateTime UhrzeitVon,  LocalDateTime UhrzeitBis , String Sonnenbank, String KundenName);
>>>>>>> origin/master

    boolean TerminBearbeiten (int ID, LocalDate DateTime, LocalDateTime UhrzeitVon, LocalDateTime UhrzeitBis, String Sonnenbank, String KundenName);

    boolean TerminLoeschen(int ID) ;

}
