package Model;


import java.util.Date;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class TerminObject {

    private int ID = 0;
    private Date Datum = null;
    private Date UhrzeitVon = null;
    private Date UhrzeitBis = null;
    private String Sonnenbank = null;
    private String Kunde;

    public TerminObject(int ID, Date Datum, Date UhrzeitVon, Date UhrzeitBis, String Sonnenbank, String Kunde) {

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

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }

    public Date getUhrzeitVon() {
        return UhrzeitVon;
    }

    public void setUhrzeitVon(Date uhrzeitVon) {
        UhrzeitVon = uhrzeitVon;
    }

    public Date getUhrzeitBis() {
        return UhrzeitBis;
    }

    public void setUhrzeitBis(Date uhrzeitBis) {
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

