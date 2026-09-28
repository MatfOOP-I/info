package primer02_setter_nije_enkapsulacija;

/**
 * Druga verzija novčanika.
 *
 * <p>Polja su sada privatna, ali setter za stanje i dalje dopušta
 * korisniku klase da postavi proizvoljan iznos. Samo sakrivanje polja
 * zato nije dovoljno za dobru enkapsulaciju.</p>
 */
public class Novcanik {
    private String vlasnik;
    private int stanje;

    public Novcanik(String vlasnik) {
        this.vlasnik = vlasnik;
        this.stanje = 0;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public int getStanje() {
        return stanje;
    }

    /**
     * Namerno problematična metoda.
     *
     * <p>Tehnički kontrolišemo pristup polju, ali korisniku klase i dalje
     * nudimo operaciju koja ne odgovara stvarnom ponašanju novčanika.</p>
     */
    public void setStanje(int stanje) {
        this.stanje = stanje;
    }
}
