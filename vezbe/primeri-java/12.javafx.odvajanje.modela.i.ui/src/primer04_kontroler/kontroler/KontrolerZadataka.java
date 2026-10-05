package primer04_kontroler.kontroler;

import java.util.List;

import primer04_kontroler.model.ListaZadataka;
import primer04_kontroler.model.Prioritet;
import primer04_kontroler.model.Zadatak;

/**
 * Kontroler predstavlja operacije koje korisnik može da zatraži.
 *
 * Ne zna da li zahtev dolazi iz JavaFX-a, konzole ili testa.
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
        /*
         * Negativan indeks znači "ništa nije izabrano" - to je očekivana
         * situacija u UI-ju, pa je obrađujemo eksplicitno. Ostali neispravni
         * indeksi su greška pozivaoca: model baca izuzetak, a mi ga ne hvatamo.
         */
        if (indeks < 0) {
            return RezultatOperacije.greska("Izaberi zadatak.");
        }

        model.zavrsi(indeks);
        return RezultatOperacije.uspeh("Zadatak je završen.");
    }

    public RezultatOperacije ukloniZadatak(int indeks) {
        // Isto kao kod zavrsiZadatak: samo "ništa nije izabrano" je očekivano.
        if (indeks < 0) {
            return RezultatOperacije.greska("Izaberi zadatak.");
        }

        model.ukloni(indeks);
        return RezultatOperacije.uspeh("Zadatak je uklonjen.");
    }

    public List<Zadatak> getZadaci() {
        return model.getZadaci();
    }
}
