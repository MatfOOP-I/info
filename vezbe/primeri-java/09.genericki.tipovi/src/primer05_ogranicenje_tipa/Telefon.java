package primer05_ogranicenje_tipa;

public class Telefon implements Procenjiv {
    private final String model;
    private final int vrednost;

    public Telefon(String model, int vrednost) {
        this.model = model;
        this.vrednost = vrednost;
    }

    @Override
    public int proceniVrednost() {
        return vrednost;
    }

    public String getModel() {
        return model;
    }
}
