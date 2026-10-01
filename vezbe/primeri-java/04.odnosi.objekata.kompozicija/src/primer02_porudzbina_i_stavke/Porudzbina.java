package primer02_porudzbina_i_stavke;

/**
 * Porudžbina koja povezuje više objekata u jedan mali objektni graf.
 *
 * <p>Kolekcije još nismo radili, pa koristimo običan niz fiksnog
 * kapaciteta. To je tehnički detalj; glavna tema je da porudžbina
 * sadrži reference na druge objekte.</p>
 */
public class Porudzbina {
    private Kupac kupac;
    private StavkaPorudzbine[] stavke;
    private int brojStavki;

    public Porudzbina(Kupac kupac, int maksimalanBrojStavki) {
        this.kupac = kupac;
        this.stavke = new StavkaPorudzbine[maksimalanBrojStavki];
        this.brojStavki = 0;
    }

    public boolean dodajStavku(StavkaPorudzbine stavka) {
        if (stavka == null || brojStavki == stavke.length) {
            return false;
        }

        stavke[brojStavki] = stavka;
        brojStavki++;
        return true;
    }

    public String opis() {
        String rezultat = "Porudzbina za " + kupac.getIme() + "\n";
        rezultat += "Adresa: " + kupac.getAdresa().opis() + "\n";

        for (int i = 0; i < brojStavki; i++) {
            StavkaPorudzbine stavka = stavke[i];
            rezultat += "- " + stavka.getProizvod().getNaziv()
                    + " x " + stavka.getKolicina() + "\n";
        }

        return rezultat;
    }
}
