package Model;

import java.time.LocalDateTime;

/**
 * Created by Win7-Dev on 02.05.2015.
 */

public class Sonnenbank implements ISonnenbank
{

    int ID = 0;
    int Kabine = 0;
    String Leistung = null;
    LocalDateTime Wartungstermin = null;


   public void erstelleSonnenbank( String Kabine,  int Leistung,  LocalDateTime Wartungstermin){}

    public void bearbeiteSonnenbank(String Kabine,  int Leistung,  LocalDateTime Wartungstermin){}

    public void löscheSonnenbank(int ID){}

}
