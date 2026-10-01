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
        var s = new primer04_genericki_interfejs.JednomesnoSkladiste<String>();
        check(s.jePrazno() && s.preuzmi()==null,"Prazno skladište");
        expect(IllegalArgumentException.class, () -> s.smesti(null));
        s.smesti("jakna");
        expect(IllegalStateException.class, () -> s.smesti("torba"));
        check(s.preuzmi().equals("jakna") && s.jePrazno(),"Odbijeno prepisivanje i preuzimanje");
        System.out.println("NEDELJA 09: " + broj + " provera OK");
    }
}
