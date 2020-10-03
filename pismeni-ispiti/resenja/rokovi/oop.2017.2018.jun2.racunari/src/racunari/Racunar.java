package racunari;

import java.util.List;

public abstract class Racunar implements Comparable<Racunar> {
    private String ime;
    private double cenovniKoef;

    public Racunar(String ime, double cenovniKoef) {
        this.ime = ime;
        this.cenovniKoef = cenovniKoef;
    }

    public String getIme() {
        return ime;
    }

    public double getCenovniKoef() {
        return cenovniKoef;
    }

    public abstract double izracunajCenu(List<Integer> duzineKoriscenja);

    @Override
    public int compareTo(Racunar o) {
        if (this instanceof RacunarZaObradu && o instanceof RacunarZaObradu) {
            return -Integer.compare(((RacunarZaObradu) this).getBrojProcesora(), ((RacunarZaObradu) o).getBrojProcesora());
        } else if (this instanceof RacunarZaObradu) {
            return -1;
        } else if (o instanceof RacunarZaObradu) {
            return 1;
        } else if (o instanceof RacunarZaCuvanje) {
            return -Integer.compare(((RacunarZaCuvanje) this).getVelicinaDiska(), ((RacunarZaCuvanje) o).getVelicinaDiska());
        } else {
            System.out.println("Ne treba da se desi");
            return 0;
        }
    }
}
