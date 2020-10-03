package sakupljanjeDragulja;

public class Rudnik extends ObjekatIgre {
    private int otvorenJos;
    private double tezinaDragulja;

    public Rudnik(String naziv, int x, int y, double tezina, int vremePostojanja) {
        super(naziv, x, y);
        this.otvorenJos = vremePostojanja;
        this.tezinaDragulja = tezina;
    }

    public int getVremePostojanja() {
        return otvorenJos;
    }
    public boolean isOtvoren() {
        return otvorenJos > 0;
    }

    public double getTezinaDragulja() {
        return tezinaDragulja;
    }

    @Override
    public void izvrsiAkciju() {
        if (isOtvoren())
            otvorenJos--;
    }

    @Override
    public String toString() {
        return "Rudnik: "+super.toString() + " je otvoren jos "+otvorenJos+" poteza";
    }
}
