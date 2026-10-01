package primer02_porudzbina_i_stavke;

/**
 * Jedna stavka porudžbine.
 *
 * <p>Stavka ne kopira naziv i cenu proizvoda u svoja polja. Ona čuva
 * referencu na objekat {@link Proizvod} i količinu tog proizvoda.</p>
 */
public class StavkaPorudzbine {
    private Proizvod proizvod;
    private int kolicina;

    public StavkaPorudzbine(Proizvod proizvod, int kolicina) {
        this.proizvod = proizvod;
        this.kolicina = kolicina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public int getKolicina() {
        return kolicina;
    }

    public int izracunajCenu() {
        return proizvod.getCena() * kolicina;
    }
}
