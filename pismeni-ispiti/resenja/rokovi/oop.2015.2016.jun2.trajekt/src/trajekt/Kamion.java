package trajekt;

public class Kamion extends Vozilo {
	private double nosivost;

	public Kamion(double t, double n) {
		super(t);
		nosivost = n;
	}

	public char vrsta() {
		return 'K';
	}

	public double getTezina() {
		return super.getTezina() + nosivost;
	}
}
