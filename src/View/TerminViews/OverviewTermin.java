package View.TerminViews;


import Controller.TerminController;
import Model.TerminObject;
import View.SonnenbankViews.OverviewSonnenbank;
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
@SuppressWarnings("serial")
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
    public OverviewTermin() throws SQLException {
        initComponents();
    }

    private void initComponents() throws SQLException {

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
        setTitle("Termin Übersicht");

        ButtonOverviewUser.setText("Wechsele zur Benutzerübersicht");
        ButtonOverviewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               
                    ButtonOverviewUserActionPerformed(evt);
               
            }
        });
        top.add(ButtonOverviewUser);

        ButtonOverviewSunbed.setText("Wechsele zur Sonnenbankübersicht");
        ButtonOverviewSunbed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               
                    ButtonOverviewSunbedActionPerformed(evt);
  
            }
        });
        top.add(ButtonOverviewSunbed);
        add(top, BorderLayout.NORTH);

        center.setLayout(new GridLayout());
        DefaultTableModel dtm = new DefaultTableModel();
        LinkedList<TerminObject> list = TerminController.getInstance().getAllTermin();
        String[] columnnames = new String[]{"ID", "Datum", "Uhrzeit Von", "Uhrzeit Bis", "Sonnenbank", "Kundenname"};
        dtm.setColumnIdentifiers(columnnames);

        for (TerminObject t : list) {

            String[] row = {t.getID() + "", t.getDatum() + "", t.getUhrzeitVon() + "", t.getUhrzeitBis() + "", t.getSonnenbank() + "", t.getKunde() + ""};
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

        ButtonDeleteAppointment.setText("Lösche Termin");
        ButtonDeleteAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonDeleteAppointmentActionPerformed(evt);
            }
        });

        bottom.add(ButtonDeleteAppointment);

        add(bottom, BorderLayout.SOUTH);

        setSize(800, 500);
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ButtonDeleteAppointmentActionPerformed(ActionEvent evt) {

        try {

            int row = TableOverviewAppointment.getSelectedRow();
            // If user has no row selected break!
            if (row == -1) throw new RuntimeException("Bitte zuerst eine Zeile auswählen!");

            int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie den ausgewählten Termin löschen?", "Löschen bestätigen", JOptionPane.YES_NO_CANCEL_OPTION);

            // Clicked yes
            if (eingabe == 0) {

                TerminController controller = TerminController.getInstance();

                boolean terminDeleted = controller.deleteTermin(Integer.parseInt((String) TableOverviewAppointment.getModel().getValueAt(row, 0)));


                if (terminDeleted) {
                    JOptionPane.showMessageDialog(null,
                            "Löschen fertiggestellt!",
                            "Löschen fertig!",
                            JOptionPane.INFORMATION_MESSAGE);

                    DefaultTableModel d = new DefaultTableModel();
                    LinkedList<TerminObject> list = TerminController.getInstance().getAllTermin();

                    String[] columnnames = new String[]{"ID", "Datum", "Uhrzeit Von", "Uhrzeit Bis", "Sonnenbank", "Kundenname"};
                    d.setColumnIdentifiers(columnnames);

                    for (TerminObject t : list) {

                        String[] r = {t.getID() + "", t.getDatum() + "", t.getUhrzeitVon() + "", t.getUhrzeitBis() + "", t.getSonnenbank() + "", t.getKunde() + ""};
                        d.addRow(r);
                    }

                    TableOverviewAppointment.setModel(d);
                    TableOverviewAppointment.repaint();
                } else {

                    throw new RuntimeException("Eintrag konnte nicht gelöscht werden!");

                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Löschen Fehlgeschlagen", JOptionPane.WARNING_MESSAGE);

        }
    }

    private void ButtonEditAppointmentActionPerformed(ActionEvent evt) {

        int row = TableOverviewAppointment.getSelectedRow();

        TerminObject to = new TerminObject(
                Integer.parseInt((String) TableOverviewAppointment.getModel().getValueAt(row, 0)),
                (Date) TableOverviewAppointment.getModel().getValueAt(row, 1),
                (Date) TableOverviewAppointment.getModel().getValueAt(row, 2),
                (Date) TableOverviewAppointment.getModel().getValueAt(row, 3),
                (String) TableOverviewAppointment.getModel().getValueAt(row, 4),
                (String) TableOverviewAppointment.getModel().getValueAt(row, 5));

        EditTermin et = null;
		try {
			et = new EditTermin(to);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Etwas ist Fehlgeschlagen", JOptionPane.WARNING_MESSAGE);
		}

        et.setVisible(true);
        this.dispose();
    }

    private void ButtonCreateAppointmentActionPerformed(ActionEvent evt) {
        CreateTermin ct = null;
		try {
			ct = new CreateTermin();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erstellen Fehlgeschlagen", JOptionPane.WARNING_MESSAGE);
		}
        ct.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewUserActionPerformed(ActionEvent evt){
        OverviewUser ou = null;
		try {
			ou = new OverviewUser();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Etwas ist Fehlgeschlagen", JOptionPane.WARNING_MESSAGE);
		}
        ou.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewSunbedActionPerformed(ActionEvent evt)  {
        OverviewSonnenbank os = null;
		try {
			os = new OverviewSonnenbank();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Etwas ist Fehlgeschlagen", JOptionPane.WARNING_MESSAGE);
		}
        os.setVisible(true);
        this.dispose();
    }
}
