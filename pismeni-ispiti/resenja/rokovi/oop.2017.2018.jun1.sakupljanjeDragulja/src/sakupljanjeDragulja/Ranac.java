package sakupljanjeDragulja;

public class Ranac {
    private double maxTezina;
    private double slobodnoTezine;

    public Ranac(double maxTezina) {
        this.maxTezina = maxTezina;
        this.slobodnoTezine = maxTezina;
    }

    public double getSlobodnoTezine() {
        return slobodnoTezine;
    }

    public boolean smestiDragulj(double tezina) {
        if (slobodnoTezine >= tezina) {
            slobodnoTezine -= tezina;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ranac: "+slobodnoTezine+"("+maxTezina+")";
    }
}
