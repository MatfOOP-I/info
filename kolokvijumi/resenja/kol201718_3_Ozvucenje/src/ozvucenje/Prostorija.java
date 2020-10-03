package ozvucenje;

public class Prostorija {
    protected String naziv;
    protected double duzina, sirina;

    public Prostorija(String naziv, double duzina, double sirina) {
        this.naziv = naziv;
        this.duzina = duzina;
        this.sirina = sirina;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getDuzina() {
        return duzina;
    }

    public double getSirina() {
        return sirina;
    }

    @Override
    public String toString() {
        return "Prostorija " + naziv + " povrsine "+(duzina*sirina)+"m^2.";
    }

}
