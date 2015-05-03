package Model;


import java.sql.*;
import java.time.LocalDate;
<<<<<<< HEAD
import java.time.LocalTime;
=======
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
>>>>>>> origin/master


/**
 * Created by Win7-Dev on 02.05.2015.
 */
public class Termin implements ITermin {

    int ID = 0;
    LocalDate Datum = null;
    LocalDateTime UhrzeitVon = null;
    LocalDateTime UhrzeitBis = null;
    String Sonnenbank = null;
    String Kunde;

    // mySQL Helpers
    public static SqlConfig SqlConf = null;
    Connection con = null;



<<<<<<< HEAD
    public boolean TerminEintragen( LocalDate Datum, LocalTime UhrzeitVon,  LocalTime UhrzeitBis , String Sonnenbank, String KundenName) {
=======
    public boolean TerminEintragen( LocalDate Datum, LocalDateTime UhrzeitVon,  LocalDateTime UhrzeitBis , String Sonnenbank, String KundenName) {
>>>>>>> origin/master
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

    public boolean TerminBearbeiten (int ID, LocalDate DateTime, LocalDateTime  UhrzeitVon, LocalDateTime   UhrzeitBis, String Sonnenbank, String KundenName){
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


    public LinkedList<TerminObject> getAllTermin(){

        try {

            LinkedList<TerminObject> TerminObjectList = new LinkedList<TerminObject>();

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String selectSQL = "SELECT * FROM termin";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
            // preparedStatement.setString(1, EMail);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery(selectSQL );

            while (rs.next()) {


                TerminObjectList.add(
                        new TerminObject( rs.getInt("ID"),
                                        rs.getDate("Datum").toLocalDate(),
                                        rs.getTime("UhrzeitVon").toLocalTime(),
                                        rs.getTime("UhrzeitBis").toLocalTime(),
                                        rs.getString("Sonnenbank"),
                                        rs.getString("Kunde") )
                );

            }

            return TerminObjectList;

        } catch (SQLException ex) {

            throw new  RuntimeException(ex);
        }


    }
}
