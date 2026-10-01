package primer04_sopstveni_izuzetak;

public class ParserRezervacije {
    public static Rezervacija parsiraj(String red)
            throws NeispravanRedException {

        String[] delovi = red.split(",", -1);

        if (delovi.length != 4) {
            throw new NeispravanRedException(
                    "Očekuju se tačno 4 polja."
            );
        }

        if (delovi[0].isBlank()
                || delovi[1].isBlank()
                || delovi[3].isBlank()) {
            throw new NeispravanRedException(
                    "Ime, prezime i destinacija ne smeju biti prazni."
            );
        }

        int godine;

        try {
            godine = Integer.parseInt(delovi[2].trim());
        } catch (NumberFormatException e) {
            throw new NeispravanRedException(
                    "Godine nisu ispravan broj.", e
            );
        }

        if (godine < 0 || godine > 120) {
            throw new NeispravanRedException(
                    "Godine nisu u dozvoljenom opsegu."
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
