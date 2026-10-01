package provere;
/** Regresione provere za održavanje materijala, ne novo obavezno gradivo. */
public class Main {
    private static int broj;
    private static void check(boolean uslov, String opis) {
        broj++;
        if (!uslov) throw new AssertionError(opis);
    }
    @FunctionalInterface private interface Akcija { void izvrsi() throws Exception; }
    private static void expect(Class<? extends Throwable> tip, Akcija akcija) throws Exception {
        broj++;
        try { akcija.izvrsi(); }
        catch (Throwable e) {
            if (tip.isInstance(e)) return;
            throw new AssertionError("Pogrešan tip izuzetka", e);
        }
        throw new AssertionError("Očekivan izuzetak: " + tip.getName());
    }
    public static void main(String[] args) throws Exception {
        var voz = new primer07_overload_override.vozila.Voz();
        primer07_overload_override.model.Prevoz p = voz;
        check(primer07_overload_override.Main.izaberi(p).equals("overload za Prevoz"), "Overload: deklarisani tip");
        check(p.opis().equals("Šinski prevoz: Voz"), "Override: stvarni objekat");
        check(p.toString().equals(p.opis()), "toString");
        System.out.println("NEDELJA 05: " + broj + " provera OK");
    }
}
