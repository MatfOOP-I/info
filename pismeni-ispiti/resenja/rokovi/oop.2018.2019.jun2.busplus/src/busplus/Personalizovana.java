package busplus;

public class Personalizovana extends BusPlus {
    private Kategorija kategorija;
    private boolean imaDopunu;

    public Personalizovana(int id, int zona, Kategorija kategorija, boolean imaDopunu) {
        super(id, zona);
        this.kategorija = kategorija;
        this.imaDopunu = imaDopunu;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public boolean imaDopunu() {
        return imaDopunu;
    }

    @Override
    public int compareTo(BusPlus o) {
        if(o instanceof Nepersonalizovana)
            return -1;
        else {
            return this.kategorija.compareTo(((Personalizovana)o).kategorija);
        }
    }

    @Override
    public String toString() {
        return "[" + kategorija + "] " + super.toString() + " | " + (imaDopunu() ? "dopunjena" : "bez dopune");
    }
}
