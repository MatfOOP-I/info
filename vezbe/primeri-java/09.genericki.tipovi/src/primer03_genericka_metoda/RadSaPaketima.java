package primer03_genericka_metoda;

/**
 * Klasa nije generička, ali njena metoda jeste.
 */
public class RadSaPaketima {
    /**
     * Prebacuje sadržaj iz jednog paketa u drugi paket ISTOG tipa.
     *
     * <T> ispred povratnog tipa uvodi parametar tipa metode.
     */
    public static <T> void prebaci(
            Paket<T> izvor,
            Paket<T> odrediste
    ) {
        odrediste.postaviSadrzaj(izvor.getSadrzaj());
    }
}
