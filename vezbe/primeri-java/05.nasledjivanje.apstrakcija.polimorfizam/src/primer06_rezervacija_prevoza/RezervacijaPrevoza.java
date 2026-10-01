package primer06_rezervacija_prevoza;

/**
 * Primer u kome zajedno koristimo kompoziciju i polimorfizam.
 *
 * <p>Rezervacija IMA putnika, relaciju i izabrani prevoz. Polje
 * {@code prevoz} je tipa bazne klase, pa rezervacija ne mora da zna
 * da li je izabran autobus, voz ili taksi.</p>
 */
public class RezervacijaPrevoza {
    private final Putnik putnik;
    private final Relacija relacija;
    private final Prevoz prevoz;

    public RezervacijaPrevoza(Putnik putnik, Relacija relacija, Prevoz prevoz) {
        this.putnik = putnik;
        this.relacija = relacija;
        this.prevoz = prevoz;
    }

    public int izracunajCenu() {
        // Delegiramo računanje konkretnom Prevoz objektu.
        return prevoz.izracunajCenu(relacija.getUdaljenostKm());
    }

    public String opis() {
        return putnik.punoIme() + "\n"
                + relacija.opis() + "\n"
                + "Prevoz: " + prevoz.getNaziv() + "\n"
                + "Cena: " + izracunajCenu() + " din";
    }
}
