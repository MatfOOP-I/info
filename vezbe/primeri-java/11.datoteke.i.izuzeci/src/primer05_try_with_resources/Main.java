package primer05_try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /*
         * reader implementira AutoCloseable.
         *
         * Zato Java garantuje zatvaranje resursa po izlasku
         * iz try bloka, čak i ako se desi izuzetak.
         */
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("data/rezervacije_ispravne.txt", StandardCharsets.UTF_8)
                     )) {

            String red;

            while ((red = reader.readLine()) != null) {
                System.out.println(red);
            }

        } catch (IOException e) {
            System.out.println(
                    "Greška pri čitanju: " + e.getMessage()
            );
        }
    }
}
