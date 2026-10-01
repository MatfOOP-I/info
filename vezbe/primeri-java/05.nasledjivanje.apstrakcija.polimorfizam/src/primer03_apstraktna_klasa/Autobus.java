package primer03_apstraktna_klasa;

public class Autobus extends Prevoz {
    public Autobus() {
        super("Autobus");
    }

    @Override
    public int izracunajCenu(int udaljenostKm) {
        return 150 + udaljenostKm * 7;
    }
}
