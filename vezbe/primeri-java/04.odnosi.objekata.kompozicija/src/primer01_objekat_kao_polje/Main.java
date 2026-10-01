package primer01_objekat_kao_polje;

public class Main {
    public static void main(String[] args) {
        Adresa adresa = new Adresa("Knez Mihailova", 12, "Beograd");
        Kupac kupac = new Kupac("Mila", "Petrovic", adresa);

        System.out.println(kupac.opis());

        // Veza između objekata može se pročitati kao:
        // Kupac HAS-A Adresa.
        // Kupac nije posebna vrsta adrese.
    }
}
