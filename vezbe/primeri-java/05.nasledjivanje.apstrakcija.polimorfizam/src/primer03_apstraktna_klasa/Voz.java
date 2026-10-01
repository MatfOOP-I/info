package primer03_apstraktna_klasa;

public class Voz extends Prevoz {
    public Voz() {
        super("Voz");
    }

    @Override
    public int izracunajCenu(int udaljenostKm) {
        return 250 + udaljenostKm * 8;
    }
}
