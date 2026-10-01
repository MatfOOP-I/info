package primer02_refaktorisano_resenje.stanje;

/**
 * Operacija nema smisla u trenutnom stanju rezervacije.
 *
 * Koristimo unchecked izuzetak jer je pokušaj nedozvoljene
 * tranzicije greška u načinu korišćenja objekta.
 */
public class NedozvoljenaOperacijaException
        extends RuntimeException {

    public NedozvoljenaOperacijaException(String poruka) {
        super(poruka);
    }
}
