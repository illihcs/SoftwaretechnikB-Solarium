package Model;

import java.sql.Time;
import java.util.Date;

public class TerminHoursADayObject {
	
	private Date datum;
	private int	anzahl;
	private long gesamtdauer; //in minutes
	private long durchschnittsdauer; //in minutes
	
	public TerminHoursADayObject() {
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	/**
	 * @return the anzahl
	 */
	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * @param anzahl the anzahl to set
	 */
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	/**
	 * @return the gesamtdauer
	 */
	public long getGesamtdauer() {
		return gesamtdauer;
	}

	/**
	 * @param gesamtdauer the gesamtdauer to set
	 */
	public void setGesamtdauer(long gesamtdauer) {
		this.gesamtdauer = gesamtdauer;
	}

	/**
	 * @return the durchschnittsdauer
	 */
	public long getDurchschnittsdauer() {
		return durchschnittsdauer;
	}

	/**
	 * @param durchschnittsdauer the durchschnittsdauer to set
	 */
	public void setDurchschnittsdauer(long durchschnittsdauer) {
		this.durchschnittsdauer = durchschnittsdauer;
	}
	
}
