package rs.math.oop1.z080301.uredjenje.z02.geometrija;

import java.awt.Graphics;

public class Tacka extends GeometrijskiObjekat
        implements SpecijalniPrikaz, Comparable {
    private int x;
    private int y;

    public Tacka(int xKoord, int yKoord, String o) {
        super(o);
        x = xKoord;
        y = yKoord;
    }

    public Tacka(final Tacka t) {
        this(t.x, t.y, t.getOznaka());
    }

    public Tacka(String o) {
        this(0, 0, o);
    }

    public Tacka() {
        this(0, 0, "O");
    }

    public void setX(int xKoord) {
        x = xKoord;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public void setY(int yKoord) {
        y = yKoord;
    }

    private String toStringHelper(boolean bezOznake) {
        return ( !bezOznake ? getOznaka() : "")
                + "(" + x + "," + y + ")";
    }

    @Override
    public String toString() {
        return toStringHelper(false);
    }

    @Override
    public void prikaziSe() {
        System.out.print(this);
    }

    @Override
    public void prikaziSe(Graphics zaslon) {
        zaslon.drawOval(x - 2, y - 2, 4, 4);
        zaslon.drawString(getOznaka(), x - 15, y - 15);
    }

    @Override
    public void prikaziSe(boolean bezOznake) {
        System.out.print( toStringHelper(bezOznake));
    }

    public double rastojanje(Tacka drugaTacka) {
        return Math.sqrt(Math.pow(x - drugaTacka.x, 2)
                + Math.pow(y - drugaTacka.y, 2));
    }

    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Tacka))
            return -1;  // Tacka je uvek ispred neceg sto nije tacka
        Tacka t = (Tacka) obj;
        Tacka o = new Tacka(0, 0, "");
        double razlika = rastojanje(o) - t.rastojanje(o);
        if (razlika != 0)
            return (int) razlika;
        return x - t.x;
    }
}
