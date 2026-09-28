package primer02_redefinisanje_metoda;

public class Autobus extends Prevoz {
    public Autobus(String naziv) {
        super(naziv);
    }

    /**
     * Autobus ima početnu cenu karte i manju cenu po kilometru.
     */
    @Override
    public int izracunajCenu(int udaljenostKm) {
        return 150 + udaljenostKm * 7;
    }
}
