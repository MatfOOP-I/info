package primer05_ogranicenje_tipa;

public class Main {
    public static void main(String[] args) {
        OsiguraniPaket<Telefon> telefon =
                new OsiguraniPaket<>(
                        new Telefon("Pixel", 90000)
                );

        OsiguraniPaket<Sat> sat =
                new OsiguraniPaket<>(
                        new Sat("Ručni sat", 30000)
                );

        System.out.println(
                "Osiguranje telefona: " + telefon.cenaOsiguranja()
        );
        System.out.println(
                "Osiguranje sata: " + sat.cenaOsiguranja()
        );

        /*
         * OsiguraniPaket<String> se ne bi kompajlirao,
         * jer String ne implementira Procenjiv.
         */
    }
}
