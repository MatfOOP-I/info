package videoteka;

public class Clan {

    private String ime, omiljeniZanr;

    public Clan(String ime, String omiljeniZanr) {
        this.ime = ime;
        this.omiljeniZanr = omiljeniZanr;
    }

    public String getIme() {
        return ime;
    }

    public String getOmiljeniZanr() {
        return omiljeniZanr;
    }

    @Override
    public String toString() {
        return "Ime: " + ime + "; Omiljeni zanr: " + omiljeniZanr;
    }
}
