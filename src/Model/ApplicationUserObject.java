package Model;

import java.time.LocalDate;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class ApplicationUserObject {

    int ID = 0;
    String  Vorname;
    String  Nachname;
    LocalDate Geburtstag;
    String Email;
    String Passwort;

    public  ApplicationUserObject(int IDs,String  Vorname, String  Nachname, LocalDate Geburtstag, String Email, String Passwort ){
        this.ID = ID;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Geburtstag = Geburtstag;
        this.Email = Email;
        this.Passwort = Passwort;
    }
}
