package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

 
public class Sonnenbank implements ISonnenbank {
    // helper objects for operate with DB
    SqlConfig SqlConfigObj;
    private Connection con;

    public Sonnenbank() throws SQLException {
        SqlConfigObj =  SqlConfig.getInstance();
    }

    // create a sonnenbank in the DB
    public boolean createSonnenbank(String Kabine, String Leistung, Date Wartungstermin) {

        try {

            // Setup SQl connection
            con = SqlConfig.getCon();

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

            throw new RuntimeException(ex);
        }
    }

    // edit a sonnenbank in the DB via a given ID
    public boolean editSonnenbank(int ID, String Kabine, String Leistung, Date Wartungstermin) {

        try {

            // Setup SQl connection
            con = SqlConfig.getCon();

            // Define SQL Statement
            String insertTableSQL = "UPDATE sonnenbank SET Kabine = ?, Leistung =? , Wartungstermin =?  WHERE ID = ?";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, Kabine);
            preparedStatement.setString(2, Leistung);
            preparedStatement.setDate(3, java.sql.Date.valueOf(Wartungstermin.toString()));
            preparedStatement.setInt(4, ID);
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }

    }

    // delete an sonnenbank in the DB via a given ID
    public boolean deleteSunbed(int ID) {

        try {

            // Setup SQl connection
            con = SqlConfig.getCon();


            // Define SQL Statement
            String insertTableSQL = "DELETE FROM sonnenbank WHERE ID = ?";

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

    // Get all sonnenbanken and store them
    public LinkedList<SonnenbankObject> getAllSonnenbank() {

        try {

            LinkedList<SonnenbankObject> SonnenbankObjectList = new LinkedList<SonnenbankObject>();

            // Setup SQl connection
            con = SqlConfig.getCon();

            // Define SQL Statement
            String selectSQL = "SELECT * FROM sonnenbank";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
            // preparedStatement.setString(1, EMail);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery(selectSQL);

            while (rs.next()) {


                SonnenbankObjectList.add(
                        new SonnenbankObject(rs.getInt("ID"), rs.getString("Kabine"), rs.getString("Leistung"), rs.getDate("Wartungstermin"))
                );

            }

            return SonnenbankObjectList;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }


    }
}
