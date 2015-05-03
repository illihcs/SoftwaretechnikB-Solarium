package Model;

import java.time.LocalDate;

/**
 * Created by Win7-Dev on 03.05.2015.
 */
public class ApplicationUserObject {

    private int ID = 0;
    private String  Vorname;
    private String  Nachname;
    private LocalDate Geburtstag;
    private String Email;
    private String Passwort;

    public  ApplicationUserObject(int IDs,String  Vorname, String  Nachname, LocalDate Geburtstag, String Email, String Passwort ){
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

    public String getVorname() {
        return Vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public LocalDate getGeburtstag() {
        return Geburtstag;
    }

    public String getEmail() {
        return Email;
    }

    public String getPasswort() {
        return Passwort;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public void setGeburtstag(LocalDate geburtstag) {
        Geburtstag = geburtstag;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }
}
