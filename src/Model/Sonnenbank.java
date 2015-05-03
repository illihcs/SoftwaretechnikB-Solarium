package Model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Win7-Dev on 02.05.2015.
 */



public class Sonnenbank implements ISonnenbank
{

    int ID = 0;
    String Kabine = null;
    String Leistung = null;
    LocalDateTime Wartungstermin = null;

    // mySQL Helpers
    public static SqlConfig SqlConf = null;
    Connection con = null;

    public Sonnenbank(){

    }

    public boolean erstelleSonnenbank( String Kabine,  String  Leistung,  LocalDate Wartungstermin){

        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String insertTableSQL = "INSERT INTO sonnenbank ( Kabine, Leistung, Wartungstermin) VALUES (?,?,?)";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, Kabine);
            preparedStatement.setString(2, Leistung);
            preparedStatement.setDate(3, java.sql.Date.valueOf(Wartungstermin.toString()));

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException ex) {

            throw new  RuntimeException(ex);
        }
   }

    public boolean bearbeiteSonnenbank(int ID, String Kabine,  String Leistung,  LocalDate Wartungstermin){

        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String insertTableSQL = "UPDATE sonnenbank SET Kabine = ?, Leistung =? , Wartungstermin =?  WHERE ID = ?";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, Kabine);
            preparedStatement.setString(2, Leistung);
            preparedStatement.setDate(3, java.sql.Date.valueOf(Wartungstermin.toString()));

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException ex) {

            throw new  RuntimeException(ex);
        }

    }

    public boolean loescheSonnenbank(int ID){

        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String insertTableSQL = "DELE FROM sonnenbank WHERE ID = ?";

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


    public LinkedList<SonnenbankObject> getAllSonnenbank(){

        try {

            LinkedList<SonnenbankObject> SonnenbankObjectList = new LinkedList<SonnenbankObject>();

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String selectSQL = "SELECT * FROM sonnenbank";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
            // preparedStatement.setString(1, EMail);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery(selectSQL );

            while (rs.next()) {


                SonnenbankObjectList.add(
                        new SonnenbankObject( rs.getInt("ID"), rs.getString("Kabine"), rs.getString("Leistung"), rs.getDate("Wartungstermin").toLocalDate())
                );

            }

            return SonnenbankObjectList;

        } catch (SQLException ex) {

            throw new  RuntimeException(ex);
        }


    }



}
