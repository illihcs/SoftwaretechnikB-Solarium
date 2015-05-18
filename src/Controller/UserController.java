package Controller;

import Model.ApplicationUser;
import Model.ApplicationUserObject;
import Model.IApplicationUser;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class UserController {

    private DateFormat dateFormater;

    public UserController() {
        this.dateFormater = DateFormat.getDateInstance(DateFormat.MEDIUM );
    }

    // Diese Methode liefert true zurück wenn das Model in der DB ein passenden eintrag findet
    public boolean loginApplicationUser(String loginApplicationUserMail, char[] Password) throws SQLException {

        IApplicationUser user = new ApplicationUser();

        boolean UserAuthenticated = user.loginApplicationUser(loginApplicationUserMail, new String(Password));

        return UserAuthenticated;

    }

    public boolean registerApplicationUser(String Vorname, String Nachname, String Geburtstag, String Mail, char[] Password) throws SQLException, ParseException {

        // Außen vor lassen! erst wenn wichtige sachen fertig sind weiter implementieren
        IApplicationUser userControler = new ApplicationUser();
        Date geburtstagDate = dateFormater.parse(Geburtstag);

        return userControler.createApplicationUser(Vorname, Nachname, geburtstagDate, Mail, new String(Password));

    }

    // Diese Methode liefert true zurück wenn das Model in der DB ein Update durchführen konnte
    public boolean editApplicationUser(int ID, String Vorname, String Nachname, String Geburtstag, String EMail, char[] Password) throws SQLException, ParseException {

        IApplicationUser userControler = new ApplicationUser();
        Date geburtstagDate = dateFormater.parse(Geburtstag);

        boolean UserCreated = userControler.editApplicationUser(ID, Vorname, Nachname, geburtstagDate, EMail, new String(Password));

        return UserCreated;

    }

    public boolean deleteApplicationUser(int i) throws SQLException {
        return new ApplicationUser().deleteApplicationUser(i);
    }

    public LinkedList<String[]> getAllUser() throws SQLException {

        IApplicationUser userController = new ApplicationUser();
        LinkedList<ApplicationUserObject> AllUser = userController.getAllApplicationUser();
        LinkedList<String[]> stringListWithArrays = new LinkedList<String[]>();
        
        for(ApplicationUserObject user : AllUser)
        {
          	String[] array = {
					String.valueOf(user.getID()),
					user.getVorname(),
					user.getNachname(),
					user.getGeburtstag().toString(),
					user.getEmail(),
					user.getPasswort().toString()
			};
        	stringListWithArrays.add(array);
        }
        
        return stringListWithArrays;
    }

}
