package primer05_apstraktna_klasa_i_interfejs;

public class Main {
    public static void main(String[] args) {
        DebitnaKartica kartica =
                new DebitnaKartica("Ana", "1234", 5000);

        System.out.println(kartica.opis());

        // Ostatak programa može da je koristi kroz interfejs.
        NacinPlacanja placanjeKarticom = kartica;
        NacinPlacanja placanjeNovcanikom =
                new DigitalniNovcanik(3000);

        System.out.println(placanjeKarticom.plati(1200));
        System.out.println(placanjeNovcanikom.plati(1200));
    }
}
