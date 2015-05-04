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
        Login loginApplicationUser = new Login();
        loginApplicationUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginApplicationUser.setSize(400, 200);
        loginApplicationUser.setVisible(true);
        loginApplicationUser.setLocationRelativeTo(null);
    }
}
