package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import View.UserViews.Login;

public class MainControllerTest {

	@Test
	public void tetToCreateLoginView() {
		
		Login loginApplicationUser = new Login();
		assertNotNull(loginApplicationUser);
	}
	 

}
