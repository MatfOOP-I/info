package rs.math.oop1.z190500.katanci.z02.osnove;

public class ListanjeImePrezime implements Runnable {

    private Osoba osoba;
    private long kasnjenje;
    private int i = 0;

    public ListanjeImePrezime(String ime, String prezime, long kasnjenje) {
        this.osoba = new Osoba(ime, prezime);
        this.kasnjenje = kasnjenje;
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                Prikaz.prikaziSaKasnjenjem(osoba, kasnjenje, i++);
                Thread.sleep(kasnjenje);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

