package Model;


import java.time.LocalDate;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public class Termin implements ITermin {

    int ID = 0;
    LocalDate Datum = null;
    LocalDate UhrzeitVon = null;
    LocalDate UhrzeitBis = null;
    int Sonnenbank = 0;
    String Kunde;

    public void TerminEintragen( LocalDate Datum, LocalDate UhrzeitVon,  LocalDate UhrzeitBis , int Sonnenbank, String KundenName) {

    }

    public void TerminBearbeiten (LocalDate DateTime, LocalDate  UhrzeitVon,LocalDate   UhrzeitBis, int Sonnenbank, String KundenName){

    }

    public void TerminL�schen(int ID){

      }


}
