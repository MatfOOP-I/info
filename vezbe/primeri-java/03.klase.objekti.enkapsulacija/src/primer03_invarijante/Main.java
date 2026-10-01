package primer03_invarijante;

public class Main {
    public static void main(String[] args) {
        Novcanik novcanik = new Novcanik("Ana");

        novcanik.uplati(2_000);
        System.out.println(novcanik.opis());

        if (novcanik.plati(750)) {
            System.out.println("Plaćanje je uspešno.");
        }

        System.out.println(novcanik.opis());

        if (!novcanik.plati(5_000)) {
            System.out.println("Nema dovoljno sredstava.");
        }

        // I posle neuspelog pokušaja objekat ostaje u ispravnom stanju.
        System.out.println(novcanik.opis());
    }
}
