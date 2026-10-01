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
        String[] losi = {",Jovanovic,22,Rim", "Ana,,22,Rim", "Ana,Jovanovic,22,", "Ana,Jovanovic,22,Rim,", "Ana,Jovanovic,abc,Rim", "Ana,Jovanovic,-1,Rim"};
        for (String red : losi) {
            expect(primer06_odgovornost_za_gresku.NeispravanRedException.class,
                    () -> primer06_odgovornost_za_gresku.ParserRezervacije.parsiraj(red));
            expect(primer04_sopstveni_izuzetak.NeispravanRedException.class,
                    () -> primer04_sopstveni_izuzetak.ParserRezervacije.parsiraj(red));
        }
        var dir = java.nio.file.Files.createTempDirectory("oop-provera-");
        var ulaz = dir.resolve("ulaz.txt"); var izlaz = dir.resolve("izlaz.txt");
        try {
            java.nio.file.Files.writeString(ulaz,"Ana,Jovanović,22,Rim\n,Jovanovic,22,Rim\n");
            var podaci = primer06_odgovornost_za_gresku.UcitajRezervacije.ucitaj(ulaz.toString());
            check(podaci.size()==1,"Neispravan red se preskače");
            primer07_pisanje.Izvestaj.sacuvaj(izlaz,podaci);
            check(java.nio.file.Files.readString(izlaz).contains("Jovanović"),"UTF-8 upis");
            expect(java.io.IOException.class, () -> primer06_odgovornost_za_gresku.UcitajRezervacije.ucitaj(dir.resolve("ne-postoji").toString()));
        } finally {
            java.nio.file.Files.deleteIfExists(ulaz); java.nio.file.Files.deleteIfExists(izlaz); java.nio.file.Files.deleteIfExists(dir);
        }
        expect(IllegalArgumentException.class, () -> primer08_assert.Main.preostalo(3,4));
        System.out.println("NEDELJA 11: " + broj + " provera OK");
    }
}
