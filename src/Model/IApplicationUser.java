package Model;


import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public interface IApplicationUser {

    int ID = 0;
    String Vorname = null;
    String Nachname = null;
    Date Geburtstag = null;
    String Email = null;
    String Passwort = null;

    boolean editApplicationUser(int ID, String Vorname, String Nachname, Date Geburtstag, String Mail, String Passwort);

    boolean createApplicationUser(String Vorname, String Nachname, Date Geburtstag, String Mail, String Passwort);

    boolean deleteApplicationUser(int ID);

    boolean loginApplicationUser(String Email, String Password);

	LinkedList<ApplicationUserObject> getAllApplicationUser();
}



