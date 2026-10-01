package primer00_karakterizacija;
/** Pokrenuti PRE refaktorisanja. Ova očekivanja ostaju ista i POSLE njega. */
public class Main {
    private static void ocekuj(Object ocekivano, Object stvarno) {
        if (!ocekivano.equals(stvarno)) throw new AssertionError(ocekivano + " != " + stvarno);
    }
    public static void main(String[] args) throws Exception {
        var stari = new primer01_pocetni_kod.SistemIznajmljivanja();
        var staroVozilo = new primer01_pocetni_kod.Vozilo("A", "AUTOMOBIL", "Auto", 5000);
        stari.dodajVozilo(staroVozilo);
        var stara = stari.napraviRezervaciju(new primer01_pocetni_kod.Korisnik("K", "Ana"), "A", 2, "CLANSKI");
        ocekuj(9000, stara.getUkupnaCena());
        ocekuj("KREIRANA", stara.getStatus());
        stari.preuzmi(stara.getBroj());
        ocekuj("AKTIVNA", stara.getStatus());
        stari.vrati(stara.getBroj());
        ocekuj("ZAVRSENA", stara.getStatus());
        ocekuj(true, staroVozilo.isDostupno());

        var novi = new primer02_refaktorisano_resenje.servis.SistemIznajmljivanja();
        var novoVozilo = new primer02_refaktorisano_resenje.model.Automobil("A", "Auto", 5000);
        novi.dodajVozilo(novoVozilo);
        var nova = novi.napraviRezervaciju(new primer02_refaktorisano_resenje.model.Korisnik("K", "Ana"), "A", 2,
                new primer02_refaktorisano_resenje.obracun.ClanskiObracun());
        ocekuj(9000, nova.ukupnaCena());
        ocekuj("KREIRANA", nova.trenutnoStanje());
        nova.preuzmi();
        ocekuj("AKTIVNA", nova.trenutnoStanje());
        nova.vrati();
        ocekuj("ZAVRSENA", nova.trenutnoStanje());
        ocekuj(true, novoVozilo.isDostupno());
        System.out.println("Karakterizacija: 10/10 provera; osnovni ugovor je sačuvan.");
        // Namerno popravljene greške (duplikati, neispravne tranzicije) imaju zasebne testove.
    }
}
