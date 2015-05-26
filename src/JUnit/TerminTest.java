package JUnit;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;

import junit.framework.TestCase;

import org.junit.Test;

import Model.ITermin;
import Model.Termin;
import Model.TerminObject;

public class TerminTest extends TestCase{

	public TerminTest(String name)
	{
		super(name);
	}

	@Test
	public void testCreateTermin() throws ParseException, SQLException {
		ITermin terminDAO = new Termin();
		
		//test data
		//dates
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String dateString1 = "2015-12-30";
		String dateString2 = "1890-12-30";
		String dateString3 = "3000-12-32";
		Date date1 = dateFormatter.parse(dateString1);
		Date date2 = dateFormatter.parse(dateString2);
		Date date3 = dateFormatter.parse(dateString3);
		
		//time from
		Date timefrom1 = dateFormatter.parse("2015-12-30 00:00");
		Date timefrom2 = dateFormatter.parse("1890-12-30 12:00");
		Date timefrom3 = dateFormatter.parse("3000-12-30 20:00");
		
		//time until
		Date timeuntil1 = dateFormatter.parse("2015-12-30 24:00");
		Date timeuntil2 = dateFormatter.parse("1890-12-30 16:00");
		Date timeuntil3 = dateFormatter.parse("3000-12-30 23:59");
		
		//strings for the last to
		String s1 = "Igendwas geiles";
		String s2 = "ein Datum";
		String s3 = "12.05.2015";
		String s4 = "Kabine +#";
		String s5 = "123456789";
		
		terminDAO.createTermin(date1, timefrom1, timeuntil1, s3, s2);
		terminDAO.createTermin(date2, timefrom2, timeuntil2, s4, s1);
		terminDAO.createTermin(date3, timefrom3, timeuntil3, s1, s5);
	}

	@Test
	public void testEditTermin() throws ParseException, SQLException {

		ITermin terminDAO = new Termin();
		
		//test data
		//dates
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String dateString1 = "2015-12-30";
		String dateString2 = "1890-12-30";
		String dateString3 = "3000-12-32";
		Date date1 = dateFormatter.parse(dateString1);
		Date date2 = dateFormatter.parse(dateString2);
		Date date3 = dateFormatter.parse(dateString3);
		
		//time from
		Date timefrom1 = dateFormatter.parse("2015-12-30 00:00");
		Date timefrom2 = dateFormatter.parse("1890-12-30 12:00");
		Date timefrom3 = dateFormatter.parse("3000-12-30 20:00");
		
		//time until
		Date timeuntil1 = dateFormatter.parse("2015-12-30 24:00");
		Date timeuntil2 = dateFormatter.parse("1890-12-30 16:00");
		Date timeuntil3 = dateFormatter.parse("3000-12-30 23:59");
		
		//strings for the last to
		String s1 = "Igendwas geiles";
		String s2 = "ein Datum";
		String s3 = "12.05.2015";
		String s4 = "Kabine +#";
		String s5 = "123456789";
		
		terminDAO.editTermin(0, date1, timefrom1, timeuntil1, s3, s2);
		terminDAO.editTermin(0, date2, timefrom2, timeuntil2, s4, s1);
		terminDAO.editTermin(0, date3, timefrom3, timeuntil3, s1, s5);
	}

	@Test
	public void testGetAllTermin() throws SQLException {
		ITermin terminDAO = new Termin();
		LinkedList<TerminObject> allTermin = terminDAO.getAllTermin();
		if(allTermin.size() == 0)
			fail("List is empty --> no data"); 
	}

}
