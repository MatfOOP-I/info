package primer04_konstruktori_static_final;

public class Main {
    public static void main(String[] args) {
        Novcanik aninNovcanik = new Novcanik("Ana");
        Novcanik markovNovcanik = new Novcanik("Marko");

        aninNovcanik.uplati(3_000);
        markovNovcanik.uplati(1_500);

        System.out.println(aninNovcanik.opis());
        System.out.println(markovNovcanik.opis());

        // static metod pozivamo preko klase, jer podatak pripada klasi,
        // a ne konkretnom novčaniku.
        System.out.println(
                "Kreirano novčanika: " + Novcanik.getBrojKreiranihNovcanika()
        );
    }
}
