package primer03_parsiranje_i_vise_gresaka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static Rezervacija parsiraj(String red) {
        String[] delovi = red.split(",");

        if (delovi.length != 4) {
            throw new IllegalArgumentException(
                    "Red mora imati tačno 4 polja."
            );
        }

        int godine = Integer.parseInt(delovi[2]);

        return new Rezervacija(
                delovi[0],
                delovi[1],
                godine,
                delovi[3]
        );
    }

    public static void main(String[] args) {
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("data/rezervacije.txt")
                     )) {

            String red;

            while ((red = reader.readLine()) != null) {
                try {
                    Rezervacija rezervacija = parsiraj(red);
                    System.out.println(rezervacija.opis());
                } catch (NumberFormatException e) {
                    System.out.println(
                            "Godine nisu ispravan broj: " + red
                    );
                } catch (IllegalArgumentException e) {
                    System.out.println(
                            "Neispravan format reda: " + red
                    );
                }
            }
        } catch (IOException e) {
            System.out.println(
                    "Greška pri radu sa datotekom: " + e.getMessage()
            );
        }
    }
}
