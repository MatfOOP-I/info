package primer05_nepromenljiva_adresa;

/**
 * Nepromenljiva (immutable) adresa.
 *
 * <p>Nakon konstruktora stanje objekta više ne može da se promeni:
 * polja su {@code final}, a klasa nema metode koje ih menjaju.</p>
 *
 * <p>Zbog toga isti Adresa objekat može bezbedno da deli više objekata.
 * Niko ne može kasnije da ga promeni "ispod nogu" ostalim korisnicima.</p>
 */
public class Adresa {
    private final String ulica;
    private final int broj;
    private final String grad;

    public Adresa(String ulica, int broj, String grad) {
        this.ulica = ulica;
        this.broj = broj;
        this.grad = grad;
    }

    public String opis() {
        return ulica + " " + broj + ", " + grad;
    }
}
