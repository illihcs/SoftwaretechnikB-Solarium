package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import Controller.TerminController;

public class TerminControllerTest {

	@Test
	public void test() throws SQLException, ParseException {
		
		TerminController aaa = new TerminController();
		assertTrue(aaa.deleteTermin(15));
		assertTrue(aaa.createTermin("2015-04-09", "2014-04-09", "2013-04-09", "1", "1"));
	}

}
