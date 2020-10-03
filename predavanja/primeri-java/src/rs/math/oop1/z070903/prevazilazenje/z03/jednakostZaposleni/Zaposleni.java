package rs.math.oop1.z070903.prevazilazenje.z03.jednakostZaposleni;

public class Zaposleni {
    private int broj;
    private String ime;
    private double plata;

    public Zaposleni(String i, int br, double s) {
        ime = i;
        broj = br;
        plata = s;
    }

    public int getBroj() {
        return broj;
    }

    public String getIme() {
        return ime;
    }

    public double getPlata() {
        return plata;
    }

    public void povisica(double zaProcenat) {
        double iznos = plata * zaProcenat / 100;
        plata += iznos;
    }

    @Override
    public String toString() {
        return String.format("ime:%s, broj:%d, plata:%.2f", ime, broj, plata);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Zaposleni))
            return false;
        Zaposleni e = (Zaposleni) o;
        if (!(ime.equals(e.getIme())))
            return false;
        if (broj != e.broj)
            return false;
        if (plata != e.plata)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hkIme = ime.hashCode();
        int hkBroj = new Integer(broj).hashCode(); // bolje je hkValue = broj; 
        int hkPlata = new Double(plata).hashCode();
        return 3 * hkIme + 5 * hkBroj + 7 + hkPlata;
    }
}
