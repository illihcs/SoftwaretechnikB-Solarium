package Model;


import java.sql.Connection;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ISonnenbank {

	SqlConfig SqlConfigObj = null;
    Connection con = null;

    boolean createSonnenbank(String Kabine, String Leistung, Date Wartungstermin);

    boolean editSonnenbank(int ID, String Kabine, String Leistung, Date Wartungstermin);

    boolean deleteSunbed(int ID);

	LinkedList<SonnenbankObject> getAllSonnenbank();


}
