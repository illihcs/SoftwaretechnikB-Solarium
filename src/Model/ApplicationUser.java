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

    public static SqlConfig SqlConf = null;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public ApplicationUser(String vorname, String nachname, LocalDate geburtstag, String mail, String password) {
        Vorname = vorname;
        Nachname = nachname;
        Geburtstag = geburtstag;
        Email = mail;
        Passwort = password;

        SqlConfig SqlConf = new SqlConfig();
    }



    public boolean  bearbeitenUserDaten(int ID,  String Vorname,  String Nachname , LocalDate Geburtstag,  String Mail,  String Passwort){
        //TODO: bearbeite UserDaten
        return  true;
    }

    public   boolean erstelleUser( String Vorname, String Nachname, LocalDate Geburtstag, String Mail, String Passwort){

        try {

            con = DriverManager.getConnection(SqlConf.url, SqlConf.user, SqlConf.password);

            String insertTableSQL = "INSERT INTO applicationuser ( Vorname, Nachname, Geburtstag, Email, Passwort) VALUES (?,?,?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, "mkyong");
            preparedStatement.setString(2, "mkyong");
            preparedStatement.setDate(3, java.sql.Date.valueOf("2013-09-04"));
            preparedStatement.setString(4, "mkyong");
            preparedStatement.setString(5, "mkyong");

            // execute insert SQL stetement
            preparedStatement .executeUpdate();

          //  st = con.createStatement();
            return  true;

        } catch (SQLException ex) {

            throw new  RuntimeException(ex);
            }

    }

    public boolean loescheUser(int ID){
        //TODO: lösche User
        return  true;
    }

    public boolean login(String Email, String Password){
        //TODO: Login User --> muss aber boolean sein
        return true;
    }


}




