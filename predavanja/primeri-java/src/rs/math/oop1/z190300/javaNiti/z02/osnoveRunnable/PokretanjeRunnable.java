package rs.math.oop1.z190300.javaNiti.z02.osnoveRunnable;

public class PokretanjeRunnable {

    public static void main(String[] args)
    {
        new Thread(new ProstaRunnable("NEMA")).start();
        new Thread(new ProstaRunnable("NIKAKVIH")).start();
        new Thread(new ProstaRunnable("PROBLEMA")).start();
    }
}
