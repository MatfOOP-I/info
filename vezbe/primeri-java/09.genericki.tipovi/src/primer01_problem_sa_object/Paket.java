package primer01_problem_sa_object;

/**
 * Verzija bez generika.
 *
 * Object dozvoljava da čuvamo bilo koji objekat, ali gubimo informaciju
 * o njegovom konkretnom tipu.
 */
public class Paket {
    private Object sadrzaj;

    public Paket(Object sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Object getSadrzaj() {
        return sadrzaj;
    }

    public void postaviSadrzaj(Object sadrzaj) {
        this.sadrzaj = sadrzaj;
    }
}
