package rs.math.oop1.z080100.apstraktneKlase.z01.fakultet;

public abstract class Covek {

    private String ime = "";
    private String prezime = "";
    private String nadimak = "";

    public Covek(String ime, String prezime, String nadimak) {
        this.ime = ime;
        this.prezime = prezime;
        this.nadimak = nadimak;
    }

    public Covek(String ime, String prezime) {
        this(ime, prezime, "");
    }

    public String getIme() {

        return ime;
    }

    public void setIme(String ime) {

        this.ime = ime;
    }

    public String getPrezime() {

        return prezime;
    }

    public void setPrezime(String prezime) {

        this.prezime = prezime;
    }

    public String getNadimak() {

        return nadimak;
    }

    public void setNadimak(String nadimak) {

        this.nadimak = nadimak;
    }

    public abstract void prikazi();

}