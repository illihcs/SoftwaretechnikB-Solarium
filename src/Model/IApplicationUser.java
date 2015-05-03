package Model;

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

     void  bearbeitenUserDaten( String Vorname,  String Nachname , LocalDateTime Geburtstag,  String Mail,  String Passwort);

    void erstelleUser( String Vorname, String Nachname, LocalDateTime Geburtstag, String Mail, String Passwort);

     void loescheUser(int ID);

     boolean login(String Email, String Password);
}



