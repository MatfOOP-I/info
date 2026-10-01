package primer01_citanje_fajla;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * Za prvi primer samo pokazujemo osnovni tok:
         *
         * otvori -> čitaj -> zatvori.
         *
         * Obradu grešaka uvodimo u sledećem primeru.
         */
        BufferedReader reader =
                new BufferedReader(
                        new FileReader("data/rezervacije_ispravne.txt")
                );

        String red;

        while ((red = reader.readLine()) != null) {
            System.out.println(red);
        }

        reader.close();
    }
}
