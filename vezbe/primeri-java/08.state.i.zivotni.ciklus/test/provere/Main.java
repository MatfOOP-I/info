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
        var p = new primer06_tranzicije.Porudzbina(1);
        p.posalji();
        check(p.trenutnoStanje().equals("NOVA"),"Nedozvoljen prelaz ne menja stanje");
        p.plati(); p.posalji(); p.isporuci(); p.otkazi();
        check(p.trenutnoStanje().equals("ISPORUCENA") && p.getBroj()==1,"Terminalno stanje i identitet");
        var otkazana = new primer06_tranzicije.Porudzbina(2);
        otkazana.otkazi(); otkazana.plati();
        check(otkazana.trenutnoStanje().equals("OTKAZANA"),"Nema povratka iz otkazanog stanja");
        System.out.println("NEDELJA 08: " + broj + " provera OK");
    }
}
