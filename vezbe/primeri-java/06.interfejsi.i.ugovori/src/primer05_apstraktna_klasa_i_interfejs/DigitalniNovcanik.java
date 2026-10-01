package primer05_apstraktna_klasa_i_interfejs;

/**
 * Digitalni novčanik NIJE PlatnaKartica.
 *
 * Ipak, i on ume da izvrši plaćanje, pa može da poštuje isti interfejs.
 */
public class DigitalniNovcanik implements NacinPlacanja {
    private int stanje;

    public DigitalniNovcanik(int stanje) {
        this.stanje = Math.max(stanje, 0);
    }

    @Override
    public boolean plati(int iznos) {
        if (iznos <= 0 || iznos > stanje) {
            return false;
        }

        stanje -= iznos;
        return true;
    }
}
