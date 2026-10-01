package primer06_record_adresa;

public class Main {
    public static void main(String[] args) {
        Adresa adresa = new Adresa(
                "Bulevar kralja Aleksandra 73",
                "Beograd",
                "11000"
        );

        Kupac kupac = new Kupac("Ana", adresa);

        System.out.println(adresa.punaAdresa());

        /*
         * Accessor metoda record-a nema get prefiks.
         */
        System.out.println(adresa.grad());

        /*
         * Record automatski implementira semantičku jednakost
         * na osnovu svojih komponenti.
         */
        Adresa istaAdresa = new Adresa(
                "Bulevar kralja Aleksandra 73",
                "Beograd",
                "11000"
        );

        System.out.println(
                "Jednake adrese: " + adresa.equals(istaAdresa)
        );

        /*
         * Ne menjamo postojeću adresu.
         * Kreiramo novu vrednost i prosledimo je kupcu.
         */
        kupac.preseliSe(
                new Adresa(
                        "Glavna 10",
                        "Zemun",
                        "11080"
                )
        );

        System.out.println(
                "Nova adresa: "
                        + kupac.getAdresa().punaAdresa()
        );
    }
}
