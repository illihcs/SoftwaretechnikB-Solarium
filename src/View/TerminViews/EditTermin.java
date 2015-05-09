package View.TerminViews;

import Controller.TerminController;
import Model.TerminObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by admin on 03.05.2015.
 */
public class EditTermin extends JFrame{
    TerminObject terminObject;

    //Panels for Title and Create
    JPanel top;
    JPanel center;
    JPanel bottom;

    //Compnents
    JButton ButtonSave;
    JButton ButtonAbort;
    JLabel LabelTitle;
    JLabel LabelFailure;
    JLabel LabelDate;
    JLabel LabelTimeFrom;
    JLabel LabelTimeUntil;
    JLabel LabelSunbed;
    JLabel LabelClient;
    JTextField TextFieldDate;
    JTextField TextFieldTimeFrom;
    JTextField TextFieldTimeUntil;
    JTextField TextFieldSunbed;
    JTextField TextFieldClient;
    JButton ButtonBackToAppointmentOverview;

    //Controller initialized
    TerminController ControllerTermin = new TerminController();

    public EditTermin(TerminObject to) {
        initComponents(to);
    }

    private void initComponents(TerminObject to) {
        terminObject=to;
        //create Controller
        //ControllerTermin = new TerminController();

        //create Components
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();
        ButtonSave = new JButton("Speichern");
        ButtonAbort = new JButton("Abbrechen");
        ButtonBackToAppointmentOverview = new JButton("Zur�ck zur Termin�bersicht");
        LabelTitle = new JLabel("Bitte tragen Sie die Termininformationen ein, um den Termin zu erstellen.");
        LabelDate = new JLabel("Datum:");
        LabelTimeFrom = new JLabel("Uhrzeit Von:");
        LabelTimeUntil = new JLabel("Uhrezit Bis:");
        LabelSunbed = new JLabel("Sonnenbank:");
        LabelClient = new JLabel("Kundenname:");
        TextFieldDate = new JTextField(terminObject.getDatum().toString());
        TextFieldTimeFrom = new JTextField(terminObject.getUhrzeitVon().toString());
        TextFieldTimeUntil = new JTextField(terminObject.getUhrzeitBis().toString());
        TextFieldSunbed = new JTextField(terminObject.getSonnenbank());
        TextFieldClient = new JTextField(terminObject.getKunde());

        //add Components
        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);

        top.add(ButtonBackToAppointmentOverview);

        center.setLayout(new GridLayout(0, 2));

        LabelDate.setText("Datum:");
        center.add(LabelDate);
        center.add(TextFieldDate);

        LabelTimeFrom.setText("Uhrzeit Von:");
        center.add(LabelTimeFrom);
        center.add(TextFieldTimeFrom);

        LabelTimeUntil.setText("Uhrzeit Bis:");
        center.add(LabelTimeUntil);
        center.add(TextFieldTimeUntil);

        LabelSunbed.setText("Sonnenbank:");
        center.add(LabelSunbed);
        center.add(TextFieldSunbed);

        LabelClient.setText("Kunde:");
        center.add(LabelClient);
        center.add(TextFieldClient);


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
        //bottom.add(LabelFailure);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setTitle("Bearbeiten Sie die zu �ndernden Werte.");
    }

    private void ButtonSaveActionPerformed(ActionEvent evt) {
        try{

        TerminController controller = new TerminController();
        LocalDate date = LocalDate.parse(TextFieldDate.getText());
        LocalTime from = LocalTime.parse(TextFieldTimeFrom.getText());
        LocalTime until = LocalTime.parse(TextFieldTimeUntil.getText());

        LocalDateTime dtfrom   = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), from.getHour(), from.getMinute());
        LocalDateTime dtuntil  = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), until.getHour(), until.getMinute());


        if (controller.createTermin(date, dtfrom, dtuntil, TextFieldSunbed.getText(), TextFieldClient.getText()) == true) {
            JOptionPane.showMessageDialog(null,
                    "Bearbeiten fertiggestellt!",
                    "Bearbeiten fertig!",
                    JOptionPane.WARNING_MESSAGE);
            OverviewTermin overviewTermin = new OverviewTermin();
            overviewTermin.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Bearbeiten fehlgeschlagen!\n\nM�gliche Fehler: \nFormat Datum: yyyy-MM-dd\nFormat Zeit: hh:mm",
                    "Fehlgeschlagen",
                    JOptionPane.WARNING_MESSAGE);
        }
    }catch (Exception e)
    {
        JOptionPane.showMessageDialog(null,
                "Bearbeiten fehlgeschlagen!\n\nM�gliche Fehler: \nFormat Datum: yyyy-MM-dd\nFormat Zeit: hh:mm",
                "Fehlgeschlagen",
                JOptionPane.WARNING_MESSAGE);
    }
        
    }

    private void ButtonAbortActionPerformed(ActionEvent evt) {
        int eingabe = JOptionPane.showConfirmDialog(null, "M�chten Sie wirklich abbrechen?", "Abbrechen", JOptionPane.YES_NO_OPTION);
        if (eingabe == 0) {
            OverviewTermin ot = new OverviewTermin();
            ot.setVisible(true);
            this.dispose();
        }
    }
}