package primer03Set;

public class Tacka implements Comparable<Tacka>{
	private double x, y;
	
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Tacka() {
		this(0, 0);
	}
	
	public Tacka(Tacka teme) {
		this(teme.x, teme.y);
	}

	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public int compareTo(Tacka o) {
		// Staticka funkcija compare vrsi poredjenje dva realna broja.
		if (x == o.x)
			return Double.compare(y, o.y);
		return Double.compare(x, o.x);
	}
}
