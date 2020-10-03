package podmornice;

import java.util.*;

public abstract class Igrac {
    private Map<Podmornica, Boolean> podmornice;
    private Igrac protivnik;

    /***************************************************/
    private List<Polje> gadjano;
    /***************************************************/

    public Igrac() {
        this.podmornice = new TreeMap<>();
        this.gadjano = new ArrayList<>();
        inicijalizuj();
    }

    public Map<Podmornica, Boolean> getPodmornice() {
        return podmornice;
    }

    public void setProtivnik(Igrac protivnik) {
        this.protivnik = protivnik;
    }

    private void potopljenaPodmornica(Podmornica p) {
        for (boolean b : p.getZauzetaPolja().values()) {
            if (!b) {
                return;
            }
        }

        potopiPodmornicu(p);
    }


    public void dodajPodmornicu(Podmornica p) {
        podmornice.put(p, false);
    }

    public void potopiPodmornicu(Podmornica p) {
        podmornice.put(p, true);
    }

    public boolean odigrajPotez(Polje k) {
        if (gadjano.contains(k)) {
            return false;
        }

        gadjano.add(k);

        for (Map.Entry<Podmornica, Boolean> e : protivnik.getPodmornice().entrySet()) {
            if (e.getKey().pogodjenaPodmornica(k)) {
                e.getKey().pogodjenoPolje(k);
                protivnik.potopljenaPodmornica(e.getKey());
                return true;
            }
        }

        return false;
    }

    public boolean pobedio() {
        for (boolean b : protivnik.getPodmornice().values()) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    public abstract boolean inicijalizuj();
}
