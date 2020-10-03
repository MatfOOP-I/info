package tig;

public abstract class Izmena {
    private Zaglavlje zaglavlje;
    private String poruka;
    private int id;

    private static int sledeciSlobodanId = 1;

    public Izmena(Zaglavlje zaglavlje, String poruka) {
        this.zaglavlje = zaglavlje;
        this.poruka = poruka;
        this.id = sledeciSlobodanId++;
    }

    public Izmena(Zaglavlje zaglavlje, String poruka, int id) {
        this.zaglavlje = zaglavlje;
        this.poruka = poruka;
        this.id = id;
    }

    public abstract String serijalizuj();

    public static void postaviSledeciId(int id) {
        sledeciSlobodanId = id;
    }

    public Zaglavlje getZaglavlje() {
        return zaglavlje;
    }

    public String getPoruka() {
        return poruka;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return zaglavlje.toString() + " #" + id;
    }
}
