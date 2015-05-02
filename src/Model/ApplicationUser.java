package Model;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Created by Win7-Dev on 02.05.2015.
 */
public class ApplicationUser implements IApplicationUser {

    int ID = 0;
    String  Vorname;
    String  Nachname;
    LocalDateTime Geburtstag;
    String Email;
    String Passwort;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/solardb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public void  bearbeitenUserDaten( String Vorname,  String Nachname , LocalDateTime Geburtstag,  String Mail,  String Passwort){




    }

    public   void erstelleUser( String Vorname, String Nachname, LocalDateTime Geburtstag, String Mail, String Passwort){

        Connection conn = null;
        Statement stmt = null;

        try{
            //STEP 2: Register JDBC driver
           //  Class.forName("com.mysql.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "INSERT INTO  applicationuser (Vorname, Nachname, Geburtstrag, Email, Passwort) " +
                         "Values('Vorname', 'Nachname', 'Geburtstrag', 'Email', 'Passwort')";

            stmt.executeUpdate(sql);

            conn.close();

        }catch(SQLException se){

        }
    }

    public void löscheUser(int ID){

    }

    public void login( String Email, String Password){

    }


}




