package primer02_refaktorisano_resenje.model;

import java.util.Objects;

/**
 * Korisnika identifikuje članski broj.
 */
public class Korisnik {
    private final String clanskiBroj;
    private final String ime;

    public Korisnik(String clanskiBroj, String ime) {
        if (clanskiBroj == null || clanskiBroj.isBlank()) {
            throw new IllegalArgumentException(
                    "Članski broj je obavezan."
            );
        }

        if (ime == null || ime.isBlank()) {
            throw new IllegalArgumentException(
                    "Ime je obavezno."
            );
        }

        this.clanskiBroj = clanskiBroj;
        this.ime = ime;
    }

    public String getClanskiBroj() {
        return clanskiBroj;
    }

    public String getIme() {
        return ime;
    }

    @Override
    public boolean equals(Object objekat) {
        if (this == objekat) {
            return true;
        }

        if (!(objekat instanceof Korisnik drugi)) {
            return false;
        }

        return Objects.equals(
                clanskiBroj,
                drugi.clanskiBroj
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(clanskiBroj);
    }
}
