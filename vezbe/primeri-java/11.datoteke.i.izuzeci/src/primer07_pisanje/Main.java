package primer07_pisanje;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import primer06_odgovornost_za_gresku.UcitajRezervacije;
public class Main {
    public static void main(String[] args) {
        Path ulaz = Path.of("data", "rezervacije.txt");
        Path izlaz = Path.of("target", "rezervacije-izvestaj.txt");
        System.out.println("Radni direktorijum: " + Path.of("").toAbsolutePath());
        try {
            var rezervacije = UcitajRezervacije.ucitaj(ulaz.toString());
            Files.createDirectories(izlaz.getParent());
            Izvestaj.sacuvaj(izlaz, rezervacije);
            System.out.println("Sačuvano: " + izlaz.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Izveštaj nije sačuvan: " + e.getMessage());
        }
    }
}
