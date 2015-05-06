package View.UserViews;

import Controller.UserController;
import Model.ApplicationUserObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Created by admin on 03.05.2015.
 */
public class Edit extends JFrame {
    ApplicationUserObject userObject;

    public Edit(ApplicationUserObject user) {
        initComponents(user);
    }

    private void initComponents(ApplicationUserObject user) {
        userObject = user;

        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();

        ButtonBackToUserOverview = new JButton();
       
        LabelGivenname = new JLabel();
        TextFieldGivenname = new JTextField();
        LabelSurname = new JLabel();
        TextFieldSurname = new JTextField();
        LabelBirthday = new JLabel();
        TextFieldBirthday = new JTextField();
        LabelMail = new JLabel();
        TextFieldMail = new JTextField();
        LabelPassword = new JLabel();
        TextFieldPassword = new JTextField();
        ButtonSave = new JButton();
        ButtonAbort = new JButton();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Bearbeiten Sie die zu ändernden Werte.");
        setSize(800, 500);

        //init top
        top.setLayout(new CardLayout());

        ButtonBackToUserOverview.setText("Zurück zur Übersicht");
        ButtonBackToUserOverview.setHorizontalAlignment(SwingConstants.LEFT);
        ButtonBackToUserOverview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonBackToUserOverviewActionPerformed(evt);
            }
        });

        top.add(ButtonBackToUserOverview);
        add(top, BorderLayout.NORTH);
        //init top end

        //init center
        center.setLayout(new GridLayout(0, 2));

        LabelGivenname.setText("Vorname:");
        center.add(LabelGivenname);
        TextFieldGivenname.setText(user.getVorname());
        center.add(TextFieldGivenname);

        LabelSurname.setText("Nachname:");
        center.add(LabelSurname);
        TextFieldSurname.setText(user.getNachname());
        center.add(TextFieldSurname);

        LabelBirthday.setText("Geburstag:");
        center.add(LabelBirthday);
        TextFieldBirthday.setText(user.getGeburtstag().toString());
        center.add(TextFieldBirthday);

        LabelMail.setText("E-Mail:");
        center.add(LabelMail);
        TextFieldMail.setText(user.getEmail());
        center.add(TextFieldMail);

        LabelPassword.setText("Passwort:");
        center.add(LabelPassword);
        TextFieldPassword.setText(user.getPasswort());
        center.add(TextFieldPassword);

        add(center, BorderLayout.CENTER);
        //init center end

        //init bottom
        ButtonSave.setText("Speichern");
        ButtonSave.setHorizontalTextPosition(SwingConstants.LEADING);
        ButtonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });

        ButtonAbort.setText("Abbrechen");
        ButtonAbort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonAbortActionPerformed(evt);
            }
        });

        //copied out of Internet
        GroupLayout bottomLayout = new GroupLayout(bottom);
        bottom.setLayout(bottomLayout);
        bottomLayout.setHorizontalGroup(
                bottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bottomLayout.createSequentialGroup()
                                .addContainerGap(316, Short.MAX_VALUE)
                                .addComponent(ButtonSave)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonAbort))
        );
        bottomLayout.setVerticalGroup(
                bottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bottomLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonSave, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonAbort, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        );

        add(bottom, BorderLayout.SOUTH);
        //init bottom end

        setLocationRelativeTo(null);
    }

    private void ButtonBackToUserOverviewActionPerformed(java.awt.event.ActionEvent evt) {
        OverviewUser overviewUser = new OverviewUser();
        overviewUser.setVisible(true);
        this.dispose();
    }

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        UserController controller = new UserController();
        if(controller.editApplicationUser(userObject.getID(), TextFieldGivenname.getText(), TextFieldSurname.getText(), LocalDate.parse(TextFieldBirthday.getText()), TextFieldMail.getText(), TextFieldPassword.getText().toCharArray()) == true)
        {
            JOptionPane.showMessageDialog(null,
                    "Bearbeiten fertiggestellt!",
                    "Bearbeiten fertig!",
                    JOptionPane.WARNING_MESSAGE);
            OverviewUser overviewUser = new OverviewUser();
            overviewUser.setVisible(true);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Registrierung fehlgeschlagen!",
                    "Registrierung Fehler!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void ButtonAbortActionPerformed(java.awt.event.ActionEvent evt) {
        int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie wirklich abbrechen?", "Abbrechen", JOptionPane.YES_NO_OPTION);
        if (eingabe == 0)
        {
            OverviewUser overviewUser = new OverviewUser();
            overviewUser.setVisible(true);
            this.dispose();
        }
    }

    // Variables declaration - do not modify                     
    private JButton ButtonBackToUserOverview;
    private JButton ButtonSave;
    private JButton ButtonAbort;
    private JLabel LabelGivenname;
    private JLabel LabelSurname;
    private JLabel LabelBirthday;
    private JLabel LabelMail;
    private JLabel LabelPassword;
    private JPanel top;
    private JPanel center;
    private JPanel bottom;
    private JTextField TextFieldGivenname;
    private JTextField TextFieldSurname;
    private JTextField TextFieldBirthday;
    private JTextField TextFieldMail;
    private JTextField TextFieldPassword;
    // End of variables declaration                   
}

