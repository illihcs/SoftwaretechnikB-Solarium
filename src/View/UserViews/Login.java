package View.UserViews;

import Controller.UserController;
import Model.SQLTESTER;
import View.TerminViews.OverviewTermin;

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
    JPanel top;
    JPanel center;
    JLabel LabelFailure;

    public Login()
    {
        initComponents();

        // Testen ob SQL abfragen funktionieren
        SQLTESTER SQLTESTERobj = new SQLTESTER();

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

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        if (button.getText().equals("Login"))
        {
            UserController controller = new UserController();

            if(controller.loginApplicationUser(TextFieldEmail.getText(), TextFieldPassword.getPassword()) == true)
            {
                OverviewTermin ot = new OverviewTermin();
                ot.setVisible(true);
                this.dispose();
            }else{
                LabelFailure.setSize(this.getWidth(), 50);
                LabelFailure.setForeground(Color.RED);
                LabelFailure.setText("Deine E-Mail oder dein Passwort war ungültig! \nBitte versuche es erneut.");
            }
        }

        if (button.getText().equals("Close"))
        {
            this.dispose();
        }
    }
}
