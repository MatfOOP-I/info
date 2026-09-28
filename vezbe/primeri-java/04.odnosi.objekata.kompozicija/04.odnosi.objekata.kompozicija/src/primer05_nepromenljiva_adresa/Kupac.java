package primer05_nepromenljiva_adresa;

public class Kupac {
    private final String ime;
    private Adresa trenutnaAdresa;

    public Kupac(String ime, Adresa trenutnaAdresa) {
        this.ime = ime;
        this.trenutnaAdresa = trenutnaAdresa;
    }

    public Adresa getTrenutnaAdresa() {
        return trenutnaAdresa;
    }

    /**
     * Ne menjamo postojeći Adresa objekat. Kupac samo počinje da
     * pokazuje na drugi, novi objekat.
     */
    public void promeniAdresu(Adresa novaAdresa) {
        if (novaAdresa != null) {
            trenutnaAdresa = novaAdresa;
        }
    }

    public String opis() {
        return ime + " — " + trenutnaAdresa.opis();
    }
}
