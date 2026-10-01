package primer05_bez_grananja_po_tipu;

public class Autobus extends Prevoz {
    @Override public String naziv() { return "Autobus"; }
    @Override public int izracunajCenu(int km) { return 150 + km * 7; }
}
