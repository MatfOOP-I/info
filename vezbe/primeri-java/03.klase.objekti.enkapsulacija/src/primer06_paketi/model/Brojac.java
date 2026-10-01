package primer06_paketi.model;
public final class Brojac {
    private int vrednost;
    public void uvecaj() { vrednost++; }
    public int getVrednost() { return vrednost; }
    // Bez modifikatora: vidljivo samo unutar ISTOG paketa.
    void resetuj() { vrednost = 0; }
}
