package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import Controller.UserController;

public class UserControllerTest {

	@Test
	public void test() throws SQLException {
	
		UserController aaa = new  UserController();
		
		assertTrue(aaa.deleteApplicationUser(15));	
		
		
	}

}
