package View.TerminViews;

import Controller.TerminController;
import Model.TerminObject;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by admin on 03.05.2015.
 */
public class EditTermin extends JFrame {
    TerminObject to;

    public EditTermin(TerminObject termin) {
        initComponents(termin);
    }

    private void initComponents(TerminObject t) {
        to = t;
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
        setTitle("Termin Übersicht");
        setSize(800,500);

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

        LabelDatum.setText("LabelDatum");
        mitte.add(LabelDatum);

        TextFieldDatum.setText(t.getDatum().toString());
        mitte.add(TextFieldDatum);

        LabelUhrzeitVon.setText("LabelUhrzeitVon");
        mitte.add(LabelUhrzeitVon);

        TextFieldUhrzeitVon.setText(t.getUhrzeitVon().toString());
        mitte.add(TextFieldUhrzeitVon);

        LabelUhrzeitBis.setText("LabelUhrzeitBis");
        mitte.add(LabelUhrzeitBis);

        TextFieldUhrzeitBis.setText(t.getUhrzeitBis().toString());
        mitte.add(TextFieldUhrzeitBis);

        LabelSonnenbank.setText("LabelSonnenbank");
        mitte.add(LabelSonnenbank);

        TextFieldSonnenbank.setText(t.getSonnenbank());
        mitte.add(TextFieldSonnenbank);

        LabelKunde.setText("LabelKunde");
        mitte.add(LabelKunde);

        TextFieldKunde.setText(t.getKunde());
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
        OverviewTermin ot = new OverviewTermin();
        ot.setVisible(true);
        this.dispose();
    }

    private void ButtonSpeichernActionPerformed(java.awt.event.ActionEvent evt) {
        TerminController controller = new TerminController();
        if(controller.bearbeiteTermin(to.getID(), LocalDate.parse(TextFieldDatum.getText()), LocalDateTime.parse(TextFieldUhrzeitVon.getText()), LocalDateTime.parse(TextFieldUhrzeitBis.getText()), TextFieldSonnenbank.getText(), TextFieldKunde.getText()) == true)
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
            OverviewTermin ot = new OverviewTermin();
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

