package racunari;

import java.util.Map;
import java.util.TreeMap;

public class Korisnik {
    private String korisnickoIme;
    private int vipKrediti;
    private Map<Racunar, Double> dugovi;

    public Korisnik(String korisnickoIme, int vipKrediti) {
        this.korisnickoIme = korisnickoIme;
        this.vipKrediti = vipKrediti;
        dugovi = new TreeMap<>();
    }

    public void dodajRacunar(Racunar racunar) {
        dugovi.put(racunar, 0.0);
    }

    public void azurirajDug(Racunar r, double cena) {
        dugovi.put(r, cena);
    }


    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public int getVipKrediti() {
        return vipKrediti;
    }

    public void umanjiVipKredite() {
        vipKrediti--;
    }

    public double ukupanDug() {
        return dugovi.values().stream().mapToDouble(f -> f).sum();
    }

    public Map<Racunar, Double> getDugovi() {
        return dugovi;
    }

    @Override
    public String toString() {
        return "Korisnik "+korisnickoIme+" ";
    }
}
