package primer03_vise_interfejsa;

public class Main {
    public static void main(String[] args) {
        DigitalniNovcanik novcanik = new DigitalniNovcanik(1000);

        // Isti objekat možemo posmatrati kroz dva različita ugovora.
        NacinPlacanja kaoPlacanje = novcanik;
        Dopunjiv kaoDopunjiv = novcanik;

        kaoDopunjiv.dopuni(500);
        System.out.println(kaoPlacanje.plati(1200));
        System.out.println("Preostalo: " + novcanik.getStanje());

        NacinPlacanja poklonKartica = new PoklonKartica(800);
        System.out.println(poklonKartica.plati(700));
    }
}
