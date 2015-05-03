package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface ISonnenbank {

     int ID = 0;
     int Kabine = 0;
     String Leistung = null;
     LocalDateTime Wartungstermin = null;


     boolean erstelleSonnenbank( String Kabine,  String Leistung,  LocalDate Wartungstermin);

     boolean bearbeiteSonnenbank(int ID, String Kabine,  String Leistung,  LocalDate Wartungstermin);

     boolean loescheSonnenbank(int ID);




}
