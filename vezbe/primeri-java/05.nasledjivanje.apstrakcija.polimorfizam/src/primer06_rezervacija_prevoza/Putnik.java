package primer06_rezervacija_prevoza;

public class Putnik {
    private final String ime;
    private final String prezime;

    public Putnik(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public String punoIme() {
        return ime + " " + prezime;
    }
}
