package primer02_refaktorisano_resenje.model;

import primer02_refaktorisano_resenje.obracun.NacinObracunaCene;
import primer02_refaktorisano_resenje.stanje.NedozvoljenaOperacijaException;

/** Rezervacija kontroliše svoj životni ciklus i zauzeće vozila. */
public final class Rezervacija {
    private final int broj;
    private final Korisnik korisnik;
    private final Vozilo vozilo;
    private final int brojDana;
    private final NacinObracunaCene nacinObracuna;
    private StanjeRezervacije stanje = new KreiranoStanje();

    public Rezervacija(int broj, Korisnik korisnik, Vozilo vozilo,
                       int brojDana, NacinObracunaCene nacinObracuna) {
        if (broj <= 0 || brojDana <= 0) {
            throw new IllegalArgumentException("Broj rezervacije i broj dana moraju biti pozitivni.");
        }
        if (korisnik == null || vozilo == null || nacinObracuna == null) {
            throw new IllegalArgumentException("Podaci rezervacije nisu kompletni.");
        }
        this.broj = broj;
        this.korisnik = korisnik;
        this.vozilo = vozilo;
        this.brojDana = brojDana;
        this.nacinObracuna = nacinObracuna;
        // Tek posle svih provera menjamo stanje saradnika.
        // I direktno kreiranje rezervacije mora poštovati zauzetost vozila.
        vozilo.rezervisi();
    }

    public int ukupnaCena() { return nacinObracuna.izracunaj(vozilo, brojDana); }
    public int depozit() { return vozilo.izracunajDepozit(); }
    public void preuzmi() { stanje.preuzmi(this); }
    public void vrati() { stanje.vrati(this); }
    public void otkazi() { stanje.otkazi(this); }
    public String trenutnoStanje() { return stanje.naziv(); }
    public int getBroj() { return broj; }
    public Korisnik getKorisnik() { return korisnik; }
    public Vozilo getVozilo() { return vozilo; }
    public int getBrojDana() { return brojDana; }
    public String getNazivObracuna() { return nacinObracuna.naziv(); }

    // Nijedan pozivalac ne dobija setter za stanje ili sam State objekat.
    private interface StanjeRezervacije {
        void preuzmi(Rezervacija r);
        void vrati(Rezervacija r);
        void otkazi(Rezervacija r);
        String naziv();
    }

    private static final class KreiranoStanje implements StanjeRezervacije {
        public void preuzmi(Rezervacija r) { r.stanje = new AktivnoStanje(); }
        public void vrati(Rezervacija r) { throw greska("Vozilo još nije preuzeto."); }
        public void otkazi(Rezervacija r) {
            r.vozilo.oslobodi();
            r.stanje = new OtkazanoStanje();
        }
        public String naziv() { return "KREIRANA"; }
    }

    private static final class AktivnoStanje implements StanjeRezervacije {
        public void preuzmi(Rezervacija r) { throw greska("Vozilo je već preuzeto."); }
        public void vrati(Rezervacija r) {
            r.vozilo.oslobodi();
            r.stanje = new ZavrsenoStanje();
        }
        public void otkazi(Rezervacija r) { throw greska("Aktivna rezervacija ne može da se otkaže."); }
        public String naziv() { return "AKTIVNA"; }
    }

    private static final class ZavrsenoStanje implements StanjeRezervacije {
        public void preuzmi(Rezervacija r) { throw greska("Rezervacija je završena."); }
        public void vrati(Rezervacija r) { throw greska("Rezervacija je završena."); }
        public void otkazi(Rezervacija r) { throw greska("Rezervacija je završena."); }
        public String naziv() { return "ZAVRSENA"; }
    }

    private static final class OtkazanoStanje implements StanjeRezervacije {
        public void preuzmi(Rezervacija r) { throw greska("Rezervacija je otkazana."); }
        public void vrati(Rezervacija r) { throw greska("Rezervacija je otkazana."); }
        public void otkazi(Rezervacija r) { throw greska("Rezervacija je otkazana."); }
        public String naziv() { return "OTKAZANA"; }
    }

    private static NedozvoljenaOperacijaException greska(String poruka) {
        return new NedozvoljenaOperacijaException(poruka);
    }
}
