package Model;


import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Created by Win7-Dev on 02.05.2015.
 */
public class Termin implements ITermin {

    int ID = 0;
    LocalDate Datum = null;
    LocalDate UhrzeitVon = null;
    LocalDate UhrzeitBis = null;
    int Sonnenbank = 0;
    String Kunde;

    // mySQL Helpers
    public static SqlConfig SqlConf = null;
    Connection con = null;



    public boolean TerminEintragen( LocalDate Datum, LocalDate UhrzeitVon,  LocalDate UhrzeitBis , String Sonnenbank, String KundenName) {
        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String insertTableSQL = "INSERT INTO termin ( Datum, Uhrzeitvon, UhrzeitBis, Sonnenbank, KundenName) VALUES (?,?,?,?,?)";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setDate(1, java.sql.Date.valueOf(Datum.toString()));
            preparedStatement.setDate(2, java.sql.Date.valueOf(UhrzeitVon.toString()));
            preparedStatement.setDate(3, java.sql.Date.valueOf(UhrzeitBis.toString()));
            preparedStatement.setString(4, Sonnenbank);
            preparedStatement.setString(5, KundenName);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException ex) {

            throw new  RuntimeException(ex);
        }
    }

    public boolean TerminBearbeiten (int ID, LocalDate DateTime, LocalDate  UhrzeitVon, LocalDate   UhrzeitBis, String Sonnenbank, String KundenName){
        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

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

            throw new  RuntimeException(ex);
        }
    }

    public boolean TerminLoeschen(int ID){
        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String insertTableSQL = "DELE FROM termin WHERE ID = ?";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, ID);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException ex) {

            throw new  RuntimeException(ex);
        }
      }


}
