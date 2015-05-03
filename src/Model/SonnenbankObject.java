package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class SonnenbankObject {

    int ID = 0;
    String Kabine = null;
    String Leistung = null;
    LocalDate Wartungstermin = null;

    public SonnenbankObject(int ID, String Kabine, String Leistung, LocalDate Wartungstermin){

        this.ID = ID;
        this.Kabine = Kabine;
        this.Leistung = Leistung;
        this.Wartungstermin = Wartungstermin;
    }

}
