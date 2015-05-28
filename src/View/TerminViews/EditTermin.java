package View.TerminViews;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import Controller.TerminController;
import Model.TerminObject;


/**
 * Created by admin on 03.05.2015.
 */
@SuppressWarnings("serial")
public class EditTermin extends JFrame {
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
    JLabel LabelDateFrom;
    JLabel LabelDateUntil;
    JLabel LabelSunbed;
    JLabel LabelClient;
    JTextField TextFieldDate;
    JTextField TextFieldDateFrom;
    JTextField TextFieldDateUntil;
    JTextField TextFieldSunbed;
    JTextField TextFieldClient;
    JButton ButtonBackToAppointmentOverview;

    //Controller initialized
    TerminController ControllerTermin;

    public EditTermin(TerminObject to) throws SQLException {
        initComponents(to);
    }

    private void initComponents(TerminObject to) throws SQLException{

        terminObject = to;

        //create Controller
        ControllerTermin = TerminController.getInstance();

        //create Components
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();
        ButtonSave = new JButton("Speichern");
        ButtonAbort = new JButton("Abbrechen");
        ButtonBackToAppointmentOverview = new JButton("Zurück zur Terminübersicht");
        LabelTitle = new JLabel("Bitte tragen Sie die Termininformationen ein, um den Termin zu erstellen.");
        LabelDate = new JLabel("Datum:");
        LabelDateFrom = new JLabel("Uhrzeit Von:");
        LabelDateUntil = new JLabel("Uhrezit Bis:");
        LabelSunbed = new JLabel("Sonnenbank:");
        LabelClient = new JLabel("Kundenname:");
        TextFieldDate = new JTextField(terminObject.getDatum().toString());
        TextFieldDateFrom = new JTextField(terminObject.getUhrzeitVon().toString());
        TextFieldDateUntil = new JTextField(terminObject.getUhrzeitBis().toString());
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

        LabelDateFrom.setText("Uhrzeit Von:");
        center.add(LabelDateFrom);
        center.add(TextFieldDateFrom);

        LabelDateUntil.setText("Uhrzeit Bis:");
        center.add(LabelDateUntil);
        center.add(TextFieldDateUntil);

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
                try {
                    ButtonAbortActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
        setTitle("Bearbeiten Sie die zu ändernden Werte.");
    }

    private void ButtonSaveActionPerformed(ActionEvent evt) {

        try {

            TerminController controller = TerminController.getInstance();


            // Get and save userInputs
            String terminDate = TextFieldDate.getText();
            String terminFrom = TextFieldDateFrom.getText();
            String terminUntil = TextFieldDateFrom.getText();
            String Sunbed = TextFieldSunbed.getText();
            String Client = TextFieldClient.getText();

            // Execute changes
            boolean termninEdit = controller.editTermin(terminObject.getID(), terminDate, terminFrom, terminUntil, Sunbed, Client);

            if (termninEdit) {

                // Display modalbox that termin was editing successfull
                JOptionPane.showMessageDialog(null, "Bearbeiten fertiggestellt!", "Bearbeiten fertig!", JOptionPane.INFORMATION_MESSAGE);

                OverviewTermin overviewTermin = new OverviewTermin();
                overviewTermin.setVisible(true);
                this.dispose();

            } else {

                throw new RuntimeException("Bearbeitung fehlgeschlagen! \n  Ein Feld wurde falsch eingegeben:\n Format Datum:yyyy-MM-dd");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Bearbeiten Fehlgeschlagen", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void ButtonAbortActionPerformed(ActionEvent evt) throws SQLException {
        int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie wirklich abbrechen?", "Abbrechen", JOptionPane.YES_NO_OPTION);
        if (eingabe == 0) {
            OverviewTermin ot = new OverviewTermin();
            ot.setVisible(true);
            this.dispose();
        }
    }
}