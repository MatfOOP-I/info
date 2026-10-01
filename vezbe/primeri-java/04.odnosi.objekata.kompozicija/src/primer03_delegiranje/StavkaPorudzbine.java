package primer03_delegiranje;

/**
 * Stavka je odgovorna za podatke i operacije koje pripadaju jednoj
 * stavci porudžbine.
 */
public class StavkaPorudzbine {
    private Proizvod proizvod;
    private int kolicina;

    public StavkaPorudzbine(Proizvod proizvod, int kolicina) {
        this.proizvod = proizvod;
        this.kolicina = kolicina;
    }

    /**
     * Cena jedne stavke pripada upravo ovoj klasi: ona jedina prirodno
     * zna i koji je proizvod u pitanju i kolika je količina.
     */
    public int izracunajCenu() {
        return proizvod.getCena() * kolicina;
    }

    public String opis() {
        return proizvod.getNaziv() + " x " + kolicina
                + " = " + izracunajCenu() + " din";
    }
}
