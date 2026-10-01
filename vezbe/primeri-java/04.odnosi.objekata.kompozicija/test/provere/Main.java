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
        var stara = new primer05_nepromenljiva_adresa.Adresa("Glavna",1,"Zemun");
        var kupac = new primer05_nepromenljiva_adresa.Kupac("Ana",stara);
        var porudzbina = new primer05_nepromenljiva_adresa.Porudzbina(stara);
        kupac.promeniAdresu(new primer05_nepromenljiva_adresa.Adresa("Nova",2,"Beograd"));
        check(porudzbina.opisAdreseZaDostavu().contains("Glavna"),"Porudžbina zadržava staru adresu");
        var a = new primer06_record_adresa.Adresa("A","B","1");
        check(a.equals(new primer06_record_adresa.Adresa("A","B","1")),"Record vrednosna jednakost");
        expect(IllegalArgumentException.class, () -> new primer06_record_adresa.Adresa("","B","1"));
        System.out.println("NEDELJA 04: " + broj + " provera OK");
    }
}
