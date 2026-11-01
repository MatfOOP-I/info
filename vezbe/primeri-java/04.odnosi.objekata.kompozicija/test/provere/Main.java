package provere;

public class Main {
    private static int broj;

    private static void check(boolean uslov, String opis) {
        broj++;
        if (!uslov) {
            System.err.println("GREŠKA: " + opis);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        var stara = new primer05_nepromenljiva_adresa.Adresa("Glavna", 1, "Zemun");
        var kupac = new primer05_nepromenljiva_adresa.Kupac("Ana", stara);
        var porudzbina = new primer05_nepromenljiva_adresa.Porudzbina(stara);

        kupac.promeniAdresu(
            new primer05_nepromenljiva_adresa.Adresa("Nova", 2, "Beograd")
        );

        check(
            porudzbina.opisAdreseZaDostavu().contains("Glavna"),
            "Porudžbina zadržava staru adresu"
        );

        var a = new primer06_record_adresa.Adresa("A", "B", "1");

        check(
            a.equals(new primer06_record_adresa.Adresa("A", "B", "1")),
            "Record vrednosna jednakost"
        );

        System.out.println("NEDELJA 04: " + broj + " provera OK");
    }
}