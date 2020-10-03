package rs.math.oop1.z190400.problemiSinhronizacije.z03.osnove;

public class ListanjeImePrezime implements Runnable {

    private Osoba osoba;
    private long kasnjenje;
    private int i=0;

    public ListanjeImePrezime(String ime, String prezime, long kasnjenje) {
        this.osoba = new Osoba(ime, prezime);
        this.kasnjenje = kasnjenje;
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                System.out.print( "" + ++i + ". " + osoba.vratiIme() + " ");
                Thread.sleep(kasnjenje);
                System.out.print(osoba.vratiPrezime() + System.lineSeparator());
                Thread.sleep(kasnjenje);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

