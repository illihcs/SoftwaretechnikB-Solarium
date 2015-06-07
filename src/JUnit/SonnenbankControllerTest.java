package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import Controller.SonnenbankController;

public class SonnenbankControllerTest {

	@Test(expected = Exception.class)
	public void testToCreateNewSonnenbank() throws SQLException, ParseException {
 
		SonnenbankController SonnenbankObj = new SonnenbankController();
		assertTrue(SonnenbankObj.createSonnenbank("1a", "2500W", "2015-06-03")); 
	}
	
	@Test
	public void testToDeleteSunbed() throws SQLException, ParseException {
 
		SonnenbankController SonnenbankObj = new SonnenbankController();
		assertTrue(SonnenbankObj.deleteSunbed(2)); 
	}
	
	
	

}
