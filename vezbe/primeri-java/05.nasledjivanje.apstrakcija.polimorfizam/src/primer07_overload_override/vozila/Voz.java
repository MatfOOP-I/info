package primer07_overload_override.vozila;
import primer07_overload_override.model.Prevoz;
public final class Voz extends Prevoz {
    public Voz() { super("Voz"); }
    @Override public String opis() { return "Šinski prevoz: " + oznaka(); }
    // protected omogućava podklasi pristup oznaka(), i u drugom paketu.
    // Privatnom polju naziv ne pristupamo direktno.
}
