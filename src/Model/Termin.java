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
        //TODO: eintragen Termin
    }

    public void TerminBearbeiten (LocalDate DateTime, LocalDate  UhrzeitVon,LocalDate   UhrzeitBis, int Sonnenbank, String KundenName){
        //TODO: bearbeiten TErmin
    }

    public void TerminLoeschen(int ID){
        //TODO: löschen Termin
      }


}
