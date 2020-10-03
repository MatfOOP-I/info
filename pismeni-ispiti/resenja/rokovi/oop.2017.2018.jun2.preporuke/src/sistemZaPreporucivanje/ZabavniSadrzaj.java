package sistemZaPreporucivanje;

import java.util.Set;

public abstract class ZabavniSadrzaj implements Comparable<ZabavniSadrzaj> {

    private String naziv;
    private int duzinaTrajanja;

    public ZabavniSadrzaj(String naziv, int duzinaTrajanja) {
        this.naziv = naziv;
        this.duzinaTrajanja = duzinaTrajanja;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getDuzinaTrajanja() {
        return duzinaTrajanja;
    }


    public abstract boolean zaPreporuku(String uslov, int opcija, Set<ZabavniSadrzaj> ocenjenSadrzaj);

    public String konvertovano() {
        return "" + getDuzinaTrajanja()/60 + ":" + getDuzinaTrajanja()%60;
    }

    @Override
    public String toString() {
        return naziv + " " + konvertovano();
    }

}
