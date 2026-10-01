package primer01_pocetni_kod;

/**
 * Ova klasa nije "pogrešna Java".
 *
 * Problem je što objekat gotovo ništa ne radi sam.
 * Ostatak programa mora da zna kako da tumači tip i menja dostupnost.
 */
public class Vozilo {
    private String oznaka;
    private String tip;
    private String naziv;
    private int cenaPoDanu;
    private boolean dostupno = true;

    public Vozilo(
            String oznaka,
            String tip,
            String naziv,
            int cenaPoDanu
    ) {
        this.oznaka = oznaka;
        this.tip = tip;
        this.naziv = naziv;
        this.cenaPoDanu = cenaPoDanu;
    }

    public String getOznaka() {
        return oznaka;
    }

    public String getTip() {
        return tip;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getCenaPoDanu() {
        return cenaPoDanu;
    }

    public boolean isDostupno() {
        return dostupno;
    }

    public void setDostupno(boolean dostupno) {
        this.dostupno = dostupno;
    }
}
