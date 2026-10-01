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
        primer00_karakterizacija.Main.main(new String[0]);
        primer03_testiranje.Main.main(new String[0]);
        var s = new primer02_refaktorisano_resenje.servis.SistemIznajmljivanja();
        var v = new primer02_refaktorisano_resenje.model.Automobil("A","Auto",5000);
        var k = new primer02_refaktorisano_resenje.model.Korisnik("K","Ana");
        var obracun = new primer02_refaktorisano_resenje.obracun.StandardniObracun();
        s.dodajVozilo(v);
        expect(primer02_refaktorisano_resenje.servis.RezervacijaException.class, () -> s.napraviRezervaciju(k,"A",0,obracun));
        check(v.isDostupno() && s.getRezervacije().isEmpty(),"Neispravan zahtev ne zauzima vozilo");
        var r = s.napraviRezervaciju(k,"A",1,obracun);
        check(r.getBroj()==1,"Neuspešan zahtev ne troši broj rezervacije");
        expect(IllegalArgumentException.class, () -> s.dodajVozilo(new primer02_refaktorisano_resenje.model.Automobil("A","Drugi",5000)));
        expect(primer02_refaktorisano_resenje.servis.RezervacijaException.class, () -> s.napraviRezervaciju(k,"A",1,obracun));
        expect(IllegalStateException.class, () -> new primer02_refaktorisano_resenje.model.Rezervacija(99,k,v,1,obracun));
        r.otkazi();
        expect(primer02_refaktorisano_resenje.stanje.NedozvoljenaOperacijaException.class, r::preuzmi);
        check(v.isDostupno(),"Otkazivanje oslobađa vozilo");
        var druga = s.napraviRezervaciju(k,"A",2,obracun);
        druga.preuzmi();
        expect(primer02_refaktorisano_resenje.stanje.NedozvoljenaOperacijaException.class, druga::otkazi);
        check(!v.isDostupno(),"Odbijeno otkazivanje ne oslobađa vozilo");
        druga.vrati();
        expect(primer02_refaktorisano_resenje.stanje.NedozvoljenaOperacijaException.class, druga::vrati);
        check(s.getRezervacije().size()==2 && v.isDostupno(),"Konzistentnost kolekcije i dostupnosti");
        for (var m : r.getClass().getMethods()) {
            check(!m.getName().equals("promeniStanje"),"Nema javnog settera stanja");
        }
        for (var m : v.getClass().getMethods()) {
            check(!m.getName().equals("oslobodi") && !m.getName().equals("rezervisi"),"Nema javne promene dostupnosti");
        }
        System.out.println("NEDELJA 13: " + broj + " provera OK");
    }
}
