package primer02_skup_bez_jednakosti;

/**
 * Namerno NE redefinišemo equals i hashCode.
 *
 * Želimo da vidimo kako se HashSet ponaša sa podrazumevanom
 * jednakošću objekata.
 */
public class Pesma {
    private final String naslov;
    private final String izvodjac;

    public Pesma(String naslov, String izvodjac) {
        this.naslov = naslov;
        this.izvodjac = izvodjac;
    }

    public String opis() {
        return izvodjac + " - " + naslov;
    }
}
