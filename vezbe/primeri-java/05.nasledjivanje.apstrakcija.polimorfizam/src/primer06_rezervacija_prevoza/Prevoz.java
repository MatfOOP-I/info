package primer06_rezervacija_prevoza;

public abstract class Prevoz {
    private final String naziv;

    public Prevoz(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public abstract int izracunajCenu(int udaljenostKm);
}
