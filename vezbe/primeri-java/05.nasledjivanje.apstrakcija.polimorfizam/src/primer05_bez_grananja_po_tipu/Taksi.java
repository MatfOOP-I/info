package primer05_bez_grananja_po_tipu;

public class Taksi extends Prevoz {
    @Override public String naziv() { return "Taksi"; }
    @Override public int izracunajCenu(int km) { return 300 + km * 95; }
}
