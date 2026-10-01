package primer02_eksplozija_hijerarhije;

/**
 * Ova klasa predstavlja jednu KOMBINACIJU dva ponašanja.
 *
 * Problem je što svaka nova nezavisna osobina proizvodi još kombinacija.
 */
public class HodajuciBezeciLik extends Lik {
    public HodajuciBezeciLik(String ime) {
        super(ime);
    }

    @Override
    public void kreciSe() {
        System.out.println(getIme() + " hoda.");
    }

    @Override
    public void reagujNaOpasnost() {
        System.out.println(getIme() + " beži.");
    }
}
