public class GrupaBReliAuto extends ReliAuto {
    private boolean superCharger;

    public GrupaBReliAuto(String model, Pogon tipPogona, int godiste, boolean superCharger) {
        super(model, tipPogona, godiste);
        this.superCharger = superCharger;
    }

    @Override
    public String toString() {
        return "Grupa B: " + super.toString() + (this.superCharger ? " [S]" : "");
    }
}
