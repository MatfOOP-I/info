package primer06_rezervacija_prevoza;

/** Nepromenljiva vrednost koja opisuje jedno putovanje. */
public class Relacija {
    private final String polaziste;
    private final String odrediste;
    private final int udaljenostKm;

    public Relacija(String polaziste, String odrediste, int udaljenostKm) {
        this.polaziste = polaziste;
        this.odrediste = odrediste;
        this.udaljenostKm = udaljenostKm;
    }

    public int getUdaljenostKm() {
        return udaljenostKm;
    }

    public String opis() {
        return polaziste + " -> " + odrediste + " (" + udaljenostKm + " km)";
    }
}
