package View;

import Controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class Login extends JFrame implements ActionListener{

    JTextField TextFieldEmail;
    JPasswordField TextFieldPassword;


    public Login()
    {
        initComponents();
    }

    private void initComponents() {
        JLabel LabelEMail = new JLabel("E-Mail:");
        JLabel LabelPassword = new JLabel("Password:");
        TextFieldEmail = new JTextField();
        TextFieldPassword = new JPasswordField();
        JButton ButtonLogin = new JButton("Login");
        JButton ButtonClose = new JButton("Close");
        ButtonClose.addActionListener(this);
        ButtonLogin.addActionListener(this);
        add(LabelEMail);
        add(TextFieldEmail);
        add(LabelPassword);
        add(TextFieldPassword);
        add(ButtonLogin);
        add(ButtonClose);
        setLayout(new GridLayout(3,2));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Login"))
        {
            UserController controller = new UserController();
            controller.Login(TextFieldEmail.getText(), TextFieldPassword.getPassword());
        }
        if (button.getText().equals("Close"))
        {
            this.dispose();
        }
    }
}
