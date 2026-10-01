package primer02_try_catch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("data/rezervacije_ispravne.txt")
                    );

            String red;

            while ((red = reader.readLine()) != null) {
                System.out.println(red);
            }

            reader.close();
        } catch (IOException e) {
            /*
             * Ovaj nivo programa zna kako želi da reaguje:
             * ispisujemo razumljivu poruku umesto stack trace-a.
             */
            System.out.println(
                    "Nije moguće pročitati datoteku: "
                            + e.getMessage()
            );
        }
    }
}
