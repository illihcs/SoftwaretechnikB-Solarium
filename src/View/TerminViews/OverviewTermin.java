package View.TerminViews;

import View.SonnenbankViews.OverviewSonnenbank;
import View.UserViews.OverviewUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        TabelleTerminUebersicht.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Datum", "Uhrzeit Von", "Uhrzeit Bis", "Sonnenbank", "Kundenname"
                }
        ));
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
        //TODO add your handling code here:
    }

    private void ButtonEditTerminActionPerformed(ActionEvent evt) {
        //TODO add your handling code here:
    }

    private void ButtonCreateTerminActionPerformed(ActionEvent evt) {
        //TODO add your handling code here:
        CreateTermin ct = new CreateTermin();
        ct.setVisible(true);
        this.dispose();
    }

    private void ButtonBenutzerUebersichtActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        OverviewUser ou = new OverviewUser();
        ou.setVisible(true);
        this.dispose();
    }

    private void ButtonSonnenbankUebersichtActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        OverviewSonnenbank os = new OverviewSonnenbank();
        os.setVisible(true);
        this.dispose();
    }
}
