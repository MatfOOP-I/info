package primer05_bez_grananja_po_tipu;

public class Voz extends Prevoz {
    @Override public String naziv() { return "Voz"; }
    @Override public int izracunajCenu(int km) { return 250 + km * 8; }
}
