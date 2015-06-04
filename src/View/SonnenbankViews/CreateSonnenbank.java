package View.SonnenbankViews;

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

import Controller.SonnenbankController;

/**
 * Created by admin on 03.05.2015.
 */
@SuppressWarnings("serial")
public class CreateSonnenbank extends JFrame {

    //Panels for Title and Create
    JPanel top;
    JPanel center;
    JPanel bottom;

    //Components
    JButton ButtonSave;
    JButton ButtonAbort;
    JLabel LabelCabin;
    JLabel LabelPower;
    JLabel LabelServiceAppointment;
    JTextField TextFieldCabin;
    JTextField TextFieldPower;
    JTextField TextFieldServiceAppointment;
    JButton ButtonBackToSunbedOverview;

    public CreateSonnenbank() {
        initComponents();
    }

    private void initComponents() {
        //create Components
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();
        ButtonSave = new JButton("Speichern");
        ButtonAbort = new JButton("Abbrechen");
        LabelCabin = new JLabel("Kabine:");
        LabelPower = new JLabel("Leistung:");
        LabelServiceAppointment = new JLabel("Wartungstermin:");
        TextFieldCabin = new JTextField();
        TextFieldPower = new JTextField();
        TextFieldServiceAppointment = new JTextField();
        ButtonBackToSunbedOverview = new JButton("Zurück zur Sonnenbankübersicht");

        //add Components
        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);

        top.add(ButtonBackToSunbedOverview);

        center.setLayout(new GridLayout(0, 2));

        center.add(LabelCabin);
        center.add(TextFieldCabin);

        center.add(LabelPower);
        center.add(TextFieldPower);

        center.add(LabelServiceAppointment);
        center.add(TextFieldServiceAppointment);


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

        ButtonBackToSunbedOverview.addActionListener(new ActionListener() {
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
        setTitle("Tragen Sie die Sonnenbankdaten f�r die Terminerstellung ein.");
    }

    // Creates with user given inputs a new sunbad
    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {

        try {

            SonnenbankController controller = new SonnenbankController();

            // Define the 'Date' format to parse
            // DateFormatter dateFormatter = DateFormatter.ofPattern("dd.MM.yyyy");

            // Get and save userInputs
            String Cabin = TextFieldCabin.getText();
            String Power = TextFieldPower.getText();
            String ServiceAppointment = TextFieldServiceAppointment.getText();

            boolean sonnenbankCreated = controller.createSonnenbank(Cabin, Power, ServiceAppointment);

            if (sonnenbankCreated) {

                JOptionPane.showMessageDialog(null, "Erstellen fertiggestellt!", "Erstellen fertig!", JOptionPane.INFORMATION_MESSAGE);
                OverviewSonnenbank overviewSonnenbank = new OverviewSonnenbank();
                overviewSonnenbank.setVisible(true);

                this.dispose();

            } else {

                throw new RuntimeException("Erstellung fehlgeschlagen! \n  Ein Feld wurde falsch eingegeben:\n Format Datum:dd.MM.yyyy");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erstellunng fehlgeschlagen", JOptionPane.WARNING_MESSAGE);
        }
    }

    // abort new sunbad task
    private void ButtonAbortActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {

        int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie wirklich abbrechen?", "Abbrechen", JOptionPane.YES_NO_OPTION);

        if (eingabe == 0) {

            OverviewSonnenbank overviewSonnenbank = new OverviewSonnenbank();
            overviewSonnenbank.setVisible(true);
            this.dispose();
        }
    }


}
