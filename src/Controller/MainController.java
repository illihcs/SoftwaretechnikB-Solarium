package Controller;

import javax.swing.JFrame;
import org.junit.runners.model.InitializationError;
import View.UserViews.Login;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class MainController {
    public static void main(String[] args) throws InitializationError
    {
        Login loginApplicationUser = new Login();
        loginApplicationUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginApplicationUser.setSize(500, 200);
        loginApplicationUser.setVisible(true);
        loginApplicationUser.setLocationRelativeTo(null);
    }
}
