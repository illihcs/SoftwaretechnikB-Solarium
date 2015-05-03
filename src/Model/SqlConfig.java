package Model;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public   class SqlConfig {

    public static String url = null;
    public static  String user = null;
    public static String password = null;

    public  SqlConfig(){

            url = "jdbc:mysql://localhost:3306/solardb";
             user = "root";
            password = "root";

    }

}
