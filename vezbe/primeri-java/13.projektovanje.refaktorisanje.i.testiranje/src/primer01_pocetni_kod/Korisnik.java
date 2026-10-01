package primer01_pocetni_kod;

public class Korisnik {
    private String clanskiBroj;
    private String ime;

    public Korisnik(String clanskiBroj, String ime) {
        this.clanskiBroj = clanskiBroj;
        this.ime = ime;
    }

    public String getClanskiBroj() {
        return clanskiBroj;
    }

    public void setClanskiBroj(String clanskiBroj) {
        this.clanskiBroj = clanskiBroj;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
