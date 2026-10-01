package primer06_promena_nacina_placanja;

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

    @Override
    public String naziv() {
        return "digitalni novčanik";
    }
}
