package proroci;

import java.util.Arrays;

public class TarotProrok extends  Prorok {

    private TarotKarta[] karte;
    private int i;

    public TarotProrok(String ime, int ostvarenoProrocanstava, int ukupnoProrocanstava, TarotKarta[] karte) {
        super(ime, ostvarenoProrocanstava, ukupnoProrocanstava);
        this.karte = Arrays.copyOf(karte, karte.length);
    }

    public TarotKarta[] getKarte() {
        return karte;
    }

    public TarotKarta izvuciKartu() {
        TarotKarta tk = karte[i];

        i = (i+1)%karte.length;

        return tk;
    }

    public String proreci(final TarotKarta tk) {
        String vreme = "sadasnjost";
        if (tk.getVreme() == 1)
            vreme = "buducnost";
        if (tk.getVreme() == -1)
            vreme = "proslost";

        return vreme + " " + tk.getOpis();
    }

    @Override
    public String toString() {
        return "[tarot prorok] " + super.toString() + ", poseduje karata: " + karte.length;
    }
}
