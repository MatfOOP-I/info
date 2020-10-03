package vesala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rec {
    private String rec;
    private String nagovestaj;
    private List<Character> isprobanaSlova;
    private int tezina;

    public static void main(String[] args) {
        Rec r = new Rec("algoritam", "Glavni grad evropske drzave");
        System.out.println("Tezina: " + r.getTezina());
        System.out.println(r);
        System.out.println(r.pogodjenaSlovaReci());
    }

    private static int tezinaReci(String rec) {
        long brSuglasnika = rec.toLowerCase().trim().chars()
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .filter(ch -> ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
                .count();

        double procenatSuglasnika = brSuglasnika / (double)rec.length();
        System.out.println(procenatSuglasnika);
        double tezinaProcenat = procenatSuglasnika * (1 - (double)rec.length() / (rec.length() + 10));

        if (tezinaProcenat < 0.333)
            return 1;
        else if (tezinaProcenat < 0.666)
            return 2;
        else
            return 3;
    }

    public Rec(String rec) {
        this.rec = rec;
        this.tezina = tezinaReci(rec);
        this.isprobanaSlova = new ArrayList<>();
    }

    public Rec(String rec, String nagovestaj) {
        this.rec = rec;
        this.nagovestaj = nagovestaj;
        this.tezina = tezinaReci(rec);
        this.isprobanaSlova = new ArrayList<>();
    }

    public String getRec() {
        return rec;
    }

    public String getNagovestaj() {
        return nagovestaj;
    }

    public List<Character> getIsprobanaSlova() {
        return isprobanaSlova;
    }

    public int getTezina() {
        return tezina;
    }


    public String pogodjenaSlovaReci(){
        char[] recCopy = rec.toCharArray();

        for (int i=0; i<recCopy.length; i++){
            if (!(isprobanaSlova.contains(recCopy[i])))
                recCopy[i] = '_';
        }

        return String.valueOf(recCopy);
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public void setNagovestaj(String nagovestaj) {
        this.nagovestaj = nagovestaj;
    }

    public void dodajIsprobanoSlovo(char ch){
        isprobanaSlova.add(ch);
}

    @Override
    public String toString() {
        return rec + ", " + tezina;
    }
}
