package Controller;

import Model.ApplicationUser;
import View.UserViews.Login;

import javax.swing.*;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class MainController {
    public static void main(String[] args)
    {

        // WORKAROUND::  DB connection test, should return DB version in the console as info
        ApplicationUser test = new ApplicationUser();
        test.erstelleUser(null, null, null, null, null);

        Login Login = new Login();
        Login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Login.setSize(400, 200);
        Login.setVisible(true);
    }
}
