package Model;


import java.util.Date;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class SonnenbankObject {

    private int ID = 0;
    private String Kabine = null;
    private String Leistung = null;
    private Date Wartungstermin = null;

    public SonnenbankObject(int ID, String Kabine, String Leistung, Date Wartungstermin) {

        this.ID = ID;
        this.Kabine = Kabine;
        this.Leistung = Leistung;
        this.Wartungstermin = Wartungstermin;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getKabine() {
        return Kabine;
    }

    public void setKabine(String kabine) {
        Kabine = kabine;
    }

    public String getLeistung() {
        return Leistung;
    }

    public void setLeistung(String leistung) {
        Leistung = leistung;
    }

    public Date getWartungstermin() {
        return Wartungstermin;
    }

    public void setWartungstermin(Date wartungstermin) {
        Wartungstermin = wartungstermin;
    }
}
