package Controller;

import Model.ApplicationUser;
import Model.ApplicationUserObject;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class UserController {


    // Diese Methode liefert true zurück wenn das Model in der DB ein passenden eintrag findet
    public boolean loginApplicationUser(String loginApplicationUserMail, char[] Password) {

        ApplicationUser user = new ApplicationUser();

        boolean UserAuthenticated = user.loginApplicationUser(loginApplicationUserMail, new String(Password));

        return UserAuthenticated;

    }

    public boolean registerApplicationUser(String Vorname, String Nachname, String Geburtstag, String Mail, char[] Password) {

        // Außen vor lassen! erst wenn wichtige sachen fertig sind weiter implementieren
        ApplicationUser userControler = new ApplicationUser();
        userControler.createApplicationUser(Vorname, Nachname, LocalDate.parse(Geburtstag), Mail, new String(Password));

        return false;
    }

    // Diese Methode liefert true zurück wenn das Model in der DB ein Update durchführen konnte
    public boolean editApplicationUser(int ID, String Vorname, String Nachname, LocalDate Geburtstag, String EMail, char[] Password) {

        ApplicationUser userControler = new ApplicationUser();
        boolean UserCreated = userControler.editApplicationUser(ID, Vorname, Nachname, Geburtstag, EMail, new String(Password));

        return UserCreated;

    }

    public boolean deleteApplicationUser(int i) {
        return new ApplicationUser().deleteApplicationUser(i);
    }

    public LinkedList<ApplicationUserObject> getAllUser() {

        ApplicationUser userControler = new ApplicationUser();
        LinkedList<ApplicationUserObject> AllUser = userControler.getAllApplicationUser();

        return AllUser;
    }

}
