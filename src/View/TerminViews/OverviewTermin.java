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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

/**
 * Created by admin on 03.05.2015.
 */
public class OverviewTermin extends JFrame {

    // Variables declaration - do not modify
    private JButton ButtonBenutzerUebersicht;
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
    public OverviewTermin() {
        initComponents();
    }

    private void initComponents() {

        oben = new JPanel();
        ButtonBenutzerUebersicht = new JButton();
        ButtonSonnenbankUebersicht = new JButton();
        mitte = new JPanel();
        mitteScrollPane = new JScrollPane();
        TabelleTerminUebersicht = new JTable();
        unten = new JPanel();
        ButtonCreateTermin = new JButton();
        ButtonEditTermin = new JButton();
        ButtonDeleteTermin = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Termin Übersicht");

        ButtonBenutzerUebersicht.setText("Wechsele zur Benutzerübersicht");
        ButtonBenutzerUebersicht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBenutzerUebersichtActionPerformed(evt);
            }
        });
        oben.add(ButtonBenutzerUebersicht);

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
        LinkedList<TerminObject> list = new Termin().getAllTermin();

        String[] columnnames = new String[]{"Datum", "Uhrzeit Von", "Uhrzeit Bis", "Sonnenbank", "Kundenname"};
        dtm.setColumnIdentifiers(columnnames);

        for (TerminObject t : list)
        {

            String[] socrates = { t.getID() + "", t.getDatum() + "", t.getUhrzeitVon() + "",  t.getUhrzeitBis() + "", t.getSonnenbank() + "", t.getKunde() + "" };
            dtm.addRow(socrates);

          /*  Object[] o = new Object[6];
            o[0] = t.getID();
            o[1] = t.getDatum();
            o[2] = t.getUhrzeitVon();
            o[3] =t.getUhrzeitBis();
            o[4] =t.getSonnenbank();
            o[5] =t.getKunde();
            dtm.addRow(o);*/
        }



        TabelleTerminUebersicht.setModel(dtm);
        TabelleTerminUebersicht.setCellSelectionEnabled(true);
        TabelleTerminUebersicht.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mitteScrollPane.setViewportView(TabelleTerminUebersicht);
        mitte.add(mitteScrollPane);

        add(mitte, java.awt.BorderLayout.CENTER);

        ButtonCreateTermin.setText("Erstelle Termin");
        ButtonCreateTermin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCreateTerminActionPerformed(evt);
            }
        });

        unten.add(ButtonCreateTermin);

        ButtonEditTermin.setText("Bearbeite Termin");
        ButtonEditTermin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditTerminActionPerformed(evt);
            }
        });

        unten.add(ButtonEditTermin);

        ButtonDeleteTermin.setText("Lösche Termin");
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
        int eingabe = JOptionPane.showConfirmDialog(null, "Möchten Sie den ausgewählten Termin löschen?", "Löschen bestätigen", JOptionPane.YES_NO_CANCEL_OPTION);
        if (eingabe == 1)
        {
            int row = TabelleTerminUebersicht.getSelectedRow();
            TerminObject to = new TerminObject(
                    (int) TabelleTerminUebersicht.getModel().getValueAt(row, 0),
                    LocalDate.parse( (String) TabelleTerminUebersicht.getModel().getValueAt(row, 1)),
                    LocalTime.parse((String) TabelleTerminUebersicht.getModel().getValueAt(row, 2)),
                    LocalTime.parse((String) TabelleTerminUebersicht.getModel().getValueAt(row, 3)),
                    (String) TabelleTerminUebersicht.getModel().getValueAt(row, 4),
                    (String) TabelleTerminUebersicht.getModel().getValueAt(row, 5));
            TerminController controller = new TerminController();
            if (controller.loescheTermin(to.getID())== true)
            {
                JOptionPane.showMessageDialog(null,
                        "Löschen fertiggestellt!",
                        "Löschen fertig!",
                        JOptionPane.WARNING_MESSAGE);
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
        //getSelectedUser
        //ApplicationUserObject user = new ApplicationUserObject(bla bla bla);
        //EditTermin et = new EditTermin(user);
        //et.setVisible(true);
        //this.dispose();
    }

    private void ButtonCreateTerminActionPerformed(ActionEvent evt) {
        CreateTermin ct = new CreateTermin();
        ct.setVisible(true);
        this.dispose();
    }

    private void ButtonBenutzerUebersichtActionPerformed(ActionEvent evt) {
        OverviewUser ou = new OverviewUser();
        ou.setVisible(true);
        this.dispose();
    }

    private void ButtonSonnenbankUebersichtActionPerformed(ActionEvent evt) {
        OverviewSonnenbank os = new OverviewSonnenbank();
        os.setVisible(true);
        this.dispose();
    }
}
