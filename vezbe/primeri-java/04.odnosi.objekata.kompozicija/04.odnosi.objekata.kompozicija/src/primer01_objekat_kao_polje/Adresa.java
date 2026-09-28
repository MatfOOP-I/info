package primer01_objekat_kao_polje;

/**
 * Jednostavna adresa kupca.
 *
 * <p>Ova klasa nam služi da prvi put eksplicitno koristimo objekat
 * kao deo stanja drugog objekta.</p>
 */
public class Adresa {
    private String ulica;
    private int broj;
    private String grad;

    public Adresa(String ulica, int broj, String grad) {
        this.ulica = ulica;
        this.broj = broj;
        this.grad = grad;
    }

    public String opis() {
        return ulica + " " + broj + ", " + grad;
    }
}
