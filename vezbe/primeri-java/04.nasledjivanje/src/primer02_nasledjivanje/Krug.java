package primer02_nasledjivanje;

/// Krug je specijalni slucaj elipse, tako da umesto
/// da implementiramo slicnu funkcionalnost na dva mesta,
/// mozemo naslediti klasu Elipsa i iskoristiti vec
/// postojece funkcionalnosti uz sitne izmene.
public class Krug extends Elipsa {
	public Krug(Tacka c, double r) {
		// Poziva se konstruktor Elipsa(Tacka c, double a, double b)
		super(c, r, r);
	}

	public Krug(double x, double y, double r) {
		// Poziva se konstruktor Elipsa(double x, double y, double a, double b)
		super(x, y, r, r);
	}
	
	public Krug(double r) {
		// Poziva se konstruktor Elipsa(ouble a, double b)
		super(r, r);
	}

	/// Konstruktor kopije
	public Krug(Krug t) {
		// Poziva se konstruktor Pravougaonik(Tacka c, double sirina, double visina)
		super(t.centar, t.a, t.a);
	}
	
	public double getPoluprecnik() {
		return this.a;
	}

	public String toString() {
		return "Krug centar = " + centar + " r = " + a;
		// 												^ duzina poluse 1 elipse koju smo nasledili
	}
}
