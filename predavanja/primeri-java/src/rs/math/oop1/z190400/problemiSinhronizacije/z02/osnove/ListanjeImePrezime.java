package rs.math.oop1.z190400.problemiSinhronizacije.z02.osnove;

public class ListanjeImePrezime implements Runnable {

    private String ime;
    private String prezime;
    private long kasnjenje;
    private int i = 0;

    public ListanjeImePrezime(String ime, String prezime, long kasnjenje) {
        this.ime = ime;
        this.prezime = prezime;
        this.kasnjenje = kasnjenje;
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                System.out.print( "" + ++i + ". " + ime + " ");
                Thread.sleep(kasnjenje);
                System.out.print(prezime + System.lineSeparator());
                Thread.sleep(kasnjenje);
            }
        } catch (InterruptedException e) {
            System.out.println("" + i + "." + ime + prezime + e);
        }
    }
}

