package View.TerminViews;

import Controller.TerminController;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by admin on 03.05.2015.
 */
public class CreateTermin extends JFrame implements ActionListener{

    //Panels for Title and Create
    JPanel oben;
    JPanel mitte;
    JPanel unten;

    //Compnents
    JButton ButtonSpeichern;
    JButton ButtonAbbrechen;
    JLabel LabelTitle;
    JLabel LabelFehlermeldung;
    JLabel LabelDatum;
    JLabel LabelUhrzeitVon;
    JLabel LabelUhrzeitBis;
    JLabel LabelSonnenbank;
    JLabel LabelKunde;
    JTextField TextFieldDatum;
    JTextField TextFieldUhrzeitVon;
    JTextField TextFieldUhrzeitBis;
    JTextField TextFieldSonnenbank;
    JTextField TextFieldKunde;

    //Controller initialized
    TerminController ControllerTermin = new TerminController();

    public CreateTermin()
    {
        initComponents();
    }

    private void initComponents() {
        //create Controller
        //ControllerTermin = new TerminController();

        //create Components
        oben = new JPanel();
        mitte = new JPanel();
        unten = new JPanel();
        ButtonSpeichern = new JButton("Speichern");
        ButtonAbbrechen = new JButton("Abbrechen");
        LabelTitle = new JLabel("Bitte tragen Sie die Termininformationen ein, um den Termin zu erstellen.");
        LabelFehlermeldung = new JLabel();
        LabelDatum = new JLabel("Datum:");
        LabelUhrzeitVon = new JLabel("Uhrzeit Von:");
        LabelUhrzeitBis = new JLabel("Uhrezit Bis:");
        LabelSonnenbank = new JLabel("Sonnenbank:");
        LabelKunde = new JLabel("Kundenname:");
        TextFieldDatum = new JTextField();
        TextFieldUhrzeitVon = new JTextField();
        TextFieldUhrzeitBis = new JTextField();
        TextFieldSonnenbank = new JTextField();
        TextFieldKunde = new JTextField();

        //add Components
        setLayout(new BorderLayout());
        add(oben, BorderLayout.NORTH);
        add(mitte, BorderLayout.CENTER);

        oben.add(LabelTitle);

        mitte.setLayout(new GridLayout(0, 2));

        LabelDatum.setText("LabelDatum");
        mitte.add(LabelDatum);

        mitte.add(TextFieldDatum);

        LabelUhrzeitVon.setText("LabelUhrzeitVon");
        mitte.add(LabelUhrzeitVon);

        mitte.add(TextFieldUhrzeitVon);

        LabelUhrzeitBis.setText("LabelUhrzeitBis");
        mitte.add(LabelUhrzeitBis);

        mitte.add(TextFieldUhrzeitBis);

        LabelSonnenbank.setText("LabelSonnenbank");
        mitte.add(LabelSonnenbank);

        mitte.add(TextFieldSonnenbank);

        LabelKunde.setText("LabelKunde");
        mitte.add(LabelKunde);

        mitte.add(TextFieldKunde);


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
        //unten.add(LabelFehlermeldung);
        setSize(800,500);
        setLocationRelativeTo(null);

    }

    private void ButtonSpeichernActionPerformed(java.awt.event.ActionEvent evt) {
        TerminController controller = new TerminController();
        if(controller.createTermin(LocalDate.parse(TextFieldDatum.getText()), LocalDateTime.parse(TextFieldUhrzeitVon.getText()), LocalDateTime.parse(TextFieldUhrzeitBis.getText()), TextFieldSonnenbank.getText(), TextFieldKunde.getText()) == true)
        {
            JOptionPane.showMessageDialog(null,
                    "Erstellen fertiggestellt!",
                    "Erstellen fertig!",
                    JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,
                    "Ersetllen fehlgeschlagen!",
                    "Fehlgeschlagen",
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


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == ButtonSpeichern)
        {
            LocalDate datum = LocalDate.parse(TextFieldDatum.getText());
            LocalDateTime von = LocalDateTime.parse(TextFieldUhrzeitVon.getText());
            LocalDateTime bis = LocalDateTime.parse(TextFieldUhrzeitBis.getText());

            if (ControllerTermin.createTermin(datum, von, bis, TextFieldSonnenbank.getText(), TextFieldKunde.getText()) == true)
            {
                OverviewTermin ot = new OverviewTermin();
                ot.setVisible(true);
                this.dispose();
            }else
            {
                LabelFehlermeldung.setText("Bei Ihren Eingaben ist ein Fehler aufgetreten!");
                LabelFehlermeldung.setForeground(Color.red);
            }
        }
        if (button == ButtonAbbrechen)
            this.dispose();
    }
}
