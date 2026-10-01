package primer03_genericka_metoda;

public class Main {
    public static void main(String[] args) {
        Paket<String> prvi =
                new Paket<>("slušalice");

        Paket<String> drugi =
                new Paket<>("punjač");

        RadSaPaketima.prebaci(prvi, drugi);

        System.out.println(drugi.getSadrzaj());

        Paket<Integer> broj1 = new Paket<>(10);
        Paket<Integer> broj2 = new Paket<>(20);

        /*
         * Ista metoda radi i za Integer.
         * T se zaključuje iz argumenata.
         */
        RadSaPaketima.prebaci(broj1, broj2);

        System.out.println(broj2.getSadrzaj());
    }
}
