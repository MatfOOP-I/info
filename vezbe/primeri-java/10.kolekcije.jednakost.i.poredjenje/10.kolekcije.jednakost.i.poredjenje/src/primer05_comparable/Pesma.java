package primer05_comparable;

import java.util.Objects;

/**
 * Prirodni poredak pesme je:
 *
 * 1. po naslovu;
 * 2. ako je naslov isti, po izvođaču.
 *
 * equals/hashCode i compareTo koriste iste identifikacione podatke,
 * što daje dosledno ponašanje i u HashSet i u TreeSet kolekcijama.
 */
public class Pesma implements Comparable<Pesma> {
    private final String naslov;
    private final String izvodjac;

    public Pesma(String naslov, String izvodjac) {
        this.naslov = naslov;
        this.izvodjac = izvodjac;
    }

    public String getNaslov() {
        return naslov;
    }

    public String getIzvodjac() {
        return izvodjac;
    }

    @Override
    public int compareTo(Pesma druga) {
        int poNaslovu = naslov.compareTo(druga.naslov);

        if (poNaslovu != 0) {
            return poNaslovu;
        }

        return izvodjac.compareTo(druga.izvodjac);
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
