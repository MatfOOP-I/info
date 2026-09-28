package primer06_rezervacija_prevoza;

public class Autobus extends Prevoz {
    public Autobus() { super("Autobus"); }

    @Override
    public int izracunajCenu(int km) {
        return 150 + km * 7;
    }
}
