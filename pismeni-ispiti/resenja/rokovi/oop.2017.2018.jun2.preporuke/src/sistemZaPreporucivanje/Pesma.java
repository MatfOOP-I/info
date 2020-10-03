package sistemZaPreporucivanje;

import java.util.Set;

public class Pesma extends ZabavniSadrzaj {

    private String izvodjac, zanr;

    public Pesma(String naziv, int duzinaTrajanja, String izvodjac, String zanr) {
        super(naziv, duzinaTrajanja);
        this.izvodjac = izvodjac;
        this.zanr = zanr;
    }


    @Override
    public boolean zaPreporuku(String uslov, int opcija, Set<ZabavniSadrzaj> ocenjenSadrzaj) {

        if (ocenjenSadrzaj.contains(this)) {
            return false;
        }

        switch (opcija) {
            case 1:
                return uslov.equals(izvodjac);
            case 2:
                return !uslov.trim().equals("") && zanr.contains(uslov.trim());
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "[pesma] " + super.toString();
    }

    @Override
    public int compareTo(ZabavniSadrzaj o) {
        if (o instanceof Film)
            return 1;
        else
            return this.getNaziv().compareTo(o.getNaziv());
    }
}
