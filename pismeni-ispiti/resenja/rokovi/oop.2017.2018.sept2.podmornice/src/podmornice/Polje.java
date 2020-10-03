package podmornice;

public class Polje implements Comparable<Polje> {

    private int x, y;

    public Polje(int x, int y) {
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
        return "[" + x +
                ", " + y +
                ']';
    }


    /**********************************************************************************/
    @Override
    public int compareTo(Polje o) {
        if (this.getX() != o.getX())
            return this.getX() - o.getX();
        else
            return this.getY() - o.getY();
    }


    // dodato zbog metoda odigrajPotez koji koristi contains metod
    @Override
    public boolean equals(Object k) {
        return k instanceof Polje &&
                this.x == ((Polje) k).getX() &&
                this.getY() == ((Polje) k).getY();
    }
    /**********************************************************************************/
}
