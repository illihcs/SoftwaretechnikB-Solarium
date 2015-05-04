package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ITermin {

    boolean createTermin(LocalDate Datum, LocalDateTime UhrzeitVon, LocalDateTime UhrzeitBis, String Sonnenbank, String KundenName);

    boolean editTermin(int ID, LocalDate DateTime, LocalDateTime UhrzeitVon, LocalDateTime UhrzeitBis, String Sonnenbank, String KundenName);

    boolean deleteTermin(int ID);

}
