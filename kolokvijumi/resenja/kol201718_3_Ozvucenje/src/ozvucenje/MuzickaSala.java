package ozvucenje;

import java.util.Arrays;

public class MuzickaSala extends Prostorija {
    private int brojMesta;
    private boolean[] mesta;
    private Zvucnik[] ozvucenje;
    static int brojacInstanci = 0;

    public MuzickaSala(String naziv, double duzina, double sirina, int brojMesta, Zvucnik[] ozvucenje) {
        super(naziv, duzina, sirina);
        this.brojMesta = brojMesta;
        mesta = new boolean[brojMesta];
        this.ozvucenje = Arrays.copyOf(ozvucenje, ozvucenje.length);
        brojacInstanci++;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    public boolean[] getMesta() {
        return mesta;
    }

    public Zvucnik[] getOzvucenje() {
        return ozvucenje;
    }

    public static int getBrojacInstanci() {
        return brojacInstanci;
    }

    public void zauzmiMesto(int i) {
        if (mesta[i]) {
            System.out.println("Mesto pod rednim brojem " + i + " je vec zauzeto!");
        } else {
            mesta[i] = true;
        }
    }

    public boolean proveriOzvucenje() {
        int ukupnaSnaga = 0;
        for (Zvucnik z : ozvucenje) {
            if (z.isUkljucen())
                ukupnaSnaga+=z.getSnaga();
        }
        double koeficijent = 2.2;
        for (boolean m : mesta) {
            if (!m) {
                koeficijent -= 0.2;
                break;
            }
        }
        return ukupnaSnaga / (duzina*sirina) >= koeficijent;
    }

    @Override
    public String toString() {
        return "Muzicka sala "+ naziv + " povrsine "+(duzina*sirina)+"m^2 sa "+brojMesta+" mesta za sedenje.";
    }
}
