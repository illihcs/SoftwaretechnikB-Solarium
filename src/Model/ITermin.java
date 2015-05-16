package Model;

import java.util.Date;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ITermin {

    boolean createTermin(Date Datum, Date UhrzeitVon, Date UhrzeitBis, String Sonnenbank, String KundenName);

    boolean editTermin(int ID, Date Date, Date UhrzeitVon, Date UhrzeitBis, String Sonnenbank, String KundenName);

    boolean deleteTermin(int ID);

}
