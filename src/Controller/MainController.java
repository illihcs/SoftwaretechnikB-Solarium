package Controller;

import JUnit.TerminTest;
import Model.SqlConfig;
import View.UserViews.Login;

import javax.swing.*;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.JUnit4;
import org.junit.runners.model.InitializationError;

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
