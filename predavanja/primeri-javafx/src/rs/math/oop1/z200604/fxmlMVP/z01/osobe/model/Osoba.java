package rs.math.oop1.z200604.fxmlMVP.z01.osobe.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Osoba {
    private final StringProperty ime = new SimpleStringProperty();
    
    public final StringProperty imeProperty() {
        return this.ime;
    }

    public final String getIme() {
        return this.imeProperty().get();
    }

    public final void setIme(final String ime) {
        this.imeProperty().set(ime);
    }

    private final StringProperty prezime = new SimpleStringProperty();
    
    public final StringProperty prezimeProperty() {
        return this.prezime;
    }

    public final String getPrezime() {
        return this.prezimeProperty().get();
    }

    public final void setPrezime(final String prezime) {
        this.prezimeProperty().set(prezime);
    }

    private final StringProperty email = new SimpleStringProperty();

    public final StringProperty emailProperty() {
        return this.email;
    }

    public final String getEmail() {
        return this.emailProperty().get();
    }

    public final void setEmail(final String email) {
        this.emailProperty().set(email);
    }
    
    public Osoba(String ime, String prezime, String email) {
        setIme(ime);
        setPrezime(prezime);
        setEmail(email);
    }
}
