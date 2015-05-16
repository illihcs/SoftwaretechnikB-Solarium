package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlConfig {

    private static String user = null;
    private static String password = null;
    private static SqlConfig instance = null;
    private static String url = null;
    private static Connection con = null;

    public static String getUser() {
        return user;
    }
    public static String getPassword() {
        return password;
    }
    public static String getUrl() {
        return url;
    }
    public static Connection getCon() {
        return con;
    }




    private SqlConfig() throws SQLException {

        url = "jdbc:mysql://localhost:3306/solardb";
        user = "root";
        password = "root";
        con =  DriverManager.getConnection(getUrl(), getUser(), getPassword());

    }

    public static SqlConfig getInstance () throws SQLException {

        if (SqlConfig.instance == null) {
            SqlConfig.instance = new SqlConfig ();
        }

        return SqlConfig.instance;
    }

}
