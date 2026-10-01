package primer08_assert;
public class Main {
    public static int preostalo(int kapacitet, int zauzeto) {
        // Javni ulaz proveravamo bez obzira na to da li su tvrdnje uključene.
        if (kapacitet < 0 || zauzeto < 0 || zauzeto > kapacitet) {
            throw new IllegalArgumentException("Neispravan kapacitet ili zauzetost.");
        }
        int rezultat = kapacitet - zauzeto;
        assert rezultat >= 0 : "Interna pretpostavka algoritma";
        return rezultat;
    }
    public static void main(String[] args) {
        System.out.println("Tvrdnje uključene: " + Main.class.desiredAssertionStatus());
        System.out.println(preostalo(10, 3)); // 7
        // Pokrenuti sa java -ea ...; bez -ea assert se tipično ne izvršava.
        // Provera iz nedelje 13 baca AssertionError eksplicitno, i ne zavisi od -ea.
    }
}
