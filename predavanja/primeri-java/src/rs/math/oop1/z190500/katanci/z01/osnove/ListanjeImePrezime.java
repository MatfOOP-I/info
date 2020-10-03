package rs.math.oop1.z190500.katanci.z01.osnove;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ListanjeImePrezime implements Runnable {

    private Osoba osoba;
    private long kasnjenje;
    private int i = 0;

    private static Lock katanacPrikaz = new ReentrantLock();

    public ListanjeImePrezime(String ime, String prezime, long kasnjenje) {
        this.osoba = new Osoba(ime, prezime);
        this.kasnjenje = kasnjenje;
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                katanacPrikaz.lock();
                try {
                    System.out.print("" + ++i + ". " + osoba.vratiIme() + " ");
                    Thread.sleep(kasnjenje);
                    System.out.print(osoba.vratiPrezime() + System.lineSeparator());
                } finally {
                    katanacPrikaz.unlock();
                }
                Thread.sleep(kasnjenje);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

