package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface IApplicationUser {

    int ID = 0;
    String  Vorname = null;
    String  Nachname = null;
    LocalDateTime Geburtstag = null;
    String Email = null;
    String Passwort = null;

    boolean  bearbeitenUserDaten(int ID,  String Vorname,  String Nachname , LocalDate Geburtstag,  String Mail,  String Passwort);

    boolean erstelleUser( String Vorname, String Nachname, LocalDate Geburtstag, String Mail, String Passwort);

    boolean loescheUser(int ID);

     boolean login(String Email, String Password);
}



