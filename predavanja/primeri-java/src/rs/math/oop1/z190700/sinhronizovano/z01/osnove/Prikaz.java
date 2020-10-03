package rs.math.oop1.z190700.sinhronizovano.z01.osnove;

public class Prikaz {


    public static synchronized void prikaziSaKasnjenjem(Osoba osoba, long kasnjenje, int i) throws InterruptedException {
        System.out.print("" + ++i + ". " + osoba.vratiIme() + " ");
        Thread.sleep(kasnjenje);
        System.out.print(osoba.vratiPrezime() + System.lineSeparator());
    }

}
