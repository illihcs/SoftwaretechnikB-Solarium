package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface IApplicationUser {

    int ID = 0;
    String Vorname = null;
    String Nachname = null;
    LocalDateTime Geburtstag = null;
    String Email = null;
    String Passwort = null;

    boolean editApplicationUser(int ID, String Vorname, String Nachname, LocalDate Geburtstag, String Mail, String Passwort);

    boolean createApplicationUser(String Vorname, String Nachname, LocalDate Geburtstag, String Mail, String Passwort);

    boolean deleteApplicationUser(int ID);

    boolean loginApplicationUser(String Email, String Password);
}



