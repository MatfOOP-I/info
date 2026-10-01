package primer05_ogranicenje_tipa;

public class Sat implements Procenjiv {
    private final String naziv;
    private final int vrednost;

    public Sat(String naziv, int vrednost) {
        this.naziv = naziv;
        this.vrednost = vrednost;
    }

    @Override
    public int proceniVrednost() {
        return vrednost;
    }

    public String getNaziv() {
        return naziv;
    }
}
