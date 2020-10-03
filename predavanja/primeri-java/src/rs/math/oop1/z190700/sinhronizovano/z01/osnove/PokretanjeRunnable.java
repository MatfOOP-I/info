package rs.math.oop1.z190700.sinhronizovano.z01.osnove;

import java.io.IOException;

public class PokretanjeRunnable {

    public static void main(String[] args) {

        Thread novak = new Thread( new ListanjeImePrezime("Novak", "Djokovic",
                (long)(200 + Math.random() * 800)));
        novak.setDaemon(true);
        Thread nikola =  new Thread( new ListanjeImePrezime("Nikola", "Jokic",
                (long)(200 + Math.random() * 800)));
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
