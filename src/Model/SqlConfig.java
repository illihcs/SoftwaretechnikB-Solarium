package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlConfig {

    private String user = null;
    private String password = null;
    private static SqlConfig _Instance = null;
    private String url = null;
    private Connection con = null;

    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getUrl() {
        return url;
    }
    public Connection getCon() {
        return con;
    }




    private SqlConfig() throws SQLException {

        url = "jdbc:mysql://localhost:3306/solardb";
        user = "root";
        password = "root";
        con =  DriverManager.getConnection(getUrl(), getUser(), getPassword());

    }

    public static SqlConfig getInstance () throws SQLException {

        if (_Instance == null) {
        	_Instance = new SqlConfig ();
        }

        return _Instance;
    }

}
