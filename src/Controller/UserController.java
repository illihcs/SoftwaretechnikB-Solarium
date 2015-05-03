package Controller;

import Model.ApplicationUser;

import java.time.LocalDate;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class UserController {

    public boolean Login(String LoginMail, char[] Password) {
       //ApplicationUser user = new ApplicationUser();
      //  String pass = new String(Password);
     //   return user.login(LoginMail, pass);
        return true;
    }

    public void Register(String Vorname, String Nachname, String Geburtstag, String Mail, char[] password) {
        ApplicationUser user = new ApplicationUser(Vorname, Nachname, LocalDate.parse(Geburtstag), Mail, new String(password));
        //TODO: Registrierung des Nutzers
    }

    public void BearbeiteUser(String Vorname, String Nachname, String Geburtstag, String Mail, char[] password){
        //TODO: Bearbeitung des Users --> im Prinzip wie Registrieren
    }
}
