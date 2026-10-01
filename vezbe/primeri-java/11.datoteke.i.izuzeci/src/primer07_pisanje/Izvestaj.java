package primer07_pisanje;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import primer06_odgovornost_za_gresku.Rezervacija;
public final class Izvestaj {
    /** Piše čitljiv izveštaj; nije CSV za ponovno učitavanje. Prepisuje cilj. */
    public static void sacuvaj(Path cilj, List<Rezervacija> rezervacije) throws IOException {
        try (BufferedWriter pisac = Files.newBufferedWriter(cilj, StandardCharsets.UTF_8)) {
            for (Rezervacija r : rezervacije) {
                pisac.write(r.opis());
                pisac.newLine();
            }
        }
    }
}
