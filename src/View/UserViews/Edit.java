package View.UserViews;

import Controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 02.05.2015.
 */
public class Edit extends JFrame implements ActionListener {


    JLabel LabelVorname;
    JLabel LabelNachname;
    JLabel LabelGeburstag;
    JLabel LabelMail;
    JLabel LabelPassword;
    JTextField TextFieldVorname;
    JTextField TextFieldNachname;
    JTextField TextFieldGeburtstag;
    JTextField TextFieldMail;
    JPasswordField TextFieldPassword;
    JButton ButtonSpeichern;
    JButton ButtonAbbrechen;

    public Edit()
    {
        initComponents();
    }

    private void initComponents() {
        LabelVorname = new JLabel("Vorname:");
        LabelNachname = new JLabel("Nachname:");
        LabelGeburstag = new JLabel("Geburtstag:");
        LabelMail = new JLabel("E-Mail:");
        LabelPassword = new JLabel("Passwort:");
        TextFieldVorname = new JTextField();
        TextFieldNachname = new JTextField();
        TextFieldGeburtstag =new JTextField();
        TextFieldMail = new JTextField();
        TextFieldPassword = new JPasswordField();
        add(LabelVorname);
        add(TextFieldVorname);
        add(LabelNachname);
        add(TextFieldNachname);
        add(LabelGeburstag);
        add(TextFieldGeburtstag);
        add(LabelMail);
        add(TextFieldMail);
        add(LabelPassword);
        add(TextFieldPassword);
        ButtonSpeichern = new JButton("Speichern");
        ButtonAbbrechen = new JButton("Abbrechen");
        add(ButtonSpeichern);
        add(ButtonAbbrechen);
        setLayout(new GridLayout(6,2));
        setSize(1000,800);
        setTitle("Bearbeite Benutzer");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == ButtonAbbrechen)
        {
            //TODO: Irgendwas muss beim Abbrechen passieren!!
        }
        if (button == ButtonSpeichern)
        {
            UserController controller = new UserController();
            controller.Register(TextFieldVorname.getText(), TextFieldNachname.getText(), TextFieldGeburtstag.getText(),TextFieldMail.getText(), TextFieldPassword.getPassword());
        }
    }
}