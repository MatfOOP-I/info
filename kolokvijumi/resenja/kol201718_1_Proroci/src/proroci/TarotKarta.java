package proroci;

public class TarotKarta {
    private int vreme;
    private String opis, poreklo;

    public TarotKarta(int vreme, String opis, String poreklo) {
        this.vreme = (vreme != 0 && vreme != -1 && vreme != 1) ? 0 : vreme;
        this.opis = opis;
        this.poreklo = poreklo;
    }

    public TarotKarta(final TarotKarta tk) {
        this(tk.vreme, tk.opis, tk.poreklo);
    }

    public int getVreme() {
        return vreme;
    }

    public String getOpis() {
        return opis;
    }

    public String getPoreklo() {
        return poreklo;
    }

    @Override
    public String toString() {
        String vremeStr = "";
        if (vreme == 0) vremeStr = "sadasnjost";
        if (vreme == -1) vremeStr = "proslost";
        if (vreme == 1) vremeStr = "buducnost";
        return "[tarot karta] vreme: " + vremeStr + " opis: " + opis;
    }
}
