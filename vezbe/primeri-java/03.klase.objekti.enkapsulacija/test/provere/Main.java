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
        var n = new primer03_invarijante.Novcanik("Ana");
        check(n.uplati(1000), "Uplata");
        check(!n.plati(1001) && n.getStanje()==1000, "Neuspešna isplata ne menja stanje");
        check(!n.uplati(-1) && n.getStanje()==1000, "Negativna uplata");
        check(n.uplati(Integer.MAX_VALUE-1000), "Do gornje granice");
        check(!n.uplati(1) && n.getStanje()==Integer.MAX_VALUE, "Nema prekoračenja int");
        var drugi = new primer04_konstruktori_static_final.Novcanik("Marko");
        check(drugi.uplati(Integer.MAX_VALUE) && !drugi.uplati(1), "I naredna verzija čuva granicu");
        primer06_paketi.Main.main(new String[0]);
        System.out.println("NEDELJA 03: " + broj + " provera OK");
    }
}
