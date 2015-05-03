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
        add(unten, BorderLayout.SOUTH);

        oben.add(LabelTitle);

        mitte.add(LabelDatum);
        mitte.add(TextFieldDatum);
        mitte.add(LabelUhrzeitVon);
        mitte.add(TextFieldUhrzeitVon);
        mitte.add(LabelUhrzeitBis);
        mitte.add(TextFieldUhrzeitBis);
        mitte.add(LabelSonnenbank);
        mitte.add(TextFieldSonnenbank);
        mitte.add(LabelKunde);
        mitte.add(TextFieldKunde);

        unten.add(LabelFehlermeldung);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == ButtonSpeichern)
        {
            LocalDate datum = LocalDate.parse(TextFieldDatum.getText());
            LocalDateTime von = LocalDateTime.parse(TextFieldUhrzeitVon.getText());
            LocalDateTime bis = LocalDateTime.parse(TextFieldUhrzeitBis.getText());

            if (ControllerTermin.erstelleTermin(datum, von, bis, TextFieldSonnenbank.getText(), TextFieldKunde.getText()) == true)
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
    //TODO: View createTermin
}
