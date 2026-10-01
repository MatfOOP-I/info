package primer05_apstraktna_klasa_i_interfejs;

/**
 * Apstraktna klasa predstavlja zajedničku VRSTU objekata.
 *
 * Kartice dele zajedničko stanje: vlasnika i poslednje četiri cifre.
 */
public abstract class PlatnaKartica {
    private final String vlasnik;
    private final String poslednjeCetiriCifre;

    public PlatnaKartica(String vlasnik, String poslednjeCetiriCifre) {
        this.vlasnik = vlasnik;
        this.poslednjeCetiriCifre = poslednjeCetiriCifre;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public String getPoslednjeCetiriCifre() {
        return poslednjeCetiriCifre;
    }

    public String opis() {
        return vlasnik + " **** " + poslednjeCetiriCifre;
    }
}
