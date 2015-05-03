package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class SonnenbankObject {

   private int ID = 0;
    private String Kabine = null;
    private String Leistung = null;
    private LocalDate Wartungstermin = null;

    public SonnenbankObject(int ID, String Kabine, String Leistung, LocalDate Wartungstermin){

        this.ID = ID;
        this.Kabine = Kabine;
        this.Leistung = Leistung;
        this.Wartungstermin = Wartungstermin;
    }

    public int getID() {
        return ID;
    }

    public String getKabine() {
        return Kabine;
    }

    public String getLeistung() {
        return Leistung;
    }

    public LocalDate getWartungstermin() {
        return Wartungstermin;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setKabine(String kabine) {
        Kabine = kabine;
    }

    public void setLeistung(String leistung) {
        Leistung = leistung;
    }

    public void setWartungstermin(LocalDate wartungstermin) {
        Wartungstermin = wartungstermin;
    }
}
