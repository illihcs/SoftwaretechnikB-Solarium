package View.UserViews;

import Controller.TerminController;
import Controller.UserController;
import View.ObserverViews.TerminHoursADay;
import View.TerminViews.OverviewTermin;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Schillemans on 01.05.2015.
 */
public class Login extends JFrame implements ActionListener {

    JTextField TextFieldEmail;
    JPasswordField TextFieldPassword;
    JPanel top;
    JPanel center;
    JLabel LabelFailure;

    public Login() {
        initComponents();

    }

    private void initComponents() {
        setLayout(new BorderLayout());
        top = new JPanel();
        center = new JPanel();
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);

        JLabel LabelEMail = new JLabel("E-Mail:");
        JLabel LabelPassword = new JLabel("Passwort:");
        TextFieldEmail = new JTextField();
        TextFieldPassword = new JPasswordField();
        JButton ButtonloginApplicationUser = new JButton("Login");
        JButton ButtonClose = new JButton("Close");
        ButtonClose.addActionListener(this);
        ButtonloginApplicationUser.addActionListener(this);
        LabelFailure = new JLabel();
        center.add(LabelEMail);
        center.add(TextFieldEmail);
        center.add(LabelPassword);
        center.add(TextFieldPassword);
        center.add(ButtonloginApplicationUser);
        center.add(ButtonClose);
        center.setLayout(new GridLayout(3, 2));
        top.add(LabelFailure);
        setTitle("Login");
    }


    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Login")) {

            try {

                String Email = TextFieldEmail.getText();
                String Password = String.valueOf(TextFieldPassword.getPassword());


                if (Email.isEmpty()) throw new RuntimeException("Bitte eine Email angeben!");
                if (Password.isEmpty()) throw new RuntimeException("Bitte eine Passwort angeben!");

                UserController controller = new UserController();

                boolean applicationUserLogedin = controller.loginApplicationUser(TextFieldEmail.getText(), TextFieldPassword.getPassword());

                if (applicationUserLogedin) {
                    OverviewTermin ot = new OverviewTermin();
                    ot.setVisible(true);
                    
                    TerminHoursADay thadV = new TerminHoursADay();
                    TerminController.getInstance().addObserver(thadV);
                    thadV.setVisible(true);
                    this.dispose();

                } else {

                    throw new RuntimeException("Login nicht möglich");

                }


            } catch (Exception ex) {

                LabelFailure.setSize(this.getWidth(), 50);
                LabelFailure.setForeground(Color.RED);
                LabelFailure.setText(ex.getMessage());

            }
        }

        if (button.getText().equals("Close")) {
            this.dispose();
        }
    }
}
