package View.TerminViews;


import Controller.TerminController;
import Model.Termin;
import Model.TerminObject;
import View.SonnenbankViews.OverviewSonnenbank;
import View.UserViews.OverviewUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

/**
 * Created by admin on 03.05.2015.
 */
public class OverviewTermin extends JFrame {

    // Variables declaration - do not modify
    private JButton ButtonOverviewUser;
    private JButton ButtonOverviewSunbed;
    private JButton ButtonCreateAppointment;
    private JButton ButtonEditAppointment;
    private JButton ButtonDeleteAppointment;
    private JPanel top;
    private JPanel center;
    private JPanel bottom;
    private JScrollPane centerScrollPane;
    private JTable TableOverviewAppointment;
    // End of variables declaration

    /**
     * Creates new form NewJFrame
     */
    public OverviewTermin() {
        initComponents();
    }

    private void initComponents() {

        top = new JPanel();
        ButtonOverviewUser = new JButton();
        ButtonOverviewSunbed = new JButton();

        center = new JPanel();
        centerScrollPane = new JScrollPane();
        TableOverviewAppointment = new JTable();

        bottom = new JPanel();
        ButtonCreateAppointment = new JButton();
        ButtonEditAppointment = new JButton();
        ButtonDeleteAppointment = new JButton();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Termin �bersicht");

        ButtonOverviewUser.setText("Wechsele zur Benutzer�bersicht");
        ButtonOverviewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonOverviewUserActionPerformed(evt);
            }
        });
        top.add(ButtonOverviewUser);

        ButtonOverviewSunbed.setText("Wechsele zur Sonnenbank�bersicht");
        ButtonOverviewSunbed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonOverviewSunbedActionPerformed(evt);
            }
        });
        top.add(ButtonOverviewSunbed);
        add(top, BorderLayout.NORTH);

        center.setLayout(new GridLayout());
        DefaultTableModel dtm = new DefaultTableModel();
        LinkedList<TerminObject> list = new TerminController().getAllTermin();
        String[] columnnames = new String[]{"ID", "Datum", "Uhrzeit Von", "Uhrzeit Bis", "Sonnenbank", "Kundenname"};
        dtm.setColumnIdentifiers(columnnames);

        for (TerminObject t : list)
        {

            String[] row = { t.getID() + "", t.getDatum() + "", t.getUhrzeitVon() + "",  t.getUhrzeitBis() + "", t.getSonnenbank() + "", t.getKunde() + "" };
            dtm.addRow(row);

        }

        TableOverviewAppointment.setModel(dtm);
        TableOverviewAppointment.setCellSelectionEnabled(true);
        TableOverviewAppointment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerScrollPane.setViewportView(TableOverviewAppointment);
        center.add(centerScrollPane);

        add(center, BorderLayout.CENTER);

        ButtonCreateAppointment.setText("Erstelle Termin");
        ButtonCreateAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonCreateAppointmentActionPerformed(evt);
            }
        });

        bottom.add(ButtonCreateAppointment);

        ButtonEditAppointment.setText("Bearbeite Termin");
        ButtonEditAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonEditAppointmentActionPerformed(evt);
            }
        });

        bottom.add(ButtonEditAppointment);

        ButtonDeleteAppointment.setText("L�sche Termin");
        ButtonDeleteAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonDeleteAppointmentActionPerformed(evt);
            }
        });

        bottom.add(ButtonDeleteAppointment);

        add(bottom, BorderLayout.SOUTH);

        setSize(800,500);
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ButtonDeleteAppointmentActionPerformed(ActionEvent evt) {
        int eingabe = JOptionPane.showConfirmDialog(null, "M�chten Sie den ausgew�hlten Termin l�schen?", "L�schen best�tigen", JOptionPane.YES_NO_CANCEL_OPTION);
        if (eingabe == 0) // Clicked Ja
        {
            int row = TableOverviewAppointment.getSelectedRow();
            /*TerminObject to = new TerminObject(
                    (int) TableOverviewAppointment.getModel().getValueAt(row, 0),
                    LocalDate.parse( (String) TableOverviewAppointment.getModel().getValueAt(row, 1)),
                    LocalTime.parse((String) TableOverviewAppointment.getModel().getValueAt(row, 2)),
                    LocalTime.parse((String) TableOverviewAppointment.getModel().getValueAt(row, 3)),
                    (String) TableOverviewAppointment.getModel().getValueAt(row, 4),
                    (String) TableOverviewAppointment.getModel().getValueAt(row, 5));*/
            TerminController controller = new TerminController();
            if (controller.deleteTermin(Integer.parseInt((String) TableOverviewAppointment.getModel().getValueAt(row, 0)))== true)
            {
                JOptionPane.showMessageDialog(null,
                        "L�schen fertiggestellt!",
                        "L�schen fertig!",
                        JOptionPane.WARNING_MESSAGE);

                DefaultTableModel d = new DefaultTableModel();
                LinkedList<TerminObject> list = new TerminController().getAllTermin();

                String[] columnnames = new String[]{"ID", "Datum", "Uhrzeit Von", "Uhrzeit Bis", "Sonnenbank", "Kundenname"};
                d.setColumnIdentifiers(columnnames);

                for (TerminObject t : list) {

                    String[] r = {t.getID() + "", t.getDatum() + "", t.getUhrzeitVon() + "", t.getUhrzeitBis() + "", t.getSonnenbank() + "", t.getKunde() + ""};
                    d.addRow(r);
                }

                TableOverviewAppointment.setModel(d);
                TableOverviewAppointment.repaint();
            }else{
                JOptionPane.showMessageDialog(null,
                        "L�schen fehlgeschlagen",
                        "FEHLSCHLAG!!!",
                        JOptionPane.WARNING_MESSAGE);
            }
        }else{
            //Do nothing!
        }
    }

    private void ButtonEditAppointmentActionPerformed(ActionEvent evt) {
        int row = TableOverviewAppointment.getSelectedRow();
        TerminObject to = new TerminObject(
                Integer.parseInt((String)TableOverviewAppointment.getModel().getValueAt(row, 0)),
                    LocalDate.parse( (String) TableOverviewAppointment.getModel().getValueAt(row, 1)),
                    LocalTime.parse((String) TableOverviewAppointment.getModel().getValueAt(row, 2)),
                    LocalTime.parse((String) TableOverviewAppointment.getModel().getValueAt(row, 3)),
                    (String) TableOverviewAppointment.getModel().getValueAt(row, 4),
                    (String) TableOverviewAppointment.getModel().getValueAt(row, 5));
        EditTermin et = new EditTermin(to);
        et.setVisible(true);
        this.dispose();
    }

    private void ButtonCreateAppointmentActionPerformed(ActionEvent evt) {
        CreateTermin ct = new CreateTermin();
        ct.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewUserActionPerformed(ActionEvent evt) {
        OverviewUser ou = new OverviewUser();
        ou.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewSunbedActionPerformed(ActionEvent evt) {
        OverviewSonnenbank os = new OverviewSonnenbank();
        os.setVisible(true);
        this.dispose();
    }
}
