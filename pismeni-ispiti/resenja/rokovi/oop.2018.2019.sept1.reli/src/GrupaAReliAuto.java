public class GrupaAReliAuto extends ReliAuto {

    public GrupaAReliAuto(String model, Pogon tipPogona, int godiste) {
        super(model, tipPogona, godiste > 1990 ? godiste : 1990);
    }

    @Override
    public String toString() {
        return "Grupa A: " + super.toString();
    }
}
