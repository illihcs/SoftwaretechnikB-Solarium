package JUnit;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;

import org.junit.Test;

import Model.ISonnenbank;
import Model.Sonnenbank;
import Model.SonnenbankObject;

public class SonnenbankTest {

	@Test
	public void testCreateSonnenbank() throws SQLException, ParseException {
		ISonnenbank sonnenbankDAO = new Sonnenbank();
		
		//test data
		//cabine strings
		String kabine1 = "Kabine";
		String kabine2 = "123";
		String kabine3 = "#+´´";
		
		//power strings
		String power1 = "123 Watt";
		String power2 = "nix relevantes";
		String power3 = "keine Angaben!?";

		//dates
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String dateString1 = "2015-12-30";
		String dateString2 = "1890-12-30";
		String dateString3 = "3000-12-32";
		Date date1 = dateFormatter.parse(dateString1);
		Date date2 = dateFormatter.parse(dateString2);
		Date date3 = dateFormatter.parse(dateString3);
				
		sonnenbankDAO.createSonnenbank(kabine1, power1, date1);
		sonnenbankDAO.createSonnenbank(kabine2, power2, date2);
		sonnenbankDAO.createSonnenbank(kabine3, power3, date3);
	}

	@Test
	public void testEditSonnenbank() throws SQLException, ParseException {
		ISonnenbank sonnenbankDAO = new Sonnenbank();
		
		//test data
		//cabine strings
		String kabine1 = "Kabine";
		String kabine2 = "123";
		String kabine3 = "#+´´";
		
		//power strings
		String power1 = "123 Watt";
		String power2 = "nix relevantes";
		String power3 = "keine Angaben!?";

		//dates
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String dateString1 = "2015-12-30";
		String dateString2 = "1890-12-30";
		String dateString3 = "3000-12-32";
		Date date1 = dateFormatter.parse(dateString1);
		Date date2 = dateFormatter.parse(dateString2);
		Date date3 = dateFormatter.parse(dateString3);
				
		sonnenbankDAO.editSonnenbank(0 ,kabine1, power1, date1);
		sonnenbankDAO.editSonnenbank(0, kabine2, power2, date2);
		sonnenbankDAO.editSonnenbank(0, kabine3, power3, date3);
	}

	@Test
	public void testGetAllSonnenbank() throws SQLException {
		ISonnenbank sonnenbankDAO = new Sonnenbank();
		LinkedList<SonnenbankObject> allSonnenbank = sonnenbankDAO.getAllSonnenbank();
		if(allSonnenbank.size() == 0)
			fail("List is empty --> no data"); 
	}

}
