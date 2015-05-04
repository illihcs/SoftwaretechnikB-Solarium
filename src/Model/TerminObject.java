package Model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class TerminObject {

    private int ID = 0;
    private LocalDate Datum = null;
    private LocalTime UhrzeitVon = null;
    private LocalTime UhrzeitBis = null;
    private String Sonnenbank = null;
    private String Kunde;

    public TerminObject(int ID, LocalDate Datum, LocalTime UhrzeitVon, LocalTime UhrzeitBis, String Sonnenbank, String Kunde) {

        this.ID = ID;
        this.Datum = Datum;
        this.UhrzeitVon = UhrzeitVon;
        this.UhrzeitBis = UhrzeitBis;
        this.Sonnenbank = Sonnenbank;
        this.Kunde = Kunde;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getDatum() {
        return Datum;
    }

    public void setDatum(LocalDate datum) {
        Datum = datum;
    }

    public LocalTime getUhrzeitVon() {
        return UhrzeitVon;
    }

    public void setUhrzeitVon(LocalTime uhrzeitVon) {
        UhrzeitVon = uhrzeitVon;
    }

    public LocalTime getUhrzeitBis() {
        return UhrzeitBis;
    }

    public void setUhrzeitBis(LocalTime uhrzeitBis) {
        UhrzeitBis = uhrzeitBis;
    }

    public String getSonnenbank() {
        return Sonnenbank;
    }

    public void setSonnenbank(String sonnenbank) {
        Sonnenbank = sonnenbank;
    }

    public String getKunde() {
        return Kunde;
    }

    public void setKunde(String kunde) {
        Kunde = kunde;
    }
}

