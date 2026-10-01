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
