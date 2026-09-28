package primer04_polimorfizam;

public class Voz extends Prevoz {
    public Voz() { super("Voz"); }

    @Override
    public int izracunajCenu(int udaljenostKm) {
        return 250 + udaljenostKm * 8;
    }
}
