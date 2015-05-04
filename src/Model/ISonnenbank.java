package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ISonnenbank {

    int ID = 0;
    String Kabine = null;
    String Leistung = null;
    LocalDateTime Wartungstermin = null;


    boolean createSonnenbank(String Kabine, String Leistung, LocalDate Wartungstermin);

    boolean editSonnenbank(int ID, String Kabine, String Leistung, LocalDate Wartungstermin);

    boolean deleteSunbed(int ID);


}
