package rs.math.oop1.z070902.niske.z01.radSaObjektima;

class Zaposleni {
    private String ime;
    private double plata;

    public Zaposleni(String n, double s) {
        ime = n;
        plata = s;
    }

    public String getIme() {
        return ime;
    }

    public double getPlata() {
        return plata;
    }

    public void povecajPlatu(double zaProcenat) {
        double iznosPovisice = plata * zaProcenat / 100;
        plata += iznosPovisice;
    }

    @Override
    public String toString() {
        return String.format("Zaposleni - ime: %s, plata: %.2f.", ime, plata);
    }
}

public class PokretanjeNiskaReprezentacija {

    public static void main(String[] args) {
        Zaposleni miki = new Zaposleni("Miki Maus", 42_000);
        System.out.println(miki);
    }

}
