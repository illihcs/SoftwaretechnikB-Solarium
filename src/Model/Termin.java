package Model;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import  java.util.Date;


public class Termin implements ITermin {

    int ID;
    LocalDate Datum;
    LocalDateTime UhrzeitVon;
    LocalDateTime UhrzeitBis;
    String Sonnenbank;
    String Kunde;

    // helper objects for operate with DB
    SqlConfig SqlConfigObj;
    Connection con;

    Date currentDate;

    public Termin() throws SQLException {

        SqlConfigObj =  SqlConfig.getInstance();
        currentDate = new Date();
    }

    // create an termin in the DB
    public boolean createTermin(LocalDate Datum, LocalTime UhrzeitVon, LocalTime UhrzeitBis, String Sonnenbank, String KundenName) {

        try {

            // Setup SQl connection
            con = SqlConfig.getCon();

            // Define SQL Statement
            String insertTableSQL = "INSERT INTO termin ( Datum, Uhrzeitvon, UhrzeitBis, Sonnenbank, Kunde) VALUES (?,?,?,?,?)";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setDate(1, java.sql.Date.valueOf(Datum.toString()));
            preparedStatement.setTime(2, Time.valueOf(UhrzeitVon.toString()));
            preparedStatement.setTime(3, Time.valueOf(UhrzeitBis.toString()));
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
    public boolean editTermin(int ID, LocalDate DateTime, LocalTime UhrzeitVon, LocalTime UhrzeitBis, String Sonnenbank, String KundenName) {
        try {

            // Setup SQl connection
            con = SqlConfig.getCon();

            // Define SQL Statement
            String insertTableSQL = "UPDATE termin SET Datum = ?, UhrzeitVon =? , UhrzeitBis =?, Sonnenbank =?, Kunde =?  WHERE ID = ?";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setDate(1, java.sql.Date.valueOf(DateTime.toString()));
            preparedStatement.setTime(2, Time.valueOf(UhrzeitVon.toString()));
            preparedStatement.setTime(3, Time.valueOf(UhrzeitBis.toString()));
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
            con = SqlConfig.getCon();

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
            con = SqlConfig.getCon();

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
                                rs.getDate("Datum").toLocalDate(),
                                rs.getTime("UhrzeitVon").toLocalTime(),
                                rs.getTime("UhrzeitBis").toLocalTime(),
                                rs.getString("Sonnenbank"),
                                rs.getString("Kunde"))
                );

            }

            return TerminObjectList;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }


    }
}
