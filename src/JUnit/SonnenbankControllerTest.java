package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import Controller.SonnenbankController;

public class SonnenbankControllerTest {

	@Test
	public void test() throws SQLException, ParseException {
 
		SonnenbankController aa = new SonnenbankController();
		
		assertTrue(aa.createSonnenbank("1a", "2500W", "2015-06-03"));
		 
	}

}
