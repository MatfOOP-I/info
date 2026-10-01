package primer02_porudzbina_i_stavke;

public class Kupac {
    private String ime;
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
}
