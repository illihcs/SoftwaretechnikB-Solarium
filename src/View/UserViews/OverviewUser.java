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
public class OverviewUser extends JFrame{

    // Variables declaration - do not modify
    private JButton ButtonOverviewAppointment;
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
    public OverviewUser() {
        initComponents();
    }

    private void initComponents() {

        top = new JPanel();
        ButtonOverviewAppointment = new JButton();
        ButtonOverviewSunbed = new JButton();

        center = new JPanel();
        centerScrollPane = new JScrollPane();
        TableOverviewAppointment = new JTable();

        bottom = new JPanel();
        ButtonCreateAppointment = new JButton();
        ButtonEditAppointment = new JButton();
        ButtonDeleteAppointment = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Benutzer Übersicht");

        ButtonOverviewAppointment.setText("Wechsele zur TerminÜbersicht");
        ButtonOverviewAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonOverviewAppointmentActionPerformed(evt);
            }
        });
        top.add(ButtonOverviewAppointment);

        ButtonOverviewSunbed.setText("Wechsele zur SonnenbankÜbersicht");
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


        String[] columnnames = new String[]{"ID", "Vorname", "Nachname","Geburtstag", "E-Mail", "Passwort"};
        dtm.setColumnIdentifiers(columnnames);

        for (ApplicationUserObject u : list) {

            String[] r = {u.getID() + "", u.getVorname() + "", u.getNachname() + "", u.getGeburtstag() + "", u.getEmail() + "", u.getPasswort() + ""};
            dtm.addRow(r);
        }
        dtm.setColumnIdentifiers(columnnames);


        TableOverviewAppointment.setModel(dtm);
        TableOverviewAppointment.setCellSelectionEnabled(true);
        TableOverviewAppointment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerScrollPane.setViewportView(TableOverviewAppointment);
        center.add(centerScrollPane);

        add(center, java.awt.BorderLayout.CENTER);

        ButtonCreateAppointment.setText("Registriere Benutzer");
        ButtonCreateAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonCreateAppointmentActionPerformed(evt);
            }
        });

        bottom.add(ButtonCreateAppointment);

        ButtonEditAppointment.setText("Bearbeite User");
        ButtonEditAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonEditAppointmentActionPerformed(evt);
            }
        });

        bottom.add(ButtonEditAppointment);

        ButtonDeleteAppointment.setText("Lösche User");
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

        int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie den ausgewählten User löschen?", "Löschen bestätigen", JOptionPane.YES_NO_CANCEL_OPTION);
        if (eingabe == 0) // Clicked Ja
        {
            int row = TableOverviewAppointment.getSelectedRow();

            UserController controller = new UserController();
            if (controller.deleteApplicationUser(Integer.parseInt((String)TableOverviewAppointment.getModel().getValueAt(row, 0)))== true)
            {
                JOptionPane.showMessageDialog(null,
                        "Läschen fertiggestellt!",
                        "Läschen fertig!",
                        JOptionPane.WARNING_MESSAGE);

                DefaultTableModel d = new DefaultTableModel();
                LinkedList<ApplicationUserObject> list = new UserController().getAllUser();

                String[] columnnames = new String[]{"ID", "Vorname", "Nachname","Geburtstag", "E-Mail", "Passwort"};
                d.setColumnIdentifiers(columnnames);

                for (ApplicationUserObject u : list) {

                    String[] r = {u.getID() + "", u.getVorname() + "", u.getNachname() + "", u.getGeburtstag() + "", u.getEmail() + "", u.getPasswort() + ""};
                    d.addRow(r);
                }

                TableOverviewAppointment.setModel(d);
                TableOverviewAppointment.repaint();
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

    private void ButtonEditAppointmentActionPerformed(ActionEvent evt) {
        int row = TableOverviewAppointment.getSelectedRow();
        ApplicationUserObject to = new ApplicationUserObject(
                Integer.parseInt((String)TableOverviewAppointment.getModel().getValueAt(row, 0)),
                (String) TableOverviewAppointment.getModel().getValueAt(row, 1),
                (String) TableOverviewAppointment.getModel().getValueAt(row, 2),
                LocalDate.parse((String) TableOverviewAppointment.getModel().getValueAt(row, 3)),
                (String) TableOverviewAppointment.getModel().getValueAt(row, 4),
                (String) TableOverviewAppointment.getModel().getValueAt(row, 5));
        Edit et = new Edit(to);
        et.setVisible(true);
        this.dispose();
    }

    private void ButtonCreateAppointmentActionPerformed(ActionEvent evt) {
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

