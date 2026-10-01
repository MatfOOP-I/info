package primer02_redefinisanje_metoda;

public class Voz extends Prevoz {
    public Voz(String naziv) {
        super(naziv);
    }

    @Override
    public int izracunajCenu(int udaljenostKm) {
        return 250 + udaljenostKm * 8;
    }
}
