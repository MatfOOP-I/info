package primer04_deljena_promenljiva_adresa;

/**
 * Namerno promenljiva verzija adrese.
 *
 * <p>Koristimo je da pokažemo problem kada dva objekta dele istu
 * referencu na promenljiv objekat.</p>
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

    public void promeni(String ulica, int broj, String grad) {
        this.ulica = ulica;
        this.broj = broj;
        this.grad = grad;
    }

    public String opis() {
        return ulica + " " + broj + ", " + grad;
    }
}
