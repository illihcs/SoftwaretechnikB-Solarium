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


/**
 * Created by admin on 03.05.2015.
 */
@SuppressWarnings("serial")
public class CreateTermin extends JFrame{

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

    public CreateTermin() throws SQLException {
        initComponents();
    }

    private void initComponents() throws SQLException {
        //create Controller
        ControllerTermin = TerminController.getInstance();

        //create Components
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();
        ButtonSave = new JButton("Speichern");
        ButtonAbort = new JButton("Abbrechen");
        LabelTitle = new JLabel("Bitte tragen Sie die Termininformationen ein, um den Termin zu erstellen.");
        LabelFailure = new JLabel();
        LabelDate = new JLabel("Datum:");
        LabelDateFrom = new JLabel("Uhrzeit Von:");
        LabelDateUntil = new JLabel("Uhrezit Bis:");
        LabelSunbed = new JLabel("Sonnenbank:");
        LabelClient = new JLabel("Kundenname:");
        TextFieldDate = new JTextField();
        TextFieldDateFrom = new JTextField();
        TextFieldDateUntil = new JTextField();
        TextFieldSunbed = new JTextField();
        TextFieldClient = new JTextField();
        ButtonBackToAppointmentOverview = new JButton("Zurück zur Terminübersicht");

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

        ButtonBackToAppointmentOverview.addActionListener(new ActionListener() {
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
        setTitle("Tragen Sie die Termindaten für die Terminerstellung ein.");
    }

    // Create a new termin
    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {

        try
        {

            TerminController controller = TerminController.getInstance();

            String terminDate = TextFieldDate.getText();
            String terminFrom = TextFieldDateFrom.getText();
            String terminUntil = TextFieldDateUntil.getText();

            String Sunbed = TextFieldSunbed.getText();
            String Client =TextFieldClient.getText();

           boolean termninCreated =  controller.createTermin(terminDate, terminFrom, terminUntil, Sunbed, Client);

            if (termninCreated) {

                JOptionPane.showMessageDialog(null,  "Erstellen fertiggestellt!", "Erstellen fertig!", JOptionPane.INFORMATION_MESSAGE);
                OverviewTermin overviewTermin = new OverviewTermin();
                overviewTermin.setVisible(true);
                this.dispose();

            } else {

                throw  new RuntimeException("Ersetllen fehlgeschlagen! \n  Ein Feld wurde falsch eingegeben:\n Format Datum:yyyy-MM-dd");
            }

        }catch (Exception ex)  {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Ersetllen Fehlgeschlagen",  JOptionPane.WARNING_MESSAGE);

        }

    }

    // abort createTermin with modalbox warning
    private void ButtonAbortActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {

        int inputValue = JOptionPane.showConfirmDialog(null, "Möchten Sie wirklich abbrechen?", "Abbrechen", JOptionPane.YES_NO_OPTION);

        if (inputValue == 0) {
            OverviewTermin ot = new OverviewTermin();
            ot.setVisible(true);
            this.dispose();
        }
    }

}
