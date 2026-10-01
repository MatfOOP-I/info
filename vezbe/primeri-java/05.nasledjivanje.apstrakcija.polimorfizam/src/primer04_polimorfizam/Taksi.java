package primer04_polimorfizam;

public class Taksi extends Prevoz {
    public Taksi() { super("Taksi"); }

    @Override
    public int izracunajCenu(int udaljenostKm) {
        return 300 + udaljenostKm * 95;
    }
}
