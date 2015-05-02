package Controller;

import View.UserViews.Login;
import View.UserViews.Register;

import javax.swing.*;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class MainController {
    public static void main(String[] args)
    {
        Login Login = new Login();
        Login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Login.setSize(400, 200);
        Login.setVisible(true);
        Register Register = new Register();
        Register.setSize(1000, 750);
        Register.setVisible(true);
    }
}
