package rs.math.oop1.z190500.katanci.z02.osnove;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Prikaz {

    private static Lock katanacPrikaz = new ReentrantLock();

    public static void prikaziSaKasnjenjem( Osoba osoba, long kasnjenje, int i) throws InterruptedException {
        katanacPrikaz.lock();
        try {
            System.out.print("" + ++i + ". " + osoba.vratiIme() + " ");
            Thread.sleep(kasnjenje);
            System.out.print(osoba.vratiPrezime() + System.lineSeparator());
        } finally {
            katanacPrikaz.unlock();
        }

    }

}
