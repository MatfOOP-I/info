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
        var model = new primer05_zavrsna_aplikacija.model.ListaZadataka();
        var c = new primer05_zavrsna_aplikacija.kontroler.KontrolerZadataka(model);
        var prioritet = primer05_zavrsna_aplikacija.model.Prioritet.VISOK;
        check(!c.dodajZadatak("x",prioritet).isUspesno() && c.getZadaci().isEmpty(),"Neispravan unos");
        check(c.dodajZadatak("Kupiti kartu",prioritet).isUspesno(),"Dodavanje");
        check(!c.zavrsiZadatak(-1).isUspesno(),"Nema selekcije");
        check(c.zavrsiZadatak(0).isUspesno() && c.getZadaci().get(0).isZavrsen(),"Završavanje");
        expect(UnsupportedOperationException.class, () -> c.getZadaci().clear());
        check(c.ukloniZadatak(0).isUspesno() && c.getZadaci().isEmpty(),"Uklanjanje");
        System.out.println("NEDELJA 12: " + broj + " provera OK");
    }
}
