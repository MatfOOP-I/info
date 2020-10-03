package rs.math.oop1.z070901.objektiJDK.z02.zaposleniFinalizator;

class Zaposleni {
    private int broj;
    private String ime;
    private double plata;

    public Zaposleni(String n, int br, double s) {
        ime = n;
        broj = br;
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
    public void finalize() {
        System.out.println("FINALIZUJEM! " + ime + ":" + broj);
    }
}

public class PokretanjeZaposleni {
    public static void main(String[] args) {

        // fill the osoblje array with three Zaposleni objects
        if (1 > 0) {
            Zaposleni[] osoblje = new Zaposleni[3];
            osoblje[0] = new Zaposleni("Janko Jankovic", 1, 75000);
            osoblje[1] = new Zaposleni("Marko Markovic", 2, 50000);
            osoblje[2] = new Zaposleni("Tony Tester", 3, 40000);
            for (Zaposleni e : osoblje)
                System.out.println(e);
        }
        System.gc();
        for (int i = 0; i < 10_000; i += 3) {
            Zaposleni[] osoblje = new Zaposleni[3];
            osoblje[0] = new Zaposleni("Janko Jankovic", i, 75000);
            osoblje[1] = new Zaposleni("Marko Markovic", i + 1, 50000);
            osoblje[2] = new Zaposleni("Tony Tester", i + 2, 40000);
            if (i % 300 == 0)
                System.gc();
        }

    }
}
