package primer02Comparator.comparatorV4;

import java.util.Comparator;

public class Tacka {
    private int x, y;

    /*
        Anonimnu klasi iz proslog paketa (comparatorV3) mozemo 
        zameniti lambda izrazom (anonimna funkcija) koja ce
        generisati potreban comparator u zavisnosti od toga kako 
        definisemo lambdu.
    */
    
    public final static Comparator<Tacka> porediPoXPaY =
            (o1, o2) -> o1.getX() != o2.getX() ?
                    Integer.compare(o1.getX(), o2.getX()):
                    Integer.compare(o1.getY(), o2.getY());

    /*
        Ukoliko nam je potrebno da sortiramo tacke na vise nacina, 
        mozemo definisati novi komparator na slican nacin kao u 
        prethodnom primeru.
    */ 
    public final static Comparator<Tacka> porediPoYPaX =
            (o1, o2) -> o1.getY() != o2.getY() ?
                    Integer.compare(o1.getY(), o2.getY()):
                    Integer.compare(o1.getX(), o2.getX());
    
    public Tacka(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
