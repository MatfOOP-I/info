package poruke;

import java.util.ArrayList;
import java.util.List;

public class Korisnik {

    private String korisnickoIme;
    private List<Poruka> poruke;

    public Korisnik(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
        this.poruke = new ArrayList<>();
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }


    public List<Poruka> getPoruke() {
        return poruke;
    }

    public void novaPoruka(String podaci) {
        String[] razdvojeno = podaci.split(";");

        String datum = razdvojeno[1].trim();
        String ime = razdvojeno[2].trim();
        String poruka = razdvojeno[3].trim();

        if(razdvojeno[0].trim().equals("r")) {
            boolean procitano = razdvojeno[4].trim().equals("da");
            poruke.add(new PrimljenaPoruka(poruka, datum, ime, procitano));
        }
        else {
            poruke.add(new PoslataPoruka(poruka, datum, ime));
        }
    }

    @Override
    public String toString() {
        return korisnickoIme;
    }
}
