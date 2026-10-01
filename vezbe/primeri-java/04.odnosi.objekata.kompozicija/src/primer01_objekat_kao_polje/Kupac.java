package primer01_objekat_kao_polje;

/**
 * Kupac IMA adresu.
 *
 * <p>Polje {@code adresa} ne sadrži ceo objekat "unutar" kupca u smislu
 * kopiranja svih njegovih polja. Ono sadrži referencu na objekat klase
 * {@link Adresa}.</p>
 */
public class Kupac {
    private String ime;
    private String prezime;
    private Adresa adresa;

    public Kupac(String ime, String prezime, Adresa adresa) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
    }

    public String opis() {
        return ime + " " + prezime + " — " + adresa.opis();
    }
}
