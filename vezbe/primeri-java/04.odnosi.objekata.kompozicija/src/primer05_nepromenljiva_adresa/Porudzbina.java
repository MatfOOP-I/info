package primer05_nepromenljiva_adresa;

public class Porudzbina {
    private final Adresa adresaZaDostavu;

    public Porudzbina(Adresa adresaZaDostavu) {
        this.adresaZaDostavu = adresaZaDostavu;
    }

    public String opisAdreseZaDostavu() {
        return adresaZaDostavu.opis();
    }
}
