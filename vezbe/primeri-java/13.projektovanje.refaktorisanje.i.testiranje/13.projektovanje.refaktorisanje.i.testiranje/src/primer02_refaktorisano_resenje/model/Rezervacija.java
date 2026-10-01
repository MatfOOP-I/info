package primer02_refaktorisano_resenje.model;

import primer02_refaktorisano_resenje.obracun.NacinObracunaCene;
import primer02_refaktorisano_resenje.stanje.KreiranoStanje;
import primer02_refaktorisano_resenje.stanje.StanjeRezervacije;

/**
 * Rezervacija sastavlja više objekata:
 *
 * HAS-A Korisnik
 * HAS-A Vozilo
 * HAS-A NacinObracunaCene
 * HAS-A StanjeRezervacije
 */
public class Rezervacija {
    private final int broj;
    private final Korisnik korisnik;
    private final Vozilo vozilo;
    private final int brojDana;
    private final NacinObracunaCene nacinObracuna;

    private StanjeRezervacije stanje =
            new KreiranoStanje();

    public Rezervacija(
            int broj,
            Korisnik korisnik,
            Vozilo vozilo,
            int brojDana,
            NacinObracunaCene nacinObracuna
    ) {
        if (brojDana <= 0) {
            throw new IllegalArgumentException(
                    "Broj dana mora biti pozitivan."
            );
        }

        if (korisnik == null
                || vozilo == null
                || nacinObracuna == null) {
            throw new IllegalArgumentException(
                    "Podaci rezervacije nisu kompletni."
            );
        }

        this.broj = broj;
        this.korisnik = korisnik;
        this.vozilo = vozilo;
        this.brojDana = brojDana;
        this.nacinObracuna = nacinObracuna;
    }

    public int ukupnaCena() {
        return nacinObracuna.izracunaj(
                vozilo,
                brojDana
        );
    }

    public int depozit() {
        return vozilo.izracunajDepozit();
    }

    public void preuzmi() {
        stanje.preuzmi(this);
    }

    public void vrati() {
        stanje.vrati(this);
    }

    public void otkazi() {
        stanje.otkazi(this);
    }

    /**
     * Tranzicije pozivaju State objekti.
     *
     * Metoda je public zato što su State klase u drugom paketu.
     * U većem projektu granica paketa bi mogla drugačije da se organizuje.
     */
    public void promeniStanje(StanjeRezervacije novoStanje) {
        if (novoStanje == null) {
            throw new IllegalArgumentException(
                    "Stanje ne sme biti null."
            );
        }

        stanje = novoStanje;
    }

    public String trenutnoStanje() {
        return stanje.naziv();
    }

    public int getBroj() {
        return broj;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public String getNazivObracuna() {
        return nacinObracuna.naziv();
    }
}
