package primer02_porudzbina_i_stavke;

public class Adresa {
    private String ulica;
    private int broj;
    private String grad;

    public Adresa(String ulica, int broj, String grad) {
        this.ulica = ulica;
        this.broj = broj;
        this.grad = grad;
    }

    public String opis() {
        return ulica + " " + broj + ", " + grad;
    }
}
