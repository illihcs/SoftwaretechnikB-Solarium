package Model;


import java.util.Date;

public class ApplicationUserObject {

    private int ID;
    private String Vorname;
    private String Nachname;
    private Date Geburtstag;
    private String Email;
    private String Passwort;

    public ApplicationUserObject(int ID, String Vorname, String Nachname, Date Geburtstag, String Email, String Passwort) {
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

    public Date getGeburtstag() {
        return Geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
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
