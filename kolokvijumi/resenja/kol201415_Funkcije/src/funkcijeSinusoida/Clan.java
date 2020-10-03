package funkcijeSinusoida;

public class Clan {

	private int a, b;

	public Clan() {}

	public Clan(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public Clan(final Clan s) {
		this(s.a, s.b);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String toString() {
		return "Clan: a=" + a + " b=" +b;
	}
}
