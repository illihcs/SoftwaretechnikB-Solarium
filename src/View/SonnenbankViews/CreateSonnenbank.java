package View.SonnenbankViews;

import Controller.SonnenbankController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Created by admin on 03.05.2015.
 */
public class CreateSonnenbank extends JFrame{

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
        setTitle("Tragen Sie die Sonnenbankdaten für die Terminerstellung ein.");
    }

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        SonnenbankController controller = new SonnenbankController();
        try{
        if (controller.createSonnenbank(TextFieldCabin.getText(), TextFieldPower.getText(), LocalDate.parse(TextFieldServiceAppointment.getText())) == true) {
            JOptionPane.showMessageDialog(null,
                    "Erstellen fertiggestellt!",
                    "Erstellen fertig!",
                    JOptionPane.WARNING_MESSAGE);
            OverviewSonnenbank overviewSonnenbank = new OverviewSonnenbank();
            overviewSonnenbank.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ersetllen fehlgeschlagen!",
                    "Fehlgeschlagen",
                    JOptionPane.WARNING_MESSAGE);
        }
        }
catch (Exception e)
{
    JOptionPane.showMessageDialog(null,
            "Ersetllen fehlgeschlagen! \nEin Feld wurde falsch eingegeben:\n\nFormat Datum:yyyy-MM-dd",
            "Erstellen Fehlgeschlagen",
            JOptionPane.WARNING_MESSAGE);
}
    }

    private void ButtonAbortActionPerformed(java.awt.event.ActionEvent evt) {
        int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie wirklich abbrechen?", "Abbrechen", JOptionPane.YES_NO_OPTION);
        if (eingabe == 0) {
            OverviewSonnenbank overviewSonnenbank = new OverviewSonnenbank();
            overviewSonnenbank.setVisible(true);
            this.dispose();
        }
    }


}
