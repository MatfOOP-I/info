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
        var gotovina = new primer01_prvi_interfejs.PlacanjeGotovinom(1000);
        check(!gotovina.plati(1001) && gotovina.getNovacKodKupca()==1000,"Neuspeh ne troši novac");
        check(!gotovina.plati(0),"Nulti iznos nije plaćanje");
        check(gotovina.plati(1000) && gotovina.getNovacKodKupca()==0,"Tačan iznos");
        var klub = new primer07_ugnjezdene_klase.Klub("Čitaonica");
        check(klub.new Sluzba().pozdrav().contains("Čitaonica"),"Inner koristi spoljni objekat");
        System.out.println("NEDELJA 06: " + broj + " provera OK");
    }
}
