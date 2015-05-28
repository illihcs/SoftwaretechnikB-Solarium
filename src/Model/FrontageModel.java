package Model;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

public class FrontageModel {

	ISonnenbank SonnenbankController;
	IApplicationUser UserController;
	ITermin TerminController;
	
	public FrontageModel() throws SQLException
	{
		SonnenbankController = new Sonnenbank();
		UserController = new ApplicationUser();
		TerminController = new Termin();
	}
	
	
	//SonnenbankMethods
	public boolean SonnenbankCreate(String kabine, String leistung, Date wartungsterminDate) throws SQLException {
		return SonnenbankController.createSonnenbank(kabine, leistung, wartungsterminDate);
	}

	public boolean SonnenbankEdit(int ID, String kabine, String leistung, Date wartungsterminDate) throws SQLException {
		return SonnenbankController.editSonnenbank(ID, kabine, leistung, wartungsterminDate);
	}

	public boolean SonnenbankDelete(int ID) throws SQLException {
        return SonnenbankController.deleteSunbed(ID);
	}

	public LinkedList<SonnenbankObject> SonnenbankGetAll() throws SQLException {
	    LinkedList<SonnenbankObject> AllSonnenbanken =   SonnenbankController.getAllSonnenbank();

        return AllSonnenbanken;
	}
	//end SonnenbankMethods


	
	//User-Methods
	public boolean UserLogin(String loginApplicationUserMail, String Password) {
		return UserController.loginApplicationUser(loginApplicationUserMail, Password);
	}

	public boolean UserCreate(String vorname, String nachname, Date geburtstagDate, String mail, String password) {
		return UserController.createApplicationUser(vorname, nachname, geburtstagDate, mail, password);
	}

	public boolean UserEdit(int ID, String vorname, String nachname, Date geburtstagDate, String eMail, String password) {
		return UserController.editApplicationUser(ID, vorname, nachname, geburtstagDate, eMail, password);
	}

	public boolean UserDelete(int ID) {
		return UserController.deleteApplicationUser(ID);
	}

	public LinkedList<ApplicationUserObject> UserGetAll() {
		return UserController.getAllApplicationUser();
	}
	//end User-Methods

	
	
	//TerminMethods
	public boolean TerminCreate(Date datumDate, Date uhrzeitVonDate, Date uhrzeitBisDate, String sonnenbank, String kundenName) {
		return TerminController.createTermin(datumDate, uhrzeitVonDate, uhrzeitBisDate, sonnenbank, kundenName);
	}

	public boolean TerminEdit(int ID, Date datumDate, Date uhrzeitVonDate, Date uhrzeitBisDate, String sonnenbank, String kundenName) {
		return TerminController.editTermin(ID, datumDate, uhrzeitVonDate, uhrzeitBisDate, sonnenbank, kundenName);
	}

	public boolean TerminDelete(int ID) {
		return TerminController.deleteTermin(ID);
	}

	public LinkedList<TerminObject> TerminGetAll() {
		return TerminController.getAllTermin();
	}

	public LinkedList<TerminHoursADayObject> TerminGetTerminHoursADay() {
		return TerminController.getTerminHoursADay();
	}
	//end TerminMethods
	
}
