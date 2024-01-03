package PrimerIspita;

import java.util.Comparator;

public class Tacka implements Comparable<Tacka> {
    private double x, y;

    public final static Comparator<Tacka> poXPaPoY = new Comparator<Tacka>() {
        @Override
        public int compare(Tacka o1, Tacka o2) {
            if (o1.getX() != o2.getX()){
                return Double.compare(o1.getX(), o2.getX());
            }

            return Double.compare(o1.getY(), o2.getY());
        }
    };
    public Tacka(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Tacka o) {
        if (x != o.x){
            return Double.compare(x, o.x);
        }
        return Double.compare(y, o.y);
    }
}
