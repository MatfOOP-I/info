package podmornice;

import java.util.Map;
import java.util.TreeMap;

public class Podmornica implements Comparable<Podmornica> {

    private Polje pocetnoPolje;
    private char pravac;
    private int velicinaPodmornice;
    private Map<Polje, Boolean> zauzetaPolja;

    /***************************************************/
    private Polje poslednjePolje;
    /***************************************************/

    public Podmornica(Polje pocetnoPolje, char pravac, int velicinaPodmornice) {
        this.pocetnoPolje = pocetnoPolje;
        this.pravac = pravac;
        this.velicinaPodmornice = velicinaPodmornice;
        postaviPodmornicu();
    }

    public Polje getPolje() {
        return pocetnoPolje;
    }
    
    public Map<Polje, Boolean> getZauzetaPolja() {
        return zauzetaPolja;
    }

    private void postaviPodmornicu() {
        int i;
        zauzetaPolja = new TreeMap<>();

        if (pravac == 'r') {
            for (i=0; i<velicinaPodmornice; i++) {
                zauzetaPolja.put(new Polje(getPolje().getX(), getPolje().getY() + i), false);
            }

            poslednjePolje = new Polje(getPolje().getX(), getPolje().getY() + i - 1);
        }
        else {
            for (i=0; i<velicinaPodmornice; i++) {
                zauzetaPolja.put(new Polje(getPolje().getX() + i, getPolje().getY()), false);
            }

            poslednjePolje = new Polje(getPolje().getX() + i - 1, getPolje().getY());
        }
    }

    public void pogodjenoPolje(Polje k) {
        zauzetaPolja.put(k, true);
    }


    public boolean pogodjenaPodmornica(Polje k) {
        return zauzetaPolja.keySet().contains(k);
    }


    @Override
    public String toString() {
        return getPolje().toString() + " - " + poslednjePolje.toString() + " (" + velicinaPodmornice + ")\n" ;

    }

    @Override
    public int compareTo(Podmornica o) {
        if (this.pravac > o.pravac)
            return -1;
        else if (this.pravac < o.pravac)
            return 1;
        else
            return this.getPolje().compareTo(o.getPolje());
    }
}
