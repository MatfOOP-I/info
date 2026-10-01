package primer06_wildcard;

public class Telefon implements Procenjiv {
    private final int vrednost;

    public Telefon(int vrednost) {
        this.vrednost = vrednost;
    }

    @Override
    public int proceniVrednost() {
        return vrednost;
    }
}
