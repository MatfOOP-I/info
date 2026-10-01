package primer02_refaktorisano_resenje.model;

/**
 * Automobil JESTE vozilo.
 */
public class Automobil extends Vozilo {
    public Automobil(
            String oznaka,
            String naziv,
            int cenaPoDanu
    ) {
        super(oznaka, naziv, cenaPoDanu);
    }

    @Override
    public int izracunajDepozit() {
        return getCenaPoDanu() * 2;
    }
}
