package pokemoni;

public abstract class Pokemon implements Comparable<Pokemon> {
    private String ime;
    private int nivo;
    private Magija magija1;
    private Magija magija2;
    private Magija poslednjaBacena = null;
    private int zivot = 100;

    public void setPoslednjaBacena(Magija poslednjaBacena) {
        this.poslednjaBacena = poslednjaBacena;
    }

    public Magija getPoslednjaBacena() {

        return poslednjaBacena;
    }

    public Pokemon(String ime, int nivo, Magija magija1, Magija magija2) {
        this.ime = ime;
        this.nivo = nivo;
        this.magija1 = magija1;
        this.magija2 = magija2;
    }

    public void nanesiStetu(int koliko) {
        zivot -= koliko;
    }

    public String getIme() {
        return ime;
    }

    public int getNivo() {
        return nivo;
    }

    public Magija getMagija1() {
        return magija1;
    }

    public Magija getMagija2() {
        return magija2;
    }

    public int getZivot() {
        return zivot;
    }

    @Override
    public String toString() {
        return "lvl" + nivo + " " + ime;
    }

    public abstract void baciMagiju(Pokemon neprijatelj);

    @Override
    public int compareTo(Pokemon o) {
        if (this instanceof Igrac && o instanceof Neprijatelj) {
            return -1;
        } else if (this instanceof Neprijatelj && o instanceof Igrac) {
            return 1;
        } else if (this instanceof Igrac && o instanceof Igrac) {
            return Integer.compare(o.getNivo(), this.getNivo());
        } else if (this instanceof Neprijatelj && o instanceof Neprijatelj) {
            return Integer.compare(o.getNivo(), this.getNivo());
        } else {
            return Integer.compare(this.getNivo(), o.getNivo());
        }
    }
}
