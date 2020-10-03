package proroci;

public class Prorok {
    private String ime;
    private int ostvarenoProrocanstava, ukupnoProrocanstava;

    public Prorok(String ime, int ostvarenoProrocanstava, int ukupnoProrocanstava) {
        this.ime = ime;
        this.ostvarenoProrocanstava = ostvarenoProrocanstava;
        this.ukupnoProrocanstava = ukupnoProrocanstava;
    }

    public Prorok(final Prorok p) {
        this(p.ime, p.ostvarenoProrocanstava, p.ukupnoProrocanstava);
    }

    public void zabeleziIshodProrocanstva(boolean status) {
        ukupnoProrocanstava++;
        if (status) ostvarenoProrocanstava++;
    }

    public String getIme() { return ime; }
    public int getOstvarenoProrocanstava() { return ostvarenoProrocanstava; }
    public int getUkupnoProrocanstava() { return ukupnoProrocanstava; }
    public float getProcenatUspesnosti() { return ostvarenoProrocanstava*1.0f/ukupnoProrocanstava*100.0f; }

    @Override
    public String toString() {
        return "ime: " + ime + " uspelo: " + ostvarenoProrocanstava + ", ukupno: " + ukupnoProrocanstava;
    }
}
