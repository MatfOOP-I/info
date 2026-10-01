package primer06_wildcard;

public class Sat implements Procenjiv {
    private final int vrednost;

    public Sat(int vrednost) {
        this.vrednost = vrednost;
    }

    @Override
    public int proceniVrednost() {
        return vrednost;
    }
}
