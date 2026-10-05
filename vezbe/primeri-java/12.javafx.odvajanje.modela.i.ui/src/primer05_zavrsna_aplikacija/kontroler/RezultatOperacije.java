package primer05_zavrsna_aplikacija.kontroler;

/**
 * Mali objekat kojim kontroler vraća rezultat korisničke operacije.
 *
 * Ne zavisi od JavaFX-a.
 */
public record RezultatOperacije(boolean uspesno, String poruka) {

    public static RezultatOperacije uspeh(String poruka) {
        return new RezultatOperacije(true, poruka);
    }

    public static RezultatOperacije greska(String poruka) {
        return new RezultatOperacije(false, poruka);
    }
}
