package busplus;

public abstract class BusPlus implements Comparable<BusPlus>{
    private int id;
    private int zona; // 1 ili 2

    public BusPlus(int id, int zona) {
        this.id = id;
        this.zona = zona;
    }

    public int getId() { return id; }
    public int getZona() { return zona; }

    @Override
    public String toString() {
        return "zona: " + zona;
    }
}
