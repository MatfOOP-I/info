package primer01_osnovno_nasledjivanje;

/**
 * Bazna klasa za nekoliko vrsta prevoza.
 *
 * <p>U baznu klasu stavljamo ono što je zaista zajedničko svim
 * vrstama prevoza koje trenutno modelujemo.</p>
 */
public class Prevoz {
    private String naziv;
    private int prosecnaBrzina;

    public Prevoz(String naziv, int prosecnaBrzina) {
        this.naziv = naziv;
        this.prosecnaBrzina = prosecnaBrzina;
    }

    public String getNaziv() {
        return naziv;
    }

    public int proceniTrajanje(int udaljenostKm) {
        return udaljenostKm * 60 / prosecnaBrzina;
    }

    public String opis() {
        return naziv + " (prosecna brzina " + prosecnaBrzina + " km/h)";
    }
}
