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


     void erstelleSonnenbank( String Kabine,  int Leistung,  LocalDateTime Wartungstermin);

     void bearbeiteSonnenbank(String Kabine,  int Leistung,  LocalDateTime Wartungstermin);

     void loescheSonnenbank(int ID);




}
