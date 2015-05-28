package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;


public class ApplicationUser implements IApplicationUser {
    // helper objects for operate with DB
    Connection con = null;
    SqlConfig SqlConfigObj;

    public ApplicationUser() throws SQLException {
        SqlConfigObj =  SqlConfig.getInstance();
    }

    // Edit application user data's in DB
    public boolean editApplicationUser(int ID, String Vorname, String Nachname, Date Geburtstag, String EMail, String Passwort) {

        try {

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

            // Define SQL Statement
            String insertTableSQL = "UPDATE applicationuser SET Vorname = ?, Nachname =? , Geburtstag =?, Email =?, Passwort =?  WHERE EMail = ?";

            // Fill SQL Statement
           PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, Vorname);
            preparedStatement.setString(2, Nachname);
            preparedStatement.setDate(3, java.sql.Date.valueOf(Geburtstag.toString()));
            preparedStatement.setString(4, EMail);
            preparedStatement.setString(5, Passwort);
            preparedStatement.setString(6, EMail);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }

    }

    // Creates a new application user in DB
    public boolean createApplicationUser(String Vorname, String Nachname, Date Geburtstag, String EMail, String Passwort) {

        try {

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

            // Define SQL Statement
            String insertTableSQL = "INSERT INTO applicationuser ( Vorname, Nachname, Geburtstag, Email, Passwort) VALUES (?,?,?,?,?)";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, Vorname);
            preparedStatement.setString(2, Nachname);
            preparedStatement.setDate(3, java.sql.Date.valueOf(Geburtstag.toString()));
            preparedStatement.setString(4, EMail);
            preparedStatement.setString(5, Passwort);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }

    }

    // delete an user in the DB via a given ID
    public boolean deleteApplicationUser(int ID) {
        try {

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

            // Define SQL Statement
            String insertTableSQL = "DELETE FROM applicationuser WHERE ID = ?";

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

    // Find and check user credentials in DB
    public boolean loginApplicationUser(String loginApplicationUserEMail, String loginApplicationUserPassword) {
        try {

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

            // Define SQL Statement
            String selectSQL = "SELECT * FROM applicationuser";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
            // preparedStatement.setString(1, EMail);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery(selectSQL);

            while (rs.next()) {
                String DBEMail = rs.getString("EMail");
                String DBPasswort = rs.getString("Passwort");

                // Wenn GUI values und DB values übereinstimmen
                if (new String(loginApplicationUserEMail).equals(DBEMail) && new String(loginApplicationUserPassword).equals(DBPasswort))
                    return true;
            }

            return false;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }

    }

    // Get all application User and store them
    public LinkedList<ApplicationUserObject> getAllApplicationUser() {

        try {

            LinkedList<ApplicationUserObject> ApplicationUserObjectList = new LinkedList<ApplicationUserObject>();

            // Setup SQl connection
            con = SqlConfig.getInstance().getCon();

            // Define SQL Statement
            String selectSQL = "SELECT * FROM applicationuser";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
            // preparedStatement.setString(1, EMail);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery(selectSQL);

            while (rs.next()) {


                ApplicationUserObjectList.add(
                        new ApplicationUserObject(

                                rs.getInt("ID"),
                                rs.getString("Vorname"),
                                rs.getString("Nachname"),
                                rs.getDate("Geburtstag"),
                                rs.getString("EMail"),
                                rs.getString("Passwort")
                        )
                );

            }

            return ApplicationUserObjectList;

        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }


    }

}




