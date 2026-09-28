package primer05_zavrsna_aplikacija.kontroler;

import java.util.List;

import primer05_zavrsna_aplikacija.model.ListaZadataka;
import primer05_zavrsna_aplikacija.model.Prioritet;
import primer05_zavrsna_aplikacija.model.Zadatak;

/**
 * Aplikacioni sloj između prikaza i modela.
 *
 * Kontroler ne importuje JavaFX.
 */
public class KontrolerZadataka {
    private final ListaZadataka model;

    public KontrolerZadataka(ListaZadataka model) {
        this.model = model;
    }

    public RezultatOperacije dodajZadatak(
            String opis,
            Prioritet prioritet
    ) {
        try {
            model.dodaj(opis, prioritet);
            return RezultatOperacije.uspeh("Zadatak je dodat.");
        } catch (IllegalArgumentException e) {
            return RezultatOperacije.greska(e.getMessage());
        }
    }

    public RezultatOperacije zavrsiZadatak(int indeks) {
        try {
            model.zavrsi(indeks);
            return RezultatOperacije.uspeh("Zadatak je završen.");
        } catch (IndexOutOfBoundsException e) {
            return RezultatOperacije.greska("Izaberi zadatak.");
        }
    }

    public RezultatOperacije ukloniZadatak(int indeks) {
        try {
            model.ukloni(indeks);
            return RezultatOperacije.uspeh("Zadatak je uklonjen.");
        } catch (IndexOutOfBoundsException e) {
            return RezultatOperacije.greska("Izaberi zadatak.");
        }
    }

    public List<Zadatak> getZadaci() {
        return model.getZadaci();
    }
}
