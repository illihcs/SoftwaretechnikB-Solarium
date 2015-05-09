package Model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Termin implements ITermin {

    int ID;
    LocalDate Datum;
    LocalDateTime UhrzeitVon;
    LocalDateTime UhrzeitBis;
    String Sonnenbank;
    String Kunde;

    // helper objects for operate with DB
    SqlConfig SqlConf;
    Connection con;

    public Termin() {

        SqlConf = new SqlConfig();
    }

    // create an termin in the DB
    public boolean createTermin(LocalDate Datum, LocalDateTime UhrzeitVon, LocalDateTime UhrzeitBis, String Sonnenbank, String KundenName) {
        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.getUrl(), SqlConf.getUser(), SqlConf.getPassword());

            // Define SQL Statement
            String insertTableSQL = "INSERT INTO termin ( Datum, Uhrzeitvon, UhrzeitBis, Sonnenbank, KundenName) VALUES (?,?,?,?,?)";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setDate(1, java.sql.Date.valueOf(Datum.toString()));
            String from = UhrzeitVon.toString();
            from = from.replace('T', ' ');
            String until = UhrzeitVon.toString();
            until = until.replace('T', ' ');
            preparedStatement.setDate(2, java.sql.Date.valueOf(from));
            preparedStatement.setDate(3, java.sql.Date.valueOf(until));
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
    public boolean editTermin(int ID, LocalDate DateTime, LocalDateTime UhrzeitVon, LocalDateTime UhrzeitBis, String Sonnenbank, String KundenName) {
        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.getUrl(), SqlConf.getUser(), SqlConf.getPassword());

            // Define SQL Statement
            String insertTableSQL = "UPDATE termin SET DateTime = ?, UhrzeitVon =? , UhrzeitBis =?, Sonnenbank =?, KundenName =?  WHERE ID = ?";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setDate(1, java.sql.Date.valueOf(DateTime.toString()));
            preparedStatement.setDate(2, java.sql.Date.valueOf(UhrzeitVon.toString()));
            preparedStatement.setDate(3, java.sql.Date.valueOf(UhrzeitBis.toString()));
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
            con = DriverManager.getConnection(SqlConf.getUrl(), SqlConf.getUser(), SqlConf.getPassword());

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
            con = DriverManager.getConnection(SqlConf.getUrl(), SqlConf.getUser(), SqlConf.getPassword());

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
