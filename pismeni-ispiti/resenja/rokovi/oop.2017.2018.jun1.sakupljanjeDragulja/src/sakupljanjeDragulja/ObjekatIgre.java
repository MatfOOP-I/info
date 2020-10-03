package sakupljanjeDragulja;

public abstract class ObjekatIgre implements Comparable<ObjekatIgre> {
    private String naziv;
    protected int X, Y;

    public ObjekatIgre(String naziv, int x, int y) {
        this.naziv = naziv;
        X = x;
        Y = y;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }


    @Override
    public String toString() {
        return "["+X+","+Y+"] "+naziv;
    }

    @Override
    public int compareTo(ObjekatIgre o) {
        if (this instanceof Tragac && o instanceof Rudnik) {
            return 1;
        } else if (this instanceof Rudnik && o instanceof Tragac) {
            return -1;
        } else if (this instanceof Tragac && o instanceof Tragac) {
            return -Double.compare(((Tragac) this).getRanac().getSlobodnoTezine(), ((Tragac) o).getRanac().getSlobodnoTezine());
        } else if (this instanceof Rudnik && o instanceof Rudnik) {
            return Double.compare(((Rudnik) this).getVremePostojanja(), ((Rudnik) o).getVremePostojanja());
        } else {
            System.out.println("Ovo takodje ne treba da se desi :)");
            return Double.compare(((Rudnik) this).getVremePostojanja(), ((Rudnik) o).getVremePostojanja());
        }
    }

    public abstract void izvrsiAkciju();
}
