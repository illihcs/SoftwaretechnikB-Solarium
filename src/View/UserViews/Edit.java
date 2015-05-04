package View.UserViews;

import Controller.TerminController;
import Controller.UserController;
import Model.ApplicationUserObject;
import Model.TerminObject;
import View.TerminViews.OverviewTermin;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by admin on 03.05.2015.
 */
public class Edit extends JFrame {
    ApplicationUserObject to;

    public Edit(ApplicationUserObject user) {
        initComponents(user);
    }

    private void initComponents(ApplicationUserObject u) {
        to = u;
        oben = new javax.swing.JPanel();
        ButtonZurueckZurUebersicht = new javax.swing.JButton();
        mitte = new javax.swing.JPanel();
        LabelDatum = new javax.swing.JLabel();
        TextFieldDatum = new javax.swing.JTextField();
        LabelUhrzeitVon = new javax.swing.JLabel();
        TextFieldUhrzeitVon = new javax.swing.JTextField();
        LabelUhrzeitBis = new javax.swing.JLabel();
        TextFieldUhrzeitBis = new javax.swing.JTextField();
        LabelSonnenbank = new javax.swing.JLabel();
        TextFieldSonnenbank = new javax.swing.JTextField();
        LabelKunde = new javax.swing.JLabel();
        TextFieldKunde = new javax.swing.JTextField();
        unten = new javax.swing.JPanel();
        ButtonSpeichern = new javax.swing.JButton();
        ButtonAbbrechen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Übersicht");
        setSize(800, 500);

        oben.setLayout(new CardLayout());
        ButtonZurueckZurUebersicht.setText("Zurück zur Übersicht");
        ButtonZurueckZurUebersicht.setHorizontalAlignment(SwingConstants.LEFT);
        ButtonZurueckZurUebersicht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonZurueckZurUebersichtActionPerformed(evt);
            }
        });
        oben.add(ButtonZurueckZurUebersicht);
        add(oben, BorderLayout.NORTH);

        mitte.setLayout(new GridLayout(0, 2));

        LabelDatum.setText("Vorname:");
        mitte.add(LabelDatum);

        TextFieldDatum.setText(u.getVorname());
        mitte.add(TextFieldDatum);

        LabelUhrzeitVon.setText("Nachname:");
        mitte.add(LabelUhrzeitVon);

        TextFieldUhrzeitVon.setText(u.getNachname());
        mitte.add(TextFieldUhrzeitVon);

        LabelUhrzeitBis.setText("Geburstag:");
        mitte.add(LabelUhrzeitBis);

        TextFieldUhrzeitBis.setText(u.getGeburtstag().toString());
        mitte.add(TextFieldUhrzeitBis);

        LabelSonnenbank.setText("E-Mail:");
        mitte.add(LabelSonnenbank);

        TextFieldSonnenbank.setText(u.getEmail());
        mitte.add(TextFieldSonnenbank);

        LabelKunde.setText("Passwort:");
        mitte.add(LabelKunde);

        TextFieldKunde.setText(u.getPasswort());
        mitte.add(TextFieldKunde);

        add(mitte, java.awt.BorderLayout.CENTER);


        ButtonSpeichern.setText("Speichern");
        ButtonSpeichern.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ButtonSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSpeichernActionPerformed(evt);
            }
        });

        ButtonAbbrechen.setText("Abbrechen");
        ButtonAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAbbrechenActionPerformed(evt);
            }
        });

        GroupLayout untenLayout = new GroupLayout(unten);
        unten.setLayout(untenLayout);
        untenLayout.setHorizontalGroup(
                untenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(untenLayout.createSequentialGroup()
                                .addContainerGap(316, Short.MAX_VALUE)
                                .addComponent(ButtonSpeichern)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonAbbrechen))
        );
        untenLayout.setVerticalGroup(
                untenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(untenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonSpeichern, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonAbbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(unten, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
    }

    private void ButtonZurueckZurUebersichtActionPerformed(java.awt.event.ActionEvent evt) {
        OverviewUser ot = new OverviewUser();
        ot.setVisible(true);
        this.dispose();
    }

    private void ButtonSpeichernActionPerformed(java.awt.event.ActionEvent evt) {
        UserController controller = new UserController();
        if(controller.editApplicationUser(to.getID(), TextFieldDatum.getText(), TextFieldUhrzeitVon.getText(), LocalDate.parse(TextFieldUhrzeitBis.getText()), TextFieldSonnenbank.getText(), TextFieldKunde.getText().toCharArray()) == true)
        {
            JOptionPane.showMessageDialog(null,
                    "Bearbeiten fertiggestellt!",
                    "Bearbeiten fertig!",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void ButtonAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {
        int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie wirklich abbrechen?", "Abbrechen", JOptionPane.YES_NO_OPTION);
        if (eingabe == 0)
        {
            OverviewUser ot = new OverviewUser();
            ot.setVisible(true);
            this.dispose();
        }
    }

    // Variables declaration - do not modify                     
    private JButton ButtonZurueckZurUebersicht;
    private JButton ButtonSpeichern;
    private JButton ButtonAbbrechen;
    private JLabel LabelDatum;
    private JLabel LabelUhrzeitVon;
    private JLabel LabelUhrzeitBis;
    private JLabel LabelSonnenbank;
    private JLabel LabelKunde;
    private JPanel oben;
    private JPanel mitte;
    private JPanel unten;
    private JTextField TextFieldDatum;
    private JTextField TextFieldUhrzeitVon;
    private JTextField TextFieldUhrzeitBis;
    private JTextField TextFieldSonnenbank;
    private JTextField TextFieldKunde;
    // End of variables declaration                   
}

