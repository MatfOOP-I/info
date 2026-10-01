package primer03_apstraktna_klasa;

public class Taksi extends Prevoz {
    public Taksi() {
        super("Taksi");
    }

    @Override
    public int izracunajCenu(int udaljenostKm) {
        return 300 + udaljenostKm * 95;
    }
}
