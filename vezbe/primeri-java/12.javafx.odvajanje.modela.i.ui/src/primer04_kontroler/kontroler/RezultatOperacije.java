package primer04_kontroler.kontroler;

/**
 * Mali objekat kojim kontroler vraća rezultat korisničke operacije.
 *
 * Ne zavisi od JavaFX-a.
 */
public class RezultatOperacije {
    private final boolean uspesno;
    private final String poruka;

    private RezultatOperacije(boolean uspesno, String poruka) {
        this.uspesno = uspesno;
        this.poruka = poruka;
    }

    public static RezultatOperacije uspeh(String poruka) {
        return new RezultatOperacije(true, poruka);
    }

    public static RezultatOperacije greska(String poruka) {
        return new RezultatOperacije(false, poruka);
    }

    public boolean isUspesno() {
        return uspesno;
    }

    public String getPoruka() {
        return poruka;
    }
}
