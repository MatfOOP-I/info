package primer02_redefinisanje_metoda;

public class Taksi extends Prevoz {
    public Taksi(String naziv) {
        super(naziv);
    }

    @Override
    public int izracunajCenu(int udaljenostKm) {
        return 300 + udaljenostKm * 95;
    }
}
