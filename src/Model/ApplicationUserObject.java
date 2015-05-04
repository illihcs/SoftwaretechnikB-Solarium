package Model;

import java.time.LocalDate;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class ApplicationUserObject {

    private int ID;
    private String Vorname;
    private String Nachname;
    private LocalDate Geburtstag;
    private String Email;
    private String Passwort;

    public ApplicationUserObject(int ID, String Vorname, String Nachname, LocalDate Geburtstag, String Email, String Passwort) {
        this.ID = ID;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Geburtstag = Geburtstag;
        this.Email = Email;
        this.Passwort = Passwort;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public LocalDate getGeburtstag() {
        return Geburtstag;
    }

    public void setGeburtstag(LocalDate geburtstag) {
        Geburtstag = geburtstag;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPasswort() {
        return Passwort;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }
}
