package View.UserViews;

import Controller.UserController;
import Model.ApplicationUserObject;
import View.SonnenbankViews.OverviewSonnenbank;
import View.TerminViews.OverviewTermin;

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
public class OverviewUser extends JFrame {

    // Variables declaration - do not modify
    private JButton ButtonOverviewAppointment;
    private JButton ButtonOverviewSunbed;
    private JButton ButtonCreateUser;
    private JButton ButtonEditUser;
    private JButton ButtonDeleteUser;
    private JPanel top;
    private JPanel center;
    private JPanel bottom;
    private JScrollPane centerScrollPane;
    private JTable TableOverviewUser;

    public OverviewUser() {
        initComponents();
    }

    private void initComponents() {

        top = new JPanel();
        ButtonOverviewAppointment = new JButton();
        ButtonOverviewSunbed = new JButton();

        center = new JPanel();
        centerScrollPane = new JScrollPane();
        TableOverviewUser = new JTable();

        bottom = new JPanel();
        ButtonCreateUser = new JButton();
        ButtonEditUser = new JButton();
        ButtonDeleteUser = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Benutzer übersicht");

        ButtonOverviewAppointment.setText("Wechsele zur Terminübersicht");
        ButtonOverviewAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonOverviewAppointmentActionPerformed(evt);
            }
        });
        top.add(ButtonOverviewAppointment);

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
        LinkedList<ApplicationUserObject> list = new UserController().getAllUser();


        String[] columnnames = new String[]{"ID", "Vorname", "Nachname", "Geburtstag", "E-Mail", "Passwort"};
        dtm.setColumnIdentifiers(columnnames);

        for (ApplicationUserObject u : list) {

            String[] r = {u.getID() + "", u.getVorname() + "", u.getNachname() + "", u.getGeburtstag() + "", u.getEmail() + "", u.getPasswort() + ""};
            dtm.addRow(r);
        }
        dtm.setColumnIdentifiers(columnnames);


        TableOverviewUser.setModel(dtm);
        TableOverviewUser.setCellSelectionEnabled(true);
        TableOverviewUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerScrollPane.setViewportView(TableOverviewUser);
        center.add(centerScrollPane);

        add(center, java.awt.BorderLayout.CENTER);

        ButtonCreateUser.setText("Registriere Benutzer");
        ButtonCreateUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonCreateUserActionPerformed(evt);
            }
        });

        bottom.add(ButtonCreateUser);

        ButtonEditUser.setText("Bearbeite User");
        ButtonEditUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonEditUserActionPerformed(evt);
            }
        });

        bottom.add(ButtonEditUser);

        ButtonDeleteUser.setText("Lösche User");
        ButtonDeleteUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonDeleteUserActionPerformed(evt);
            }
        });

        bottom.add(ButtonDeleteUser);

        add(bottom, BorderLayout.SOUTH);
        setSize(800, 500);
        setLocationRelativeTo(null);
    }

    private void ButtonDeleteUserActionPerformed(ActionEvent evt) {

        try {

            int row = TableOverviewUser.getSelectedRow();
            // If user has no row selected break!
            if (row == -1) throw new RuntimeException("Bitte zuerst eine Zeile auswählen!");

            int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie den ausgewählten User löschen?", "Löschen bestätigen", JOptionPane.YES_NO_CANCEL_OPTION);

            if (eingabe == 0) // Clicked yes
            {
                UserController controller = new UserController();

                boolean applicationUserDeleted = controller.deleteApplicationUser(Integer.parseInt((String) TableOverviewUser.getModel().getValueAt(row, 0)));

                if (applicationUserDeleted) {

                    JOptionPane.showMessageDialog(null, "Löschen fertiggestellt!", "Löschen fertig!", JOptionPane.INFORMATION_MESSAGE);

                    DefaultTableModel d = new DefaultTableModel();
                    LinkedList<ApplicationUserObject> list = new UserController().getAllUser();

                    // Define Table cols
                    String[] columnnames = new String[]{"ID", "Vorname", "Nachname", "Geburtstag", "E-Mail", "Passwort"};
                    d.setColumnIdentifiers(columnnames);


                    // fill table with rows
                    for (ApplicationUserObject u : list) {
                        String[] r = {u.getID() + "", u.getVorname() + "", u.getNachname() + "", u.getGeburtstag() + "", u.getEmail() + "", u.getPasswort() + ""};
                        d.addRow(r);
                    }

                    TableOverviewUser.setModel(d);
                    TableOverviewUser.repaint();

                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Löschen Fehlgeschlagen", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void ButtonEditUserActionPerformed(ActionEvent evt) {
        int row = TableOverviewUser.getSelectedRow();
        ApplicationUserObject to = new ApplicationUserObject(
                Integer.parseInt((String) TableOverviewUser.getModel().getValueAt(row, 0)),
                (String) TableOverviewUser.getModel().getValueAt(row, 1),
                (String) TableOverviewUser.getModel().getValueAt(row, 2),
                LocalDate.parse((String) TableOverviewUser.getModel().getValueAt(row, 3)),
                (String) TableOverviewUser.getModel().getValueAt(row, 4),
                (String) TableOverviewUser.getModel().getValueAt(row, 5));
        Edit et = new Edit(to);
        et.setVisible(true);
        this.dispose();
    }

    private void ButtonCreateUserActionPerformed(ActionEvent evt) {
        Register ct = new Register();
        ct.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewAppointmentActionPerformed(ActionEvent evt) {
        OverviewTermin ou = new OverviewTermin();
        ou.setVisible(true);
        this.dispose();
    }

    private void ButtonOverviewSunbedActionPerformed(ActionEvent evt) {
        OverviewSonnenbank os = new OverviewSonnenbank();
        os.setVisible(true);
        this.dispose();
    }
}

