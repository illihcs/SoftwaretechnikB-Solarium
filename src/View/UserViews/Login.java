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
    JPanel oben;
    JPanel mitte;
    JLabel LabelFehler;

    public Login()
    {
        initComponents();

        // Testen ob SQL abfragen funktionieren
        SQLTESTER SQLTESTERobj = new SQLTESTER();



    }

    private void initComponents() {
        setLayout(new BorderLayout());
        oben = new JPanel();
        mitte = new JPanel();
        add(oben, BorderLayout.NORTH);
        add(mitte, BorderLayout.CENTER);

        JLabel LabelEMail = new JLabel("E-Mail:");
        JLabel LabelPassword = new JLabel("Password:");
        TextFieldEmail = new JTextField();
        TextFieldPassword = new JPasswordField();
        JButton ButtonLogin = new JButton("Login");
        JButton ButtonClose = new JButton("Close");
        ButtonClose.addActionListener(this);
        ButtonLogin.addActionListener(this);
        LabelFehler = new JLabel();
        mitte.add(LabelEMail);
        mitte.add(TextFieldEmail);
        mitte.add(LabelPassword);
        mitte.add(TextFieldPassword);
        mitte.add(ButtonLogin);
        mitte.add(ButtonClose);
        mitte.setLayout(new GridLayout(3, 2));
        oben.add(LabelFehler);
        setTitle("Login");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        if (button.getText().equals("Login"))
        {
            UserController controller = new UserController();

            if(controller.Login(TextFieldEmail.getText(), TextFieldPassword.getPassword()) == true)
            {
                OverviewTermin ot = new OverviewTermin();
                ot.setVisible(true);
                this.dispose();
            }else{
                LabelFehler.setSize(this.getWidth(), 50);
                LabelFehler.setText("Deine E-Mail oder dein Passwort war ungültig! \nBitte versuche es erneut.");
            }
        }

        if (button.getText().equals("Close"))
        {
            this.dispose();
        }
    }
}
