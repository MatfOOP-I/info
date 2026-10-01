package primer03_delegiranje;

/**
 * Porudžbina koordinira svoje stavke, ali ne preuzima njihove
 * pojedinačne odgovornosti.
 */
public class Porudzbina {
    private StavkaPorudzbine[] stavke;
    private int brojStavki;

    public Porudzbina(int maksimalanBrojStavki) {
        stavke = new StavkaPorudzbine[maksimalanBrojStavki];
    }

    public boolean dodajStavku(StavkaPorudzbine stavka) {
        if (stavka == null || brojStavki == stavke.length) {
            return false;
        }

        stavke[brojStavki++] = stavka;
        return true;
    }

    /**
     * Porudžbina ne računa cenu svake stavke tako što uzima njena polja.
     * Ona delegira taj posao objektu koji je za njega odgovoran.
     */
    public int izracunajUkupnuCenu() {
        int ukupno = 0;

        for (int i = 0; i < brojStavki; i++) {
            ukupno += stavke[i].izracunajCenu();
        }

        return ukupno;
    }

    public String opis() {
        String rezultat = "Stavke porudzbine:\n";

        for (int i = 0; i < brojStavki; i++) {
            rezultat += "- " + stavke[i].opis() + "\n";
        }

        rezultat += "Ukupno: " + izracunajUkupnuCenu() + " din";
        return rezultat;
    }
}
