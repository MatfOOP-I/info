package primer04_deljena_promenljiva_adresa;

/**
 * Porudžbina čuva referencu na adresu koja je važila u trenutku
 * kreiranja porudžbine.
 *
 * <p>Problem: ako je ta adresa promenljiva i deli se sa kupcem,
 * promena kroz kupca menja i ono što porudžbina vidi.</p>
 */
public class Porudzbina {
    private Adresa adresaZaDostavu;

    public Porudzbina(Adresa adresaZaDostavu) {
        this.adresaZaDostavu = adresaZaDostavu;
    }

    public String opisAdreseZaDostavu() {
        return adresaZaDostavu.opis();
    }
}
