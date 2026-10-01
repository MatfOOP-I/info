package primer01_javna_polja;

public class Main {
    public static void main(String[] args) {
        Novcanik novcanik = new Novcanik();

        novcanik.vlasnik = "Ana";
        novcanik.stanje = 2_000;

        System.out.println(novcanik.vlasnik + ": " + novcanik.stanje + " din");

        // Java ovo dozvoljava, ali u našem modelu nema smisla.
        // Klasa Novcanik trenutno uopšte ne štiti sopstveno stanje.
        novcanik.stanje = -1_000_000;

        System.out.println(novcanik.vlasnik + ": " + novcanik.stanje + " din");
    }
}
