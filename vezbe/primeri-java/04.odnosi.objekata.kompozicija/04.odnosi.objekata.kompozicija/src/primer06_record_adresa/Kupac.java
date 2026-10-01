package primer06_record_adresa;

/**
 * Kupac HAS-A Adresa.
 *
 * Ovde record koristimo kao mali nepromenljivi value objekat.
 */
public class Kupac {
    private final String ime;
    private Adresa adresa;

    public Kupac(String ime, Adresa adresa) {
        this.ime = ime;
        this.adresa = adresa;
    }

    public String getIme() {
        return ime;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void preseliSe(Adresa novaAdresa) {
        adresa = novaAdresa;
    }
}
