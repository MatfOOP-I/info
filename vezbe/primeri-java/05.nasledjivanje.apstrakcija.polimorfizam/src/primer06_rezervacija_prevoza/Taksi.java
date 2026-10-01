package primer06_rezervacija_prevoza;

public class Taksi extends Prevoz {
    public Taksi() { super("Taksi"); }

    @Override
    public int izracunajCenu(int km) {
        return 300 + km * 95;
    }
}
