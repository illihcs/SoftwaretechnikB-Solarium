package Model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class TerminObject {

    int ID = 0;
    LocalDate Datum = null;
    LocalTime UhrzeitVon = null;
    LocalTime UhrzeitBis = null;
    String Sonnenbank = null;
    String Kunde;

    public TerminObject(int ID, LocalDate Datum, LocalTime UhrzeitVon, LocalTime UhrzeitBis, String Sonnenbank, String Kunde){

        this.ID = ID;
        this.Datum = Datum;
        this.UhrzeitVon = UhrzeitVon;
        this.UhrzeitBis = UhrzeitBis;
        this.Sonnenbank = Sonnenbank;
        this.Kunde = Kunde;

    }
}
