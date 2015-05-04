package View.UserViews;

import Controller.TerminController;
import Controller.UserController;
import Model.ApplicationUserObject;
import Model.TerminObject;
import View.SonnenbankViews.OverviewSonnenbank;
import View.TerminViews.CreateTermin;
import View.TerminViews.EditTermin;
import View.TerminViews.OverviewTermin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

/**
 * Created by admin on 03.05.2015.
 */
public class OverviewUser extends JFrame{

    // Variables declaration - do not modify
    private JButton ButtonTerminUebersicht;
    private JButton ButtonSonnenbankUebersicht;
    private JButton ButtonCreateTermin;
    private JButton ButtonEditTermin;
    private JButton ButtonDeleteTermin;
    private JPanel oben;
    private JPanel mitte;
    private JPanel unten;
    private JScrollPane mitteScrollPane;
    private JTable TabelleTerminUebersicht;
    // End of variables declaration

    /**
     * Creates new form NewJFrame
     */
    public OverviewUser() {
        initComponents();
    }

    private void initComponents() {

        oben = new JPanel();
        ButtonTerminUebersicht = new JButton();
        ButtonSonnenbankUebersicht = new JButton();
        mitte = new JPanel();
        mitteScrollPane = new JScrollPane();
        TabelleTerminUebersicht = new JTable();
        unten = new JPanel();
        ButtonCreateTermin = new JButton();
        ButtonEditTermin = new JButton();
        ButtonDeleteTermin = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Benutzer Übersicht");

        ButtonTerminUebersicht.setText("Wechsele zur Terminübersicht");
        ButtonTerminUebersicht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTerminUebersichtActionPerformed(evt);
            }
        });
        oben.add(ButtonTerminUebersicht);

        ButtonSonnenbankUebersicht.setText("Wechsele zur Sonnenbankübersicht");
        ButtonSonnenbankUebersicht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSonnenbankUebersichtActionPerformed(evt);
            }
        });
        oben.add(ButtonSonnenbankUebersicht);
        add(oben, BorderLayout.NORTH);

        mitte.setLayout(new GridLayout());

        DefaultTableModel dtm = new DefaultTableModel();
        LinkedList<ApplicationUserObject> list = new UserController().getAllUser();


        String[] columnnames = new String[]{"ID", "Vorname", "Nachname","Geburtstag", "E-Mail", "Passwort"};
        dtm.setColumnIdentifiers(columnnames);

        for (ApplicationUserObject u : list) {

            String[] r = {u.getID() + "", u.getVorname() + "", u.getNachname() + "", u.getGeburtstag() + "", u.getEmail() + "", u.getPasswort() + ""};
            dtm.addRow(r);
        }
        dtm.setColumnIdentifiers(columnnames);


        TabelleTerminUebersicht.setModel(dtm);
        TabelleTerminUebersicht.setCellSelectionEnabled(true);
        TabelleTerminUebersicht.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mitteScrollPane.setViewportView(TabelleTerminUebersicht);
        mitte.add(mitteScrollPane);

        add(mitte, java.awt.BorderLayout.CENTER);

        ButtonCreateTermin.setText("Registeriere User");
        ButtonCreateTermin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateTerminActionPerformed(evt);
            }
        });

        unten.add(ButtonCreateTermin);

        ButtonEditTermin.setText("Bearbeite User");
        ButtonEditTermin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditTerminActionPerformed(evt);
            }
        });

        unten.add(ButtonEditTermin);

        ButtonDeleteTermin.setText("Lösche User");
        ButtonDeleteTermin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteTerminActionPerformed(evt);
            }
        });

        unten.add(ButtonDeleteTermin);

        add(unten, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void ButtonDeleteTerminActionPerformed(ActionEvent evt) {
        int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie den ausgewählten User löschen?", "Löschen bestätigen", JOptionPane.YES_NO_CANCEL_OPTION);
        if (eingabe == 0) // Clicked Ja
        {
            int row = TabelleTerminUebersicht.getSelectedRow();
            /*TerminObject to = new TerminObject(
                    (int) TabelleTerminUebersicht.getModel().getValueAt(row, 0),
                    LocalDate.parse( (String) TabelleTerminUebersicht.getModel().getValueAt(row, 1)),
                    LocalTime.parse((String) TabelleTerminUebersicht.getModel().getValueAt(row, 2)),
                    LocalTime.parse((String) TabelleTerminUebersicht.getModel().getValueAt(row, 3)),
                    (String) TabelleTerminUebersicht.getModel().getValueAt(row, 4),
                    (String) TabelleTerminUebersicht.getModel().getValueAt(row, 5));*/
            UserController controller = new UserController();
            if (controller.DeleteUser(Integer.parseInt((String)TabelleTerminUebersicht.getModel().getValueAt(row, 0)))== true)
            {
                JOptionPane.showMessageDialog(null,
                        "Löschen fertiggestellt!",
                        "Löschen fertig!",
                        JOptionPane.WARNING_MESSAGE);

                DefaultTableModel d = new DefaultTableModel();
                LinkedList<ApplicationUserObject> list = new UserController().getAllUser();

                String[] columnnames = new String[]{"ID", "Vorname", "Nachname","Geburtstag", "E-Mail", "Passwort"};
                d.setColumnIdentifiers(columnnames);

                for (ApplicationUserObject u : list) {

                    String[] r = {u.getID() + "", u.getVorname() + "", u.getNachname() + "", u.getGeburtstag() + "", u.getEmail() + "", u.getPasswort() + ""};
                    d.addRow(r);
                }

                TabelleTerminUebersicht.setModel(d);
                TabelleTerminUebersicht.repaint();
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

    private void ButtonEditTerminActionPerformed(ActionEvent evt) {
        //TODO: EDIT BUtton
        int row = TabelleTerminUebersicht.getSelectedRow();
        ApplicationUserObject to = new ApplicationUserObject(
                Integer.parseInt((String)TabelleTerminUebersicht.getModel().getValueAt(row, 0)),
                (String) TabelleTerminUebersicht.getModel().getValueAt(row, 1),
                (String) TabelleTerminUebersicht.getModel().getValueAt(row, 2),
                LocalDate.parse((String) TabelleTerminUebersicht.getModel().getValueAt(row, 3)),
                (String) TabelleTerminUebersicht.getModel().getValueAt(row, 4),
                (String) TabelleTerminUebersicht.getModel().getValueAt(row, 5));
        Edit et = new Edit(to);
        et.setVisible(true);
        this.dispose();
    }

    private void ButtonCreateTerminActionPerformed(ActionEvent evt) {
        Register ct = new Register();
        ct.setVisible(true);
        this.dispose();
    }

    private void ButtonTerminUebersichtActionPerformed(ActionEvent evt) {
        OverviewTermin ou = new OverviewTermin();
        ou.setVisible(true);
        this.dispose();
    }

    private void ButtonSonnenbankUebersichtActionPerformed(ActionEvent evt) {
        OverviewSonnenbank os = new OverviewSonnenbank();
        os.setVisible(true);
        this.dispose();
    }
}

