package Model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Created by Win7-Dev on 02.05.2015.
 */
public class ApplicationUser implements IApplicationUser {

    int ID = 0;
    String  Vorname;
    String  Nachname;
    LocalDate Geburtstag;
    String Email;
    String Passwort;

    // mySQL Helpers
    public static SqlConfig SqlConf = null;
    Connection con = null;

    public ApplicationUser(String vorname, String nachname, LocalDate geburtstag, String mail, String password) {

        Vorname = vorname;
        Nachname = nachname;
        Geburtstag = geburtstag;
        Email = mail;
        Passwort = password;

        SqlConfig SqlConf = new SqlConfig();
    }



    public boolean  bearbeitenUserDaten(int ID,  String Vorname,  String Nachname , LocalDate Geburtstag,  String EMail,  String Passwort){

        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String insertTableSQL = "UPDATE applicationuser SET Vorname = ?, Nachname =? , Geburtstag =?, Email =?, Passwort =?  WHERE EMail = ?";

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

            throw new  RuntimeException(ex);
        }

    }

    public boolean erstelleUser( String Vorname, String Nachname, LocalDate Geburtstag, String EMail, String Passwort){

        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

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

            throw new  RuntimeException(ex);
            }

    }

    public boolean loescheUser(int ID){
        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String insertTableSQL = "DELE FROM applicationuser WHERE ID = ?";

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

    public boolean login(String EMail, String Password){
        try {

            // Setup SQl connection
            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            // Define SQL Statement
            String selectSQL = "SELECT EMail, Passwort  FROM applicationuser WHERE EMail = ?";

            // Fill SQL Statement
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
            preparedStatement.setString(1, EMail);

            // execute insert SQL stetement
            ResultSet rs = preparedStatement.executeQuery(selectSQL );

            while (rs.next()) {
                String DBEMail = rs.getString("EMail");
                String DBPasswort = rs.getString("Passwort");

                if ( Email == DBEMail &&  Password == DBPasswort ) return true;
            }

            return false;

        } catch (SQLException ex) {

            throw new  RuntimeException(ex);
        }

    }


}




