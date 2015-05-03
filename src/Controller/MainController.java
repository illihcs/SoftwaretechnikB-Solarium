package Controller;

import Model.ApplicationUser;
import View.UserViews.Edit;
import View.UserViews.Login;
import View.UserViews.Register;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
        Login.setLocationRelativeTo(null);
    }
}
