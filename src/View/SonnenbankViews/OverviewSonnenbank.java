package View.SonnenbankViews;


import Controller.SonnenbankController;
import Model.SonnenbankObject;
import View.TerminViews.OverviewTermin;
import View.UserViews.OverviewUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Created by admin on 03.05.2015.
 */
public class OverviewSonnenbank extends JFrame {

    // Variables declaration - do not modify
    private JButton ButtonOverviewUser;
    private JButton ButtonOverviewAppointment;
    private JButton ButtonCreateSunbed;
    private JButton ButtonEditSunbed;
    private JButton ButtonDeleteSunbed;
    private JPanel top;
    private JPanel center;
    private JPanel bottom;
    private JScrollPane centerScrollPane;
    private JTable TableOverviewSunbed;
    // End of variables declaration

    /**
     * Creates new form NewJFrame
     */
    public OverviewSonnenbank() {
        initComponents();
    }

    private void initComponents() {

        top = new JPanel();
        ButtonOverviewUser = new JButton();
        ButtonOverviewAppointment = new JButton();

        center = new JPanel();
        centerScrollPane = new JScrollPane();
        TableOverviewSunbed = new JTable();

        bottom = new JPanel();
        ButtonCreateSunbed = new JButton();
        ButtonEditSunbed = new JButton();
        ButtonDeleteSunbed = new JButton();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Sonnenbank Übersicht");

        ButtonOverviewUser.setText("Wechsele zur Benutzerübersicht");
        ButtonOverviewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonOverviewUserActionPerformed(evt);
            }
        });
        top.add(ButtonOverviewUser);

        ButtonOverviewAppointment.setText("Wechsele zur Terminübersicht");
        ButtonOverviewAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonOverviewAppointmentActionPerformed(evt);
            }
        });
        top.add(ButtonOverviewAppointment);
        add(top, BorderLayout.NORTH);

        center.setLayout(new GridLayout());
        DefaultTableModel dtm = new DefaultTableModel();
        LinkedList<SonnenbankObject> list = new SonnenbankController().getAllSonnenbanken();
        String[] columnnames = new String[]{"ID", "Kabine", "Leistung", "Wartungstermin"};
        dtm.setColumnIdentifiers(columnnames);

        for (SonnenbankObject so : list)
        {
            String[] row = { so.getID() + "", so.getKabine() + "", so.getLeistung() + "",  so.getWartungstermin() + "" };
            dtm.addRow(row);
        }

        TableOverviewSunbed.setModel(dtm);
        TableOverviewSunbed.setRowSelectionAllowed(true);
        TableOverviewSunbed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerScrollPane.setViewportView(TableOverviewSunbed);
        center.add(centerScrollPane);

        add(center, BorderLayout.CENTER);

        ButtonCreateSunbed.setText("Erstelle Sonnenbank");
        ButtonCreateSunbed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonCreateSunbedActionPerformed(evt);
            }
        });

        bottom.add(ButtonCreateSunbed);

        ButtonEditSunbed.setText("Bearbeite Sonnenbank");
        ButtonEditSunbed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonEditSunbedActionPerformed(evt);
            }
        });

        bottom.add(ButtonEditSunbed);

        ButtonDeleteSunbed.setText("Lösche Sonnenbank");
        ButtonDeleteSunbed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonDeleteSunbedActionPerformed(evt);
            }
        });

        bottom.add(ButtonDeleteSunbed);

        add(bottom, BorderLayout.SOUTH);

        setSize(800, 500);
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ButtonDeleteSunbedActionPerformed(ActionEvent evt) {
        int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie die ausgewählte Sonnenbank löschen?", "Löschen bestätigen", JOptionPane.YES_NO_CANCEL_OPTION);
        if (eingabe == 0) // Clicked Ja
        {
            int row = TableOverviewSunbed.getSelectedRow();
            SonnenbankController controller = new SonnenbankController();
            if (controller.deleteSunbed(Integer.parseInt((String) TableOverviewSunbed.getModel().getValueAt(row, 0)))== true)
            {
                JOptionPane.showMessageDialog(null,
                        "Löschen fertiggestellt!",
                        "Löschen fertig!",
                        JOptionPane.WARNING_MESSAGE);

                DefaultTableModel d = new DefaultTableModel();
                LinkedList<SonnenbankObject> list = new SonnenbankController().getAllSonnenbanken();

                String[] columnnames = new String[]{"ID", "Kabine", "Leistung", "Wartungstermin"};
                d.setColumnIdentifiers(columnnames);

                for (SonnenbankObject so : list) {

                    String[] r = {so.getID() + "", so.getKabine() + "", so.getLeistung() + "", so.getWartungstermin() + ""};
                    d.addRow(r);
                }

                TableOverviewSunbed.setModel(d);
                TableOverviewSunbed.repaint();
            }else{
                JOptionPane.showMessageDialog(null,
                        "Löschen fehlgeschlagen",
                        "FEHLSCHLAG!!!",
                        JOptionPane.WARNING_MESSAGE);
            }
        }else{
            //Do nothing!
        }
    }

    private void ButtonEditSunbedActionPerformed(ActionEvent evt) {
        int row = TableOverviewSunbed.getSelectedRow();
        SonnenbankObject sonnenbankObject = new SonnenbankObject(
                Integer.parseInt((String)TableOverviewSunbed.getModel().getValueAt(row, 0)),
                (String) TableOverviewSunbed.getModel().getValueAt(row, 1),
                (String) TableOverviewSunbed.getModel().getValueAt(row, 2),
                LocalDate.parse((String) TableOverviewSunbed.getModel().getValueAt(row, 3)));
        EditSonnenbank editSonnenbank = new EditSonnenbank(sonnenbankObject);
        editSonnenbank.setVisible(true);
        this.dispose();
    }

    private void ButtonCreateSunbedActionPerformed(ActionEvent evt) {
        CreateSonnenbank createSonnenbank = new CreateSonnenbank();
        createSonnenbank.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewUserActionPerformed(ActionEvent evt) {
        OverviewUser ou = new OverviewUser();
        ou.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewAppointmentActionPerformed(ActionEvent evt) {
        OverviewTermin overviewTermin = new OverviewTermin();
        overviewTermin.setVisible(true);
        this.dispose();
    }
}
