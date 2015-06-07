package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Controller.TerminController;

public class TerminControllerTest {

	@Test
	public void testToDeleteTermin() throws SQLException, ParseException {
		
		TerminController TerminControllerObj = TerminController.getInstance();
		assertTrue(TerminControllerObj.deleteTermin(15));
	}
	
	 
	@Test(expected = Exception.class)
	public void testToCreateTermin() throws SQLException, ParseException {
		 
		TerminController TerminControllerObj = TerminController.getInstance();
		assertTrue(TerminControllerObj.createTermin("2015-04-09", "2014-04-09", "2013-04-09", "1", "1"));
	}
	
	

}
