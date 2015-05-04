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
        JButton ButtonloginApplicationUser = new JButton("loginApplicationUser");
        JButton ButtonClose = new JButton("Close");
        ButtonClose.addActionListener(this);
        ButtonloginApplicationUser.addActionListener(this);
        LabelFehler = new JLabel();
        mitte.add(LabelEMail);
        mitte.add(TextFieldEmail);
        mitte.add(LabelPassword);
        mitte.add(TextFieldPassword);
        mitte.add(ButtonloginApplicationUser);
        mitte.add(ButtonClose);
        mitte.setLayout(new GridLayout(3, 2));
        oben.add(LabelFehler);
        setTitle("loginApplicationUser");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        if (button.getText().equals("loginApplicationUser"))
        {
            UserController controller = new UserController();

            if(controller.loginApplicationUser(TextFieldEmail.getText(), TextFieldPassword.getPassword()) == true)
            {
                OverviewTermin ot = new OverviewTermin();
                ot.setVisible(true);
                this.dispose();
            }else{
                LabelFehler.setSize(this.getWidth(), 50);
                LabelFehler.setText("Deine E-Mail oder dein Passwort war ung�ltig! \nBitte versuche es erneut.");
            }
        }

        if (button.getText().equals("Close"))
        {
            this.dispose();
        }
    }
}
