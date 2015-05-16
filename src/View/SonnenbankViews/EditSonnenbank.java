package View.SonnenbankViews;

import Controller.SonnenbankController;
import Model.SonnenbankObject;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;


/**
 * Created by admin on 03.05.2015.
 */
public class EditSonnenbank extends JFrame {

    //Panels for Title and Create
    JPanel top;
    JPanel center;
    JPanel bottom;

    //Compnents
    JButton ButtonSave;
    JButton ButtonAbort;
    JLabel LabelCabin;
    JLabel LabelPower;
    JLabel LabelServiceAppointment;
    JTextField TextFieldCabin;
    JTextField TextFieldPower;
    JTextField TextFieldServiceAppointment;
    JButton ButtonBackToSunbedOverview;

    SonnenbankObject sonnenbankObject;

    public EditSonnenbank(SonnenbankObject so) {
        initComponents(so);
    }

    private void initComponents(SonnenbankObject so) {
        sonnenbankObject = so;

        //create Components
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();
        ButtonSave = new JButton("Speichern");
        ButtonAbort = new JButton("Abbrechen");
        LabelCabin = new JLabel("Kabine:");
        LabelPower = new JLabel("Leistung:");
        LabelServiceAppointment = new JLabel("Wartungstermin:");
        TextFieldCabin = new JTextField(so.getKabine());
        TextFieldPower = new JTextField(so.getLeistung());
        TextFieldServiceAppointment = new JTextField(so.getWartungstermin().toString());
        ButtonBackToSunbedOverview = new JButton("Zur�ck zur Sonnenbank�bersicht");

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

        setTitle("Bearbeiten Sie die zu �ndernden Werte der Sonnenbank.");
    }

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {

        try {

            SonnenbankController controller = new SonnenbankController();

            // Define the 'Date' format to parse
            DateFormatter dateFormatter = DateFormatter.ofPattern("yyyy-MM-dd");

            // Get and save userInputs
            String Cabin = TextFieldCabin.getText();
            String Power = TextFieldPower.getText();
            Date ServiceAppointment = Date.parse(TextFieldServiceAppointment.getText(), dateFormatter);

            // Execute changes
            boolean sonnenbankEdited = controller.editSonnenbank(sonnenbankObject.getID(), Cabin, Power, ServiceAppointment);

            if (sonnenbankEdited) {
                JOptionPane.showMessageDialog(null,
                        "Bearbeiten fertiggestellt!",
                        "Bearbeiten fertig!",
                        JOptionPane.INFORMATION_MESSAGE);

                OverviewSonnenbank overviewSonnenbank = new OverviewSonnenbank();
                overviewSonnenbank.setVisible(true);

                this.dispose();

            } else {
                throw new RuntimeException("Bearbeiten fehlgeschlagen! \n  Ein Feld wurde falsch eingegeben:\n Format Datum:yyyy-MM-dd");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Bearbeiten Fehlgeschlagen", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void ButtonAbortActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        int eingabe = JOptionPane.showConfirmDialog(null, "M�chten Sie wirklich abbrechen?", "Abbrechen", JOptionPane.YES_NO_OPTION);
        if (eingabe == 0) {
            OverviewSonnenbank overviewSonnenbank = new OverviewSonnenbank();
            overviewSonnenbank.setVisible(true);
            this.dispose();
        }
    }


}
