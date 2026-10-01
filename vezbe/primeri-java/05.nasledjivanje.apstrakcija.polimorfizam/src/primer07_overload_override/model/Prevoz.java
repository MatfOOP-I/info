package primer07_overload_override.model;
public class Prevoz {
    private final String naziv;
    public Prevoz(String naziv) { this.naziv = naziv; }
    protected String oznaka() { return naziv; }
    public String opis() { return "Opšti prevoz: " + naziv; }
    @Override public String toString() { return opis(); }
}
