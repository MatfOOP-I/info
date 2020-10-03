package rs.math.oop1.z080401.polimorfizam.z03.ljudiApstraktno;

public abstract class Covek {
    private String ime;
    private String prezime;


    public Covek(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public Covek() {
        this("N", "N");
    }

    public Covek(final Covek c) {
        this(c.ime, c.prezime);
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public abstract String opis();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Covek))
            return false;
        Covek c = (Covek) o;
        return c.ime.equals(ime) && c.prezime.equals(prezime);
    }

    @Override
    public int hashCode() {
        return ime.hashCode() ^ prezime.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + ":" + ime + " " + prezime;
    }


}