package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;

import org.junit.Test;

import Model.ApplicationUser;
import Model.ApplicationUserObject;
import Model.IApplicationUser;

public class ApplicationUserTest {

	@Test
	public void testEditApplicationUser() throws SQLException, ParseException {
		IApplicationUser userDAO = new ApplicationUser();
		
		//test data
		//givenname's
		String givenname1 = "Matthias";
		String givenname2 = "Émil";
		String givenname3 = "Jan";
		
		//surnames
		String surname1 = "Just";
		String surname2 = "@Gammel";
		String surname3 = "Schillemans";
		
		//birthdays
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String dateString1 = "2015-12-30";
		String dateString2 = "1890-12-30";
		String dateString3 = "3000-12-32";
		Date birthday1 = dateFormatter.parse(dateString1);
		Date birthday2 = dateFormatter.parse(dateString2);
		Date birthday3 = dateFormatter.parse(dateString3);
		
		//email's
		String email1 = "test@test.de";
		String email2 = "blabla1.bla@irgendwaslanges.com";
		String email3 = "ausgedacht@ausgedacht.ausgedacht";
		
		//passwords
		String password1 = "123456789";
		String password2 = "!§$%&/()=?";
		String password3 = "W$E1";
		
		userDAO.editApplicationUser(0, givenname1, surname1, birthday1, email1, password1);
		userDAO.editApplicationUser(0, givenname2, surname2, birthday2, email2, password2);
		userDAO.editApplicationUser(0, givenname3, surname3, birthday3, email3, password3);
	}

	@Test
	public void testCreateApplicationUser() throws ParseException, SQLException {
		IApplicationUser userDAO = new ApplicationUser();
		
		//test data
		//givenname's
		String givenname1 = "Matthias";
		String givenname2 = "Émil";
		String givenname3 = "Jan";
		
		//surnames
		String surname1 = "Just";
		String surname2 = "@Gammel";
		String surname3 = "Schillemans";
		
		//birthdays
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String dateString1 = "2015-12-30";
		String dateString2 = "1890-12-30";
		String dateString3 = "3000-12-32";
		Date birthday1 = dateFormatter.parse(dateString1);
		Date birthday2 = dateFormatter.parse(dateString2);
		Date birthday3 = dateFormatter.parse(dateString3);
		
		//email's
		String email1 = "test@test.de";
		String email2 = "blabla1.bla@irgendwaslanges.com";
		String email3 = "ausgedacht@ausgedacht.ausgedacht";
		
		//passwords
		String password1 = "123456789";
		String password2 = "!§$%&/()=?";
		String password3 = "W$E1";
		
		userDAO.createApplicationUser(givenname1, surname1, birthday1, email1, password1);
		userDAO.createApplicationUser(givenname2, surname2, birthday2, email2, password2);
		userDAO.createApplicationUser(givenname3, surname3, birthday3, email3, password3);
	}

	@Test
	public void testLoginApplicationUser() throws SQLException {
		IApplicationUser userDAO = new ApplicationUser();
		userDAO.loginApplicationUser("test@gmx.de", "Peter");
	}

	@Test
	public void testGetAllApplicationUser() throws SQLException {
		IApplicationUser userDAO = new ApplicationUser();
		LinkedList<ApplicationUserObject> allUser = userDAO.getAllApplicationUser();
		if(allUser.size() == 0)
			fail("List is empty --> no data");
	}

}
