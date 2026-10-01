package primer04_konstruktori_static_final;

/**
 * Verzija novčanika koja ima i identitet.
 *
 * <p>Svaki objekat ima svoj {@code id}, vlasnika i stanje. Brojač
 * {@code sledeciId} pripada klasi, pa ga dele svi objekti.</p>
 */
public class Novcanik {
    /**
     * Zajednički podatak za sve objekte klase Novcanik.
     */
    private static int sledeciId = 1;

    /**
     * ID se postavlja samo jednom u konstruktoru.
     */
    private final int id;

    /**
     * U ovom pojednostavljenom modelu vlasnik novčanika se ne menja.
     */
    private final String vlasnik;

    /**
     * Stanje je deo objekta koji sme da se menja kroz dozvoljene operacije.
     */
    private int stanje;

    public Novcanik(String vlasnik) {
        this.id = sledeciId;
        sledeciId++;

        this.vlasnik = vlasnik;
        this.stanje = 0;
    }

    public int getId() {
        return id;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public int getStanje() {
        return stanje;
    }

    public boolean uplati(int iznos) {
        if (iznos <= 0) {
            return false;
        }

        stanje += iznos;
        return true;
    }

    public boolean plati(int iznos) {
        if (iznos <= 0 || iznos > stanje) {
            return false;
        }

        stanje -= iznos;
        return true;
    }

    public static int getBrojKreiranihNovcanika() {
        return sledeciId - 1;
    }

    public String opis() {
        return "Novcanik #" + id +
                " [vlasnik=" + vlasnik +
                ", stanje=" + stanje + " din]";
    }
}
