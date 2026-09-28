package primer06_rezervacija_prevoza;

public class Voz extends Prevoz {
    public Voz() { super("Voz"); }

    @Override
    public int izracunajCenu(int km) {
        return 250 + km * 8;
    }
}
