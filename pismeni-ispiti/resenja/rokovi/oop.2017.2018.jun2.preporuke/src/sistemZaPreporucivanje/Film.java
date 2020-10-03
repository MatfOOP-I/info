package sistemZaPreporucivanje;

import java.util.Set;

public class Film extends ZabavniSadrzaj {

    private int godina;
    private String glumac;

    public Film(String naziv, int duzinaTrajanja, int godina, String glumac) {
        super(naziv, duzinaTrajanja);
        this.godina = godina;
        this.glumac = glumac;
    }


    @Override
    public boolean zaPreporuku(String uslov, int opcija, Set<ZabavniSadrzaj> ocenjenSadrzaj) {

        if (ocenjenSadrzaj.contains(this)) {
            return false;
        }

        switch (opcija) {
            case 1:
                return uslov.equals(glumac);
            case 2:
                try {
                    return godina == Integer.parseInt(uslov);
                }
                catch (NumberFormatException e) {
                    return false;
                }
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "[film] " + super.toString();
    }

    @Override
    public int compareTo(ZabavniSadrzaj o) {
        if (o instanceof Film)
            return this.getNaziv().compareTo(o.getNaziv());
        else
            return -1;
    }
}
