package Controller;

import java.sql.SQLException;

import org.junit.runners.model.InitializationError;

import View.ObserverViews.TerminHoursADay;
import View.TerminViews.OverviewTermin;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class MainController {
    public static void main(String[] args) throws InitializationError, SQLException
    {
//        Login loginApplicationUser = new Login();
//        loginApplicationUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        loginApplicationUser.setSize(500, 200);
//        loginApplicationUser.setVisible(true);
//        loginApplicationUser.setLocationRelativeTo(null);
        
        OverviewTermin ot = new OverviewTermin();
        ot.setVisible(true);
        
        TerminHoursADay thadV = new TerminHoursADay();
        TerminController.getInstance().addObserver(thadV);
        thadV.setVisible(true);
    }
}
