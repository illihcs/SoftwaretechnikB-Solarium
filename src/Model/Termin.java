package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;


public class Termin implements ITermin {

    // helper objects for operate with DB
    SqlConfig SqlConfigObj;
    Connection con;

    java.util.Date currentDate;

    public Termin() throws SQLException {

        SqlConfigObj =  SqlConfig.getInstance();
        currentDate = new java.util.Date();
    }

    // create an termin in the DB
    public boolean createTermin(java.util.Date Datum, java.util.Date UhrzeitVon, java.util.Date UhrzeitBis, String Sonnenbank, String KundenName) {

        try {

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

//            SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//            DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
//            
//            String date = formatdate.format(Datum);
//            String from = date + " " + df.format(UhrzeitVon);
//            String until = date + " " + df.format(UhrzeitBis);
//            
//            // Define SQL Statement
//            String insertNOTDYNAMICTableSQL= "INSERT INTO termin ( Datum, Uhrzeitvon, UhrzeitBis, Sonnenbank, Kunde) VALUES ('" + date + "', '" + from + "', '" + until + "', '" + Sonnenbank + "', '" + KundenName + "')";
//            
//            PreparedStatement preparedStatement = con.prepareStatement(insertNOTDYNAMICTableSQL);
            
            
            
            
            

            // Define SQL Statement
            String insertTableSQL = "INSERT INTO termin ( Datum, Uhrzeitvon, UhrzeitBis, Sonnenbank, Kunde) VALUES (?,?,?,?,?)";
           // String insertNOTDYNAMICTableSQL= "UPDATE termin SET Datum = '" + date + "', UhrzeitVon = '" + from + "', UhrzeitBis='" + until + "', Sonnenbank = '" + Sonnenbank + "', Kunde = '" + KundenName + "' WHERE ID = " + ID ;
            
            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            java.sql.Date date = new java.sql.Date(Datum.getTime());
            java.sql.Timestamp datetimefrom = new Timestamp(UhrzeitVon.getTime());
            java.sql.Timestamp datetimeuntil = new Timestamp(UhrzeitBis.getTime());
            
//			java.sql.Date datetimefrom = new java.sql.Date(UhrzeitVon.getTime());
//			java.sql.Date datetimeuntil = new java.sql.Date(UhrzeitBis.getTime());
            preparedStatement.setDate(1, date);
            preparedStatement.setTimestamp(2, datetimefrom);
            preparedStatement.setTimestamp(3, datetimeuntil);
            preparedStatement.setString(4, Sonnenbank);
            preparedStatement.setString(5, KundenName);
            
            
            
            
            

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
    }

    // edit an termin in the DB via a given ID
    public boolean editTermin(int ID, Date Date, Date UhrzeitVon, Date UhrzeitBis, String Sonnenbank, String KundenName) {
        try {

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

            
//            SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//            DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
//            
//            String date = formatdate.format(Date);
//            String from = date + " " + df.format(UhrzeitVon);
//            String until = date + " " + df.format(UhrzeitBis);
            
            // Define SQL Statement
            String insertTableSQL = "UPDATE termin SET Datum = ?, UhrzeitVon =? , UhrzeitBis =?, Sonnenbank =?, Kunde =?  WHERE ID = ?";
           // String insertNOTDYNAMICTableSQL= "UPDATE termin SET Datum = '" + date + "', UhrzeitVon = '" + from + "', UhrzeitBis='" + until + "', Sonnenbank = '" + Sonnenbank + "', Kunde = '" + KundenName + "' WHERE ID = " + ID ;
            
            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            java.sql.Date date = new java.sql.Date(Date.getTime());
            java.sql.Timestamp datetimefrom = new Timestamp(UhrzeitVon.getTime());
            java.sql.Timestamp datetimeuntil = new Timestamp(UhrzeitBis.getTime());
            
//			java.sql.Date datetimefrom = new java.sql.Date(UhrzeitVon.getTime());
//			java.sql.Date datetimeuntil = new java.sql.Date(UhrzeitBis.getTime());
            preparedStatement.setDate(1, date);
            preparedStatement.setTimestamp(2, datetimefrom);
            preparedStatement.setTimestamp(3, datetimeuntil);
            preparedStatement.setString(4, Sonnenbank);
            preparedStatement.setString(5, KundenName);
            preparedStatement.setInt(6, ID);
//
//            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            
            
            return true;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
    }

    // delete an termin in the DB via a given ID
    public boolean deleteTermin(int ID) {
        try {

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

            // Define SQL Statement
            String insertTableSQL = "DELETE FROM termin WHERE ID = ?";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, ID);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
    }

    // Get all termins and store them
    public LinkedList<TerminObject> getAllTermin() {

        try {

            LinkedList<TerminObject> TerminObjectList = new LinkedList<TerminObject>();

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

            // Define SQL Statement
            String selectSQL = "SELECT * FROM termin";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
            // preparedStatement.setString(1, EMail);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery(selectSQL);

            while (rs.next()) {

                TerminObjectList.add(
                        new TerminObject(rs.getInt("ID"),
                                rs.getDate("Datum"),
                                rs.getTimestamp("UhrzeitVon"),
                                rs.getTimestamp("UhrzeitBis"),
                                rs.getString("Sonnenbank"),
                                rs.getString("Kunde"))
                );

            }

            return TerminObjectList;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }


    }

	@Override
	public LinkedList<TerminHoursADayObject> getTerminHoursADay() {
		LinkedList<TerminObject> allTermine =  this.getAllTermin();
        LinkedList<TerminHoursADayObject> terminADay = new LinkedList<>();
        
		for(TerminObject t : allTermine)
		{
			boolean dateExists = false;
			for(TerminHoursADayObject th : terminADay)
			{
				if(th.getDatum().compareTo(t.getDatum())==0) //if date of TerminObject in TerminHoursADayObjectList --> update
				{
					Date d1 = t.getUhrzeitVon();
					Date d2 = t.getUhrzeitBis();
					long diff = Math.abs(d2.getTime() - d1.getTime());
					long diffMinutes = diff/(1000);
					
					th.setAnzahl(th.getAnzahl()+1);
					th.setGesamtdauer(th.getGesamtdauer()+(diffMinutes));
					th.setDurchschnittsdauer(th.getGesamtdauer()/th.getAnzahl());
					dateExists=true;
				}
			}
			if(dateExists == false) //if date of TerminObject not in TerminHoursADayObjectList --> insert
			{
				Date d1 = t.getUhrzeitVon();
				Date d2 = t.getUhrzeitBis();
				long diff = Math.abs(d2.getTime() - d1.getTime());
				long diffMinutes = diff/(1000);
				
				
				TerminHoursADayObject thado = new TerminHoursADayObject();
				thado.setDatum(t.getDatum());
				thado.setAnzahl(1);
				thado.setDurchschnittsdauer(diffMinutes);
				thado.setGesamtdauer(diffMinutes);
				terminADay.add(thado);
			}
		}
		return terminADay;
	}
}
