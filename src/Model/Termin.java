package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;


public class Termin implements ITermin {

    // helper objects for operate with DB
    SqlConfig SqlConfigObj;
    Connection con;

    Date currentDate;

    public Termin() throws SQLException {

        SqlConfigObj =  SqlConfig.getInstance();
        currentDate = new Date();
    }

    // create an termin in the DB
    public boolean createTermin(Date Datum, Date UhrzeitVon, Date UhrzeitBis, String Sonnenbank, String KundenName) {

        try {

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

            // Define SQL Statement
            String insertTableSQL = "INSERT INTO termin ( Datum, Uhrzeitvon, UhrzeitBis, Sonnenbank, Kunde) VALUES (?,?,?,?,?)";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setDate(1, java.sql.Date.valueOf(Datum.toString()));
            preparedStatement.setDate(2, (java.sql.Date) UhrzeitVon);
            preparedStatement.setDate(3, (java.sql.Date) UhrzeitBis);
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

            // Define SQL Statement
            String insertTableSQL = "UPDATE termin SET Datum = ?, UhrzeitVon =? , UhrzeitBis =?, Sonnenbank =?, Kunde =?  WHERE ID = ?";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setDate(1, java.sql.Date.valueOf(Date.toString()));
            preparedStatement.setDate(2, (java.sql.Date) UhrzeitVon);
            preparedStatement.setDate(3, (java.sql.Date) UhrzeitBis);
            preparedStatement.setString(4, Sonnenbank);
            preparedStatement.setString(5, KundenName);
            preparedStatement.setInt(6, ID);

            // execute insert SQL stetement
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
                                rs.getDate("UhrzeitVon"),
                                rs.getDate("UhrzeitBis"),
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
					th.setDurchschnittsdauer(th.getGesamtdauer()/th.getAnzahl());
					th.setGesamtdauer(th.getGesamtdauer()+(diffMinutes));
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
