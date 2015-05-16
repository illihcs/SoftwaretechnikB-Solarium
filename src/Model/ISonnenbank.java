package Model;


import java.util.Date;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ISonnenbank {

    int ID = 0;
    String Kabine = null;
    String Leistung = null;
    Date Wartungstermin = null;


    boolean createSonnenbank(String Kabine, String Leistung, Date Wartungstermin);

    boolean editSonnenbank(int ID, String Kabine, String Leistung, Date Wartungstermin);

    boolean deleteSunbed(int ID);


}
