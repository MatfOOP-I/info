package videoIgre;

/**
 * Created by nmico on 6/8/2017.
 */
public class PCVideoIgra extends VideoIgra {

    private int zahtevnost;

    public PCVideoIgra(String ime, String zanr, int cena, int zahtevnost) {
        super(ime, zanr, cena);
        this.zahtevnost = zahtevnost;
    }

    public int getZahtevnost() {
        return zahtevnost;
    }

    @Override
    public String getPlatforma() {
        return "pc";
    }

    @Override
    public String toString() {
        return super.toString() + " " + zahtevnost + "/5";
    }
}
