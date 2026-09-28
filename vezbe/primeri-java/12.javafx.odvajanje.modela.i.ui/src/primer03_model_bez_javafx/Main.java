package primer03_model_bez_javafx;

import primer03_model_bez_javafx.model.ListaZadataka;
import primer03_model_bez_javafx.model.Prioritet;
import primer03_model_bez_javafx.model.Zadatak;

/**
 * Dokaz da model radi bez JavaFX-a.
 */
public class Main {
    public static void main(String[] args) {
        ListaZadataka lista = new ListaZadataka();

        lista.dodaj("Kupiti kartu", Prioritet.VISOK);
        lista.dodaj("Pozvati servis", Prioritet.SREDNJI);

        lista.zavrsi(0);

        for (Zadatak zadatak : lista.getZadaci()) {
            System.out.println(
                    zadatak.getOpis()
                            + " | "
                            + zadatak.getPrioritet()
                            + " | završen: "
                            + zadatak.isZavrsen()
            );
        }
    }
}
