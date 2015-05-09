package Controller;

import Model.Termin;
import Model.TerminObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;


public class TerminController {

    public boolean createTermin(LocalDate Datum, LocalTime UhrzeitVon, LocalTime UhrzeitBis, String Sonnenbank, String KundenName)
    {
        Termin terminModel = new Termin();
        boolean TerminCreated =  terminModel.createTermin(Datum, UhrzeitVon, UhrzeitBis, Sonnenbank, KundenName);

        return TerminCreated;
    }

    public boolean editTermin( int ID, LocalDate Datum, LocalTime UhrzeitVon, LocalTime UhrzeitBis, String Sonnenbank, String KundenName)
    {
        Termin terminControler = new Termin();
        boolean TerminCreated =  terminControler.editTermin(ID, Datum, UhrzeitVon, UhrzeitBis, Sonnenbank, KundenName);

        return TerminCreated;
    }

    public boolean deleteTermin(int ID)
    {
        Termin terminControler = new Termin();
        boolean TerminCreated =  terminControler.deleteTermin(ID);

        return TerminCreated;
    }


    public LinkedList<TerminObject> getAllTermin(){

        Termin terminControler = new Termin();
        LinkedList<TerminObject> allTermine =  terminControler.getAllTermin();

        return allTermine;
    }




}
