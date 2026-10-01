package primer06_odgovornost_za_gresku;

/**
 * Odgovornost ove klase je samo:
 *
 * tekst -> Rezervacija
 *
 * Ne odlučuje da li se zbog greške prekida program.
 */
public class ParserRezervacije {
    public static Rezervacija parsiraj(String red)
            throws NeispravanRedException {

        String[] delovi = red.split(",", -1);

        if (delovi.length != 4) {
            throw new NeispravanRedException(
                    "Pogrešan broj polja."
            );
        }

        if (delovi[0].isBlank() || delovi[1].isBlank() || delovi[3].isBlank()) {
            throw new NeispravanRedException("Ime, prezime i destinacija su obavezni.");
        }

        int godine;

        try {
            godine = Integer.parseInt(delovi[2].trim());
        } catch (NumberFormatException e) {
            throw new NeispravanRedException(
                    "Godine nisu broj.", e
            );
        }

        if (godine < 0 || godine > 120) {
            throw new NeispravanRedException(
                    "Neispravne godine."
            );
        }

        return new Rezervacija(
                delovi[0],
                delovi[1],
                godine,
                delovi[3]
        );
    }
}
