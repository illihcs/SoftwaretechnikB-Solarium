package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import Controller.UserController;

public class UserControllerTest {

	@Test
	public void testToDeleteUser() throws SQLException {
	
		UserController UserControllerObj = new  UserController();
		assertTrue(UserControllerObj.deleteApplicationUser(15));	
	}
	
	@Test
	public void testToRegisterApplicationUser() throws SQLException, ParseException {
	
		
		String str = "meinPasswort"; 
		char[] charArray = str.toCharArray();

		
		
		UserController UserControllerObj = new  UserController();
		assertTrue(UserControllerObj.registerApplicationUser("Peter", "Müller", "09.08.2017", "test@mail.de", charArray));	
	}
	
	
	

}
