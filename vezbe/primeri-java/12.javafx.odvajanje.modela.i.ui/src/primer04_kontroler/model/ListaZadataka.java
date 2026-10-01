package primer04_kontroler.model;

import java.util.ArrayList;
import java.util.List;

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
        return List.copyOf(zadaci);
    }

    private void proveriIndeks(int indeks) {
        if (indeks < 0 || indeks >= zadaci.size()) {
            throw new IndexOutOfBoundsException(
                    "Neispravan indeks zadatka."
            );
        }
    }
}
