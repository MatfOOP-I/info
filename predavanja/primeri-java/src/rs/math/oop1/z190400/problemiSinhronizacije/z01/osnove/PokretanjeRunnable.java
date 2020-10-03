package rs.math.oop1.z190400.problemiSinhronizacije.z01.osnove;

import java.io.IOException;

public class PokretanjeRunnable {

    public static void main(String[] args) {

        Thread novak = new Thread(
                () -> {
                    String ime = "Novak";
                    String prezime = "Djokovic";
                    long kasnjenje = (long) (200 + Math.random() * 800);
                    try {
                        for (; ; ) {
                            System.out.print(ime + " ");
                            Thread.sleep(kasnjenje);
                            System.out.print(prezime + System.lineSeparator());
                            Thread.sleep(kasnjenje);
                        }
                    } catch (InterruptedException e) {
                        System.out.println(ime + prezime + e); // Output the exception
                    }
                });
        novak.setDaemon(true);
        Thread nikola = new Thread(
                () -> {
                    String ime = "Nikola";
                    String prezime = "Jokic";
                    long kasnjenje = (long) (200 + Math.random() * 800);
                    try {
                        for (; ; ) {
                            System.out.print(ime + " ");
                            Thread.sleep(kasnjenje);
                            System.out.print(prezime + System.lineSeparator());
                            Thread.sleep(kasnjenje);
                        }
                    } catch (InterruptedException e) {
                        System.out.println(ime + prezime + e); // Output the exception
                    }
                });
        nikola.setDaemon((true));

        System.out.println("Kada ti se dosadi, pritisni Enter za kraj");
        novak.start();
        nikola.start();
        try
        {
            System.in.read();
            System.out.println("Enter je pritisnut.\n");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        System.out.println("Zavrsetak prikazivanja");
    }
}
