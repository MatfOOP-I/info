package rs.math.oop1.z080100.apstraktneKlase.z05.petShop;

import java.util.Date;

public class Artikal {
    private ZivotinjskaVrsta vrsta;

    private String ime;

    private int kolicina;

    private double cena;

    private Date datumNabavke;

    public ZivotinjskaVrsta getVrsta() {
        return vrsta;
    }

    public void setVrsta(ZivotinjskaVrsta vrsta) {
        this.vrsta = vrsta;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Date getDatumNabavke() {
        return datumNabavke;
    }

    public void setDatumNabavke(Date datumNabavke) {
        this.datumNabavke = datumNabavke;
    }
}
