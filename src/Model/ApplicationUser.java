package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;



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

    // JDBC driver name and database URL   mysql-connector-java-5.1.35-bin.jar
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/solardb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public void  bearbeitenUserDaten( String Vorname,  String Nachname , LocalDateTime Geburtstag,  String Mail,  String Passwort){




    }

    public   void erstelleUser( String Vorname, String Nachname, LocalDateTime Geburtstag, String Mail, String Passwort){



        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/solardb";
        String user = "root";
        String password = "root";

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {



        } finally {



            }

    }

    public void loescheUser(int ID){

    }

    public void login( String Email, String Password){

    }


}




