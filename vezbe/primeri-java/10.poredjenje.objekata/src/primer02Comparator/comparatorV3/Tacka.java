package primer02Comparator.comparatorV3;

import java.util.Comparator;

public class Tacka {
    private int x, y;

    /*
        Umesto da dodajemo klasu koju samo koristimo na jednom
        mestu, mozemo da koristimo konstrukciju za anonimne klase
        i na taj nacin dobijemo isto ponasanje kao u proslom
        primeru. Anonimna klasa tera kompajler da generise klasu
        koja lici na onu navedenu u proslom paketu.
    */
    public final static Comparator<Tacka> porediPoXPaY = new Comparator<Tacka>() {
        @Override
        public int compare(Tacka o1, Tacka o2) {
            return o1.getX() != o2.getX() ?
                    Integer.compare(o1.getX(), o2.getX()):
                    Integer.compare(o1.getY(), o2.getY());
        }
    };

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
