package primer03_model_bez_javafx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model kolekcije zadataka.
 *
 * Interna lista je sakrivena od korisnika klase.
 */
public class ListaZadataka {
    private final List<Zadatak> zadaci = new ArrayList<>();

    public void dodaj(String opis, Prioritet prioritet) {
        zadaci.add(new Zadatak(opis, prioritet));
    }

    public void zavrsi(int indeks) {
        proveriIndeks(indeks);
        zadaci.get(indeks).zavrsi();
    }

    public void ukloni(int indeks) {
        proveriIndeks(indeks);
        zadaci.remove(indeks);
    }

    public List<Zadatak> getZadaci() {
        /*
         * Ne vraćamo internu promenljivu listu.
         * Pozivalac dobija nepromenljiv pogled/kopiju sadržaja.
         */
        return List.copyOf(zadaci);
    }

    private void proveriIndeks(int indeks) {
        if (indeks < 0 || indeks >= zadaci.size()) {
            throw new IndexOutOfBoundsException(
                    "Ne postoji zadatak sa indeksom " + indeks
            );
        }
    }
}
