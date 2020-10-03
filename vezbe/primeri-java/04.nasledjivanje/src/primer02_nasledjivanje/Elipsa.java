package primer02_nasledjivanje;

public class Elipsa extends Oblik {
	// Polja oznacavamo kao protected kako bi im mogli
	// DIREKTNO pristupiti iz podklase (klase Krug).
	protected double /* poluosa 1 */ a, /* poluosa 2 */ b;

	public Elipsa(Tacka centar, double a, double b) {
		// Potrebno je da pozovemo konstruktor nadklase (UVEK PRI NASLEDJIVANJU)
		// tako sto koristimo sintaksu slicnu this(...) osim sto koristimo super.
		// Super je u stvari referenca na nadklasu (u ovom slucaju Oblik).
		
		// Poziva konstruktor Oblik(Tacka c)
		super(centar);
		
		// Koristimo privatnu funkciju 'init' koja inicijalizuje poluose elipse
		// kako bi smanjili visestruko ponavljanje iste logike.
		init(a, b);
	}

	public Elipsa(double x, double y, double a, double b) {
		// Poziva konstruktor Oblik(double x, double y)
		super(x, y);
		init(a, b);
	}

	public Elipsa(double a, double b) {
		// Poziva konstruktor Oblik()
		super();
		init(a, b);
	}

	/// Konstruktor kopije
	public Elipsa(Elipsa p) {
		// Poziva konstruktor Oblik(Tacka c)
		super(p.centar);
		init(p.a, p.b);
	}

	private void init(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public String toString() {
		return "Elipsa a = " + a + " b = " + b;
	}
}