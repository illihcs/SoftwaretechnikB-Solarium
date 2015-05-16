package Controller;

import Model.ApplicationUser;
import Model.ApplicationUserObject;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class UserController {


    // Diese Methode liefert true zurück wenn das Model in der DB ein passenden eintrag findet
    public boolean loginApplicationUser(String loginApplicationUserMail, char[] Password) throws SQLException {

        ApplicationUser user = new ApplicationUser();

        boolean UserAuthenticated = user.loginApplicationUser(loginApplicationUserMail, new String(Password));

        return UserAuthenticated;

    }

    public boolean registerApplicationUser(String Vorname, String Nachname, LocalDate Geburtstag, String Mail, char[] Password) throws SQLException {

        // Außen vor lassen! erst wenn wichtige sachen fertig sind weiter implementieren
        ApplicationUser userControler = new ApplicationUser();

        return userControler.createApplicationUser(Vorname, Nachname, Geburtstag, Mail, new String(Password));

    }

    // Diese Methode liefert true zurück wenn das Model in der DB ein Update durchführen konnte
    public boolean editApplicationUser(int ID, String Vorname, String Nachname, LocalDate Geburtstag, String EMail, char[] Password) throws SQLException {

        ApplicationUser userControler = new ApplicationUser();
        boolean UserCreated = userControler.editApplicationUser(ID, Vorname, Nachname, Geburtstag, EMail, new String(Password));

        return UserCreated;

    }

    public boolean deleteApplicationUser(int i) throws SQLException {
        return new ApplicationUser().deleteApplicationUser(i);
    }

    public LinkedList<ApplicationUserObject> getAllUser() throws SQLException {

        ApplicationUser userControler = new ApplicationUser();
        LinkedList<ApplicationUserObject> AllUser = userControler.getAllApplicationUser();

        return AllUser;
    }

}
