package primer06_record_adresa;

/**
 * Record je pogodan za male objekte koji prvenstveno nose podatke.
 *
 * Java automatski generiše:
 *
 * - konstruktor za sve komponente;
 * - accessor metode: ulica(), grad(), postanskiBroj();
 * - equals();
 * - hashCode();
 * - toString().
 *
 * Komponente record-a su nepromenljive nakon kreiranja objekta.
 */
public record Adresa(
        String ulica,
        String grad,
        String postanskiBroj
) {
    /**
     * Record i dalje može da ima sopstvenu validaciju.
     *
     * Ovo je kompaktni konstruktor: nema ponavljanja liste parametara.
     */
    public Adresa {
        if (ulica == null || ulica.isBlank()) {
            throw new IllegalArgumentException(
                    "Ulica je obavezna."
            );
        }

        if (grad == null || grad.isBlank()) {
            throw new IllegalArgumentException(
                    "Grad je obavezan."
            );
        }

        if (postanskiBroj == null || postanskiBroj.isBlank()) {
            throw new IllegalArgumentException(
                    "Poštanski broj je obavezan."
            );
        }
    }

    /**
     * Record nije ograničen samo na podatke.
     * Može da ima i metode kada one prirodno pripadaju objektu.
     */
    public String punaAdresa() {
        return ulica + ", " + postanskiBroj + " " + grad;
    }
}
