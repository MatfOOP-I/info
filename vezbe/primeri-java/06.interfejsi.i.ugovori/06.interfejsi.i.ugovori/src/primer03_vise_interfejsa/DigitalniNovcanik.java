package primer03_vise_interfejsa;

/**
 * Digitalni novčanik ima dve nezavisne sposobnosti:
 *
 * - može da se koristi za plaćanje;
 * - može da se dopunjuje.
 *
 * Zato implementira dva interfejsa.
 */
public class DigitalniNovcanik implements NacinPlacanja, Dopunjiv {
    private int stanje;

    public DigitalniNovcanik(int pocetnoStanje) {
        if (pocetnoStanje < 0) {
            pocetnoStanje = 0;
        }
        stanje = pocetnoStanje;
    }

    @Override
    public boolean plati(int iznos) {
        if (iznos <= 0 || iznos > stanje) {
            return false;
        }

        stanje -= iznos;
        return true;
    }

    @Override
    public void dopuni(int iznos) {
        if (iznos > 0) {
            stanje += iznos;
        }
    }

    public int getStanje() {
        return stanje;
    }
}
