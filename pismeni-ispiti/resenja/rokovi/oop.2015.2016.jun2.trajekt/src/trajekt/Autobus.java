package trajekt;

public class Autobus extends Vozilo {
	private int kapacitet;

	public Autobus(double t, int n) {
		super(t);
		kapacitet = n;
	}

	public char vrsta() {
		return 'A';
	}

	public double getTezina() {
		return super.getTezina() + kapacitet * 110;
	}

}
