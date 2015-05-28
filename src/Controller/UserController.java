package Controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;

import Model.ApplicationUserObject;
import Model.FrontageModel;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class UserController {

    private DateFormat dateFormater;
    private FrontageModel frontage;

    public UserController() throws SQLException {
        this.dateFormater = DateFormat.getDateInstance(DateFormat.MEDIUM );
        frontage = new FrontageModel();
    }

    // Diese Methode liefert true zurück wenn das Model in der DB ein passenden eintrag findet
    public boolean loginApplicationUser(String loginApplicationUserMail, char[] Password) throws SQLException {
    	boolean UserAuthenticated = frontage.UserLogin(loginApplicationUserMail, new String(Password));
        
    	return UserAuthenticated;
    }

    public boolean registerApplicationUser(String Vorname, String Nachname, String Geburtstag, String Mail, char[] Password) throws SQLException, ParseException {
        // Außen vor lassen! erst wenn wichtige sachen fertig sind weiter implementieren
        Date geburtstagDate = dateFormater.parse(Geburtstag);

        return frontage.UserCreate(Vorname, Nachname, geburtstagDate, Mail, new String(Password));

    }

    // Diese Methode liefert true zurück wenn das Model in der DB ein Update durchführen konnte
    public boolean editApplicationUser(int ID, String Vorname, String Nachname, String Geburtstag, String EMail, char[] Password) throws SQLException, ParseException {
        Date geburtstagDate = dateFormater.parse(Geburtstag);

        boolean UserEdited = frontage.UserEdit(ID, Vorname, Nachname, geburtstagDate, EMail, new String(Password));

        return UserEdited;

    }

    public boolean deleteApplicationUser(int ID) throws SQLException {
        return frontage.UserDelete(ID);
    }

    public LinkedList<String[]> getAllUser() throws SQLException {
        LinkedList<ApplicationUserObject> AllUser = frontage.UserGetAll();
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
