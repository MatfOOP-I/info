package videoIgre;

/**
 * Created by nmico on 6/8/2017.
 */
public abstract class VideoIgra {
    private String ime, zanr;
    private int cena;

    public VideoIgra(String ime, String zanr, int cena) {
        this.ime = ime;
        this.zanr = zanr;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public String getZanr() {
        return zanr;
    }

    public int getCena() {
        return cena;
    }

    public abstract String getPlatforma();

    @Override
    public String toString() {
        return "[" + getPlatforma() + "]: " + "ime: " + ime + " zanr: " + zanr + " cena: " + cena;
    }
}
