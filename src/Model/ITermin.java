package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ITermin {

    boolean createTermin(LocalDate Datum, LocalTime UhrzeitVon, LocalTime UhrzeitBis, String Sonnenbank, String KundenName);

    boolean editTermin(int ID, LocalDate DateTime, LocalTime UhrzeitVon, LocalTime UhrzeitBis, String Sonnenbank, String KundenName);

    boolean deleteTermin(int ID);

}
