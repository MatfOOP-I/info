package primer03_invarijante;

/**
 * Digitalni novčanik koji sam čuva ispravnost svog stanja.
 *
 * <p>Invarijanta klase je:</p>
 *
 * <pre>
 * stanje >= 0
 * </pre>
 *
 * <p>Korisniku klase ne nudimo setter za stanje. Umesto toga nudimo
 * operacije koje imaju smisla u domenu problema: uplatu i plaćanje.</p>
 */
public class Novcanik {
    private String vlasnik;
    private int stanje;

    public Novcanik(String vlasnik) {
        this.vlasnik = vlasnik;
        this.stanje = 0;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public int getStanje() {
        return stanje;
    }

    /**
     * Pokušava da uplati novac na novčanik.
     *
     * @param iznos iznos u dinarima
     * @return {@code true} ako je uplata izvršena; {@code false} ako je
     *         prosleđen neispravan iznos ili bi stanje prekoračilo int opseg
     */
    public boolean uplati(int iznos) {
        if (iznos <= 0 || iznos > Integer.MAX_VALUE - stanje) {
            return false;
        }

        stanje += iznos;
        return true;
    }

    /**
     * Pokušava da plati zadati iznos.
     *
     * <p>Metoda sama proverava da li je operacija dozvoljena. Pozivalac
     * ne mora da zna kako klasa čuva stanje niti da ponavlja ovu proveru.</p>
     *
     * @param iznos iznos u dinarima
     * @return {@code true} ako je plaćanje izvršeno; u suprotnom
     *         {@code false}
     */
    public boolean plati(int iznos) {
        if (iznos <= 0 || iznos > stanje) {
            return false;
        }

        stanje -= iznos;
        return true;
    }

    /**
     * Pomoćna operacija koja izražava pitanje iz domena problema.
     */
    public boolean imaDovoljnoSredstava(int iznos) {
        return iznos > 0 && stanje >= iznos;
    }

    /**
     * Vraća tekstualni opis objekta.
     *
     * <p>Kasnije ćemo videti da Java za ovu namenu ima i standardnu
     * metodu {@code toString()} koju klase mogu da redefinišu.</p>
     */
    public String opis() {
        return "Novcanik{" +
                "vlasnik='" + vlasnik + '\'' +
                ", stanje=" + stanje +
                " din}";
    }
}
