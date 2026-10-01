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
        check(d_stringovi.Primer10Palindrom.palindrom("Ana\t voli Milovana"), "Palindrom zanemaruje beline i veličinu slova");
        check(!d_stringovi.Primer10Palindrom.palindrom("java"), "Nepalindrom");
        c_klasaArrays.Primer01_SortBSearch.main(new String[0]);
        System.out.println("NEDELJA 02: " + broj + " provera OK");
    }
}
