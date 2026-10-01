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
        // Javni glavni primeri bez korisničkog unosa.
        primeri.Primer01.main(new String[0]);
        primeri.Primer02.main(new String[0]);
        primeri.Primer03.main(new String[0]);
        check(true, "Osnovni programi završavaju bez izuzetka");
        System.out.println("NEDELJA 01: " + broj + " provera OK");
    }
}
