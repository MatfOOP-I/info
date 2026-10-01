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
        final int[] pozivi = {0,0};
        var lik = new primer06_strategy.Lik("Ana", ime -> pozivi[0]++);
        lik.kreciSe();
        lik.postaviStrategijuKretanja(ime -> pozivi[1]++);
        lik.kreciSe();
        check(pozivi[0]==1 && pozivi[1]==1,"Isti lik delegira novoj strategiji");
        // Lambda se objašnjava u nedelji 10; ovaj fajl je nastavnikova provera.
        System.out.println("NEDELJA 07: " + broj + " provera OK");
    }
}
