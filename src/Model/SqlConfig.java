package Model;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class SqlConfig {

    public String url = null;
    public String user = null;
    public String password = null;

    public SqlConfig() {

        url = "jdbc:mysql://localhost:3306/solardb";
        user = "root";
        password = "root";

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
