public abstract class ReliAuto {
    private String model;
    private Pogon tipPogona;
    private int godiste;

    protected ReliAuto(String model, Pogon tipPogona, int godiste) {
        this.model = model;
        this.tipPogona = tipPogona;
        this.godiste = godiste;
    }

    @Override
    public String toString() {
        return this.model + " ("+ this.godiste + ") | " + this.tipPogona ;
    }

    public Pogon getTipPogona() {
        return tipPogona;
    }

    public int getGodiste() {
        return godiste;
    }
}
