package Controller;

import Model.FrontageModel;
import Model.SonnenbankObject;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;


public class SonnenbankController {


    private DateFormat dateFormater;
    private FrontageModel frontage;

    public SonnenbankController() throws SQLException {

        dateFormater = DateFormat.getDateInstance(DateFormat.MEDIUM );
        frontage = new FrontageModel();
    }

    public boolean createSonnenbank(String Kabine, String Leistung, String Wartungstermin) throws SQLException, ParseException {
       
    	Date wartungsterminDate = dateFormater.parse(Wartungstermin);
        boolean TerminCreated = frontage.SonnenbankCreate(Kabine, Leistung, wartungsterminDate);
        return TerminCreated;
    }

    public boolean editSonnenbank(int ID, String Kabine, String Leistung, String Wartungstermin) throws SQLException, ParseException {

        Date wartungsterminDate = dateFormater.parse(Wartungstermin);
        boolean TerminEdited = frontage.SonnenbankEdit(ID, Kabine, Leistung, wartungsterminDate);
        return TerminEdited;
    }

    public boolean deleteSunbed(int ID) throws SQLException {
       
    	boolean TerminDeleted = frontage.SonnenbankDelete(ID);
        return TerminDeleted;
    }

    public LinkedList<SonnenbankObject> getAllSonnenbanken() throws SQLException {
       
    	LinkedList<SonnenbankObject> AllSonnenbanken =   frontage.SonnenbankGetAll();
        return AllSonnenbanken;
    }

}
