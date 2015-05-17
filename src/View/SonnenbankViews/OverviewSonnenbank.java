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
import java.sql.SQLException;
import java.util.Date;
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
    public OverviewSonnenbank() throws SQLException {
        initComponents();
    }

    private void initComponents() throws SQLException {

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
                try {
                    ButtonOverviewUserActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        top.add(ButtonOverviewUser);

        ButtonOverviewAppointment.setText("Wechsele zur Terminübersicht");
        ButtonOverviewAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    ButtonOverviewAppointmentActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        top.add(ButtonOverviewAppointment);
        add(top, BorderLayout.NORTH);

        center.setLayout(new GridLayout());
        DefaultTableModel dtm = new DefaultTableModel();
        LinkedList<SonnenbankObject> list = new SonnenbankController().getAllSonnenbanken();
        String[] columnnames = new String[]{"ID", "Kabine", "Leistung", "Wartungstermin"};
        dtm.setColumnIdentifiers(columnnames);

        for (SonnenbankObject so : list) {
            String[] row = {so.getID() + "", so.getKabine() + "", so.getLeistung() + "", so.getWartungstermin() + ""};
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
    }

    private void ButtonDeleteSunbedActionPerformed(ActionEvent evt) {

        try {

            int row = TableOverviewSunbed.getSelectedRow();
            // If user has no row selected break!
            if (row == -1) throw new RuntimeException("Bitte zuerst eine Zeile auswählen!");

            int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie die ausgewählte Sonnenbank löschen?", "Löschen bestätigen", JOptionPane.YES_NO_CANCEL_OPTION);

            // User clicked yes
            if (eingabe == 0) {

                SonnenbankController controller = new SonnenbankController();

                boolean sunbedDeleted = controller.deleteSunbed(Integer.parseInt((String) TableOverviewSunbed.getModel().getValueAt(row, 0)));

                if (sunbedDeleted) {
                    JOptionPane.showMessageDialog(null,
                            "Löschen fertiggestellt!",
                            "Löschen fertig!",
                            JOptionPane.INFORMATION_MESSAGE);

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

                } else {

                    throw new RuntimeException("Eintrag konnte nicht gelöscht werden!");
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Löschen Fehlgeschlagen", JOptionPane.WARNING_MESSAGE);
        }

    }


    private void ButtonEditSunbedActionPerformed(ActionEvent evt) {

        int row = TableOverviewSunbed.getSelectedRow();

        SonnenbankObject sonnenbankObject = new SonnenbankObject(
                Integer.parseInt((String) TableOverviewSunbed.getModel().getValueAt(row, 0)),
                (String) TableOverviewSunbed.getModel().getValueAt(row, 1),
                (String) TableOverviewSunbed.getModel().getValueAt(row, 2),
                (Date) TableOverviewSunbed.getModel().getValueAt(row, 3));

        EditSonnenbank editSonnenbank = new EditSonnenbank(sonnenbankObject);

        editSonnenbank.setVisible(true);

        this.dispose();
    }

    private void ButtonCreateSunbedActionPerformed(ActionEvent evt) {
        CreateSonnenbank createSonnenbank = new CreateSonnenbank();
        createSonnenbank.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewUserActionPerformed(ActionEvent evt) throws SQLException {
        OverviewUser ou = new OverviewUser();
        ou.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewAppointmentActionPerformed(ActionEvent evt) throws SQLException {
        OverviewTermin overviewTermin = new OverviewTermin();
        overviewTermin.setVisible(true);
        this.dispose();
    }
}
