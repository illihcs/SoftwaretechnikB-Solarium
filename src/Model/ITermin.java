package Model;

import java.sql.Connection;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ITermin {

	SqlConfig SqlConfigObj = null;
    Connection con = null;
	
    boolean createTermin(Date Datum, Date UhrzeitVon, Date UhrzeitBis, String Sonnenbank, String KundenName);

    boolean editTermin(int ID, Date Date, Date UhrzeitVon, Date UhrzeitBis, String Sonnenbank, String KundenName);

    boolean deleteTermin(int ID);

	LinkedList<TerminObject> getAllTermin();

	LinkedList<TerminHoursADayObject> getTerminHoursADay();

}
