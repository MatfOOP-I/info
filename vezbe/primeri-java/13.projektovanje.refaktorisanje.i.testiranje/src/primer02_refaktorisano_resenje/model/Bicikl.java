package primer02_refaktorisano_resenje.model;

/**
 * Bicikl JESTE vozilo.
 *
 * U ovom jednostavnom modelu za bicikl ne tražimo depozit.
 */
public class Bicikl extends Vozilo {
    public Bicikl(
            String oznaka,
            String naziv,
            int cenaPoDanu
    ) {
        super(oznaka, naziv, cenaPoDanu);
    }

    @Override
    public int izracunajDepozit() {
        return 0;
    }
}
