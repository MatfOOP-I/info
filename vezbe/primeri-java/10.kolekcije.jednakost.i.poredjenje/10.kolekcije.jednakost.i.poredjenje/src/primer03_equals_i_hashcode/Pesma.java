package primer03_equals_i_hashcode;

import java.util.Objects;

/**
 * U ovom modelu pesmu identifikuju izvođač i naslov.
 *
 * Zato baš ta polja koristimo za equals i hashCode.
 */
public class Pesma {
    private final String naslov;
    private final String izvodjac;

    public Pesma(String naslov, String izvodjac) {
        this.naslov = naslov;
        this.izvodjac = izvodjac;
    }

    @Override
    public boolean equals(Object objekat) {
        if (this == objekat) {
            return true;
        }

        if (!(objekat instanceof Pesma druga)) {
            return false;
        }

        return Objects.equals(naslov, druga.naslov)
                && Objects.equals(izvodjac, druga.izvodjac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naslov, izvodjac);
    }

    public String opis() {
        return izvodjac + " - " + naslov;
    }
}
