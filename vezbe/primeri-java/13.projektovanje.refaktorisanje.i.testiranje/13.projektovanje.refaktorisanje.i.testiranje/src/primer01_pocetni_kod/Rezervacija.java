package primer01_pocetni_kod;

/**
 * Status i tip obračuna su obični String-ovi.
 *
 * Kompajler ne može da spreči vrednosti kao:
 *
 * "AKTVINA"
 * "premium"
 * "nešto treće"
 */
public class Rezervacija {
    private final int broj;
    private Korisnik korisnik;
    private Vozilo vozilo;
    private int brojDana;
    private String tipObracuna;
    private String status;
    private int ukupnaCena;

    public Rezervacija(
            int broj,
            Korisnik korisnik,
            Vozilo vozilo,
            int brojDana,
            String tipObracuna,
            int ukupnaCena
    ) {
        this.broj = broj;
        this.korisnik = korisnik;
        this.vozilo = vozilo;
        this.brojDana = brojDana;
        this.tipObracuna = tipObracuna;
        this.ukupnaCena = ukupnaCena;
        this.status = "KREIRANA";
    }

    public int getBroj() {
        return broj;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public String getTipObracuna() {
        return tipObracuna;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUkupnaCena() {
        return ukupnaCena;
    }
}
