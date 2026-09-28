package primer04_mapa;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
         * Katalog povezuje jedinstvenu šifru sa pesmom.
         */
        Map<String, Pesma> katalog = new HashMap<>();

        katalog.put(
                "LP-NUMB",
                new Pesma("Numb", "Linkin Park")
        );

        katalog.put(
                "DB-TAKE5",
                new Pesma("Take Five", "Dave Brubeck")
        );

        Pesma pronadjena = katalog.get("LP-NUMB");

        if (pronadjena != null) {
            System.out.println(pronadjena.opis());
        }

        /*
         * Isti ključ ne pravi novi unos.
         * Nova vrednost zamenjuje prethodnu.
         */
        katalog.put(
                "LP-NUMB",
                new Pesma("Numb (Live)", "Linkin Park")
        );

        System.out.println("Broj unosa: " + katalog.size());
        System.out.println(katalog.get("LP-NUMB").opis());
    }
}
