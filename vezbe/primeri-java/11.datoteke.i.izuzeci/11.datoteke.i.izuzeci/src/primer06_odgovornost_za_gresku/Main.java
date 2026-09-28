package primer06_odgovornost_za_gresku;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Rezervacija> rezervacije =
                    UcitajRezervacije.ucitaj(
                            "data/rezervacije.txt"
                    );

            System.out.println("--- uspešno učitane rezervacije ---");

            for (Rezervacija rezervacija : rezervacije) {
                System.out.println(rezervacija.opis());
            }

        } catch (IOException e) {
            /*
             * Main zna šta želi da uradi ako ceo ulazni fajl
             * nije dostupan: obaveštava korisnika.
             */
            System.out.println(
                    "Nije moguće učitati rezervacije: "
                            + e.getMessage()
            );
        }
    }
}
