package primer06_odgovornost_za_gresku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ovaj nivo odlučuje da greška jednog reda ne treba
 * da prekine učitavanje celog fajla.
 */
public class UcitajRezervacije {
    public static List<Rezervacija> ucitaj(String putanja)
            throws IOException {

        List<Rezervacija> rezultat = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(putanja, StandardCharsets.UTF_8)
                     )) {

            String red;
            int brojReda = 0;

            while ((red = reader.readLine()) != null) {
                brojReda++;

                try {
                    rezultat.add(
                            ParserRezervacije.parsiraj(red)
                    );
                } catch (NeispravanRedException e) {
                    System.out.println(
                            "Red " + brojReda
                                    + " je preskočen: "
                                    + e.getMessage()
                    );
                }
            }
        }

        /*
         * IOException ne hvatamo ovde.
         *
         * Ova metoda ne zna šta aplikacija treba da uradi
         * ako fajl uopšte nije dostupan.
         *
         * Zato ga prosleđuje pozivaocu.
         */
        return rezultat;
    }
}
