package primer06_strategy;

/**
 * Objekat koji koristi Strategy.
 *
 * Lik ne zna detalje konkretne strategije.
 * Zna samo ugovor PonasanjeKretanja.
 */
public class Lik {
    private final String ime;
    private PonasanjeKretanja strategijaKretanja;

    public Lik(
            String ime,
            PonasanjeKretanja strategijaKretanja
    ) {
        this.ime = ime;
        this.strategijaKretanja = strategijaKretanja;
    }

    public void kreciSe() {
        strategijaKretanja.kreciSe(ime);
    }

    public void postaviStrategijuKretanja(
            PonasanjeKretanja novaStrategija
    ) {
        strategijaKretanja = novaStrategija;
    }
}
