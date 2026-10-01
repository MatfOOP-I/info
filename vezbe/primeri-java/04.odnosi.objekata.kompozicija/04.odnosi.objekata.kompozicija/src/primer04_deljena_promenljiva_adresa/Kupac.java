package primer04_deljena_promenljiva_adresa;

public class Kupac {
    private String ime;
    private Adresa adresa;

    public Kupac(String ime, Adresa adresa) {
        this.ime = ime;
        this.adresa = adresa;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public String opis() {
        return ime + " — " + adresa.opis();
    }
}
