package primer02_refaktorisano_resenje.model;

import java.util.Objects;

/**
 * Zajednička apstrakcija za vozila.
 *
 * Vozilo samo štiti svoju dostupnost.
 * Spoljni kod više ne postavlja proizvoljan boolean.
 */
public abstract class Vozilo {
    private final String oznaka;
    private final String naziv;
    private final int cenaPoDanu;
    private boolean dostupno = true;

    public Vozilo(
            String oznaka,
            String naziv,
            int cenaPoDanu
    ) {
        if (oznaka == null || oznaka.isBlank()) {
            throw new IllegalArgumentException(
                    "Oznaka vozila je obavezna."
            );
        }

        if (naziv == null || naziv.isBlank()) {
            throw new IllegalArgumentException(
                    "Naziv vozila je obavezan."
            );
        }

        if (cenaPoDanu <= 0) {
            throw new IllegalArgumentException(
                    "Cena mora biti pozitivna."
            );
        }

        this.oznaka = oznaka;
        this.naziv = naziv;
        this.cenaPoDanu = cenaPoDanu;
    }

    /**
     * Različite vrste vozila imaju različito pravilo depozita.
     */
    public abstract int izracunajDepozit();

    final void rezervisi() {
        if (!dostupno) {
            throw new IllegalStateException(
                    "Vozilo je već rezervisano."
            );
        }

        dostupno = false;
    }

    final void oslobodi() {
        dostupno = true;
    }

    public String getOznaka() {
        return oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getCenaPoDanu() {
        return cenaPoDanu;
    }

    public boolean isDostupno() {
        return dostupno;
    }

    @Override
    public final boolean equals(Object objekat) {
        if (this == objekat) {
            return true;
        }

        if (!(objekat instanceof Vozilo drugo)) {
            return false;
        }

        return Objects.equals(oznaka, drugo.oznaka);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(oznaka);
    }
}
