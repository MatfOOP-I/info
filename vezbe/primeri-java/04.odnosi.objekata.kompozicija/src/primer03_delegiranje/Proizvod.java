package primer03_delegiranje;

public class Proizvod {
    private String naziv;
    private int cena;

    public Proizvod(String naziv, int cena) {
        this.naziv = naziv;
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getCena() {
        return cena;
    }
}
