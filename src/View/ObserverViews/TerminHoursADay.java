package View.ObserverViews;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controller.TerminController;
import Controller.UserController;
import Model.TerminObject;

public class TerminHoursADay extends JFrame implements Observer{

	//Variables declaration
	private JPanel center;
	private JScrollPane centerScrollPane;
	private JTable TableTerminHoursADay;
	//End of Variable declaration
	
	public TerminHoursADay() throws SQLException {
		initComponents();
	}
	
	private void initComponents() throws SQLException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Gesamtstunden der Termine über den Tag");
        setLayout(new BorderLayout());
        
        center = new JPanel();
        centerScrollPane = new JScrollPane();
        TableTerminHoursADay = new JTable();
        
        
        center.setLayout(new GridLayout());
        DefaultTableModel dtm = new DefaultTableModel();
        LinkedList<String[]> list =  TerminController.getInstance().getTerminHoursADay();
        String[] columnnames = new String[]{"Datum", "Anzahl Termine", "Gesamtdauer", "Durchschnittsdauer"};
        dtm.setColumnIdentifiers(columnnames);

        for (String[] t : list) {

            String[] row = {t[0], t[1], t[2], t[3]};
            dtm.addRow(row);

        }

        TableTerminHoursADay.setModel(dtm);
        TableTerminHoursADay.setCellSelectionEnabled(true);
        TableTerminHoursADay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerScrollPane.setViewportView(TableTerminHoursADay);
        center.add(centerScrollPane);
        
        add(center, BorderLayout.CENTER);
        
        setSize(400,400);
        setLocation(0, 0);
                
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		DefaultTableModel d = new DefaultTableModel();
		LinkedList<String[]> list = (LinkedList<String[]>) arg1;

        // Define Table cols
        String[] columnnames = new String[]{"ID", "Vorname", "Nachname", "Geburtstag", "E-Mail", "Passwort"};
        d.setColumnIdentifiers(columnnames);

        // fill table with rows
        for (String[] u : list) {
            String[] r = {u[0], u[1], u[2], u[3]};
            d.addRow(r);
        }

        TableTerminHoursADay.setModel(d);
        TableTerminHoursADay.repaint();
	}	
}






















