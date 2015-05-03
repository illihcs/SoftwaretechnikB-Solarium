package Controller;

import Model.ApplicationUser;

import java.time.LocalDate;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class UserController {


    // Diese Methode liefert true zurück wenn das Model in der DB ein passenden eintrag findet
    public boolean Login(String LoginMail, char[] Password) {

       ApplicationUser user = new ApplicationUser();

        boolean UserAuthenticated = user.login(LoginMail, new String(Password));

        return UserAuthenticated;

    }


    public boolean Register(String Vorname, String Nachname, String Geburtstag, String Mail, char[] Password) {

        // Außen vor lassen! erst wenn wichtige sachen fertig sind weiter implementieren
        ApplicationUser userControler = new ApplicationUser();
         userControler.erstelleUser(Vorname, Nachname, LocalDate.parse(Geburtstag), Mail, new String(Password));

         return false;
    }

    // Diese Methode liefert true zurück wenn das Model in der DB ein Update durchführen konnte
    public boolean BearbeiteUser(int ID, String Vorname, String Nachname, LocalDate Geburtstag, String EMail, char[] Password){

        ApplicationUser userControler = new ApplicationUser();
        boolean UserCreated =  userControler.bearbeitenUserDaten(ID, Vorname, Nachname, Geburtstag, EMail, new String(Password));

        return UserCreated;

    }

    public boolean DeleteUser()
    {
        //TODO: Muss noch gemacht werden!!!
        return false;
    }
}
