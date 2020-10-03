package vesala;

public abstract class Igrac {
    private String ime;
    private int nivo;
    private int brOdigranihPartija;
    private int brPobedjenihPartija;

    public Igrac(String ime, int nivo, int brOdigranihPartija, int brPobedjenihPartija) {
        this.ime = ime;
        this.nivo = nivo;
        this.brOdigranihPartija = brOdigranihPartija;
        this.brPobedjenihPartija = brPobedjenihPartija;
    }

    public String getIme() {
        return ime;
    }

    public int getNivo() {
        return nivo;
    }

    public int getBrOdigranihPartija() {
        return brOdigranihPartija;
    }

    public int getBrPobedjenihPartija() {
        return brPobedjenihPartija;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setNivo(int nivo) {
        this.nivo = nivo;
    }

    public void setBrOdigranihPartija(int brOdigranihPartija) {
        this.brOdigranihPartija = brOdigranihPartija;
    }

    public void setBrPobedjenihPartija(int brPobedjenihPartija) {
        this.brPobedjenihPartija = brPobedjenihPartija;
    }

    public abstract char odaberiSlovo(Rec trazenaRec);

    @Override
    public String toString() {
        return "[lvl" + nivo + "] " + ime + ", " + brPobedjenihPartija/brOdigranihPartija + "%";
    }
}
