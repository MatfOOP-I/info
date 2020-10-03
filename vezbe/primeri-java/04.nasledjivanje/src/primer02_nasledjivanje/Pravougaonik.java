package primer02_nasledjivanje;

public class Pravougaonik extends Oblik {
	// Polja oznacavamo kao protected kako bi im mogli
	// DIREKTNO pristupiti iz podklase (klase Kvadrat).
	protected double sirina, visina;

	public Pravougaonik(Tacka centar, double sirina, double visina) {
		// Potrebno je da pozovemo konstruktor nadklase (UVEK PRI NASLEDJIVANJU)
		// tako sto koristimo sintaksu slicnu this(...) osim sto koristimo super.
		// Super je u stvari referenca na nadklasu (u ovom slucaju Oblik).
		
		// Poziva konstruktor Oblik(Tacka c)
		super(centar);
		
		// Koristimo privatnu funkciju 'init' koja inicijalizuje sirinu i visinu
		// kako bi smanjili visestruko ponavljanje iste logike.
		init(sirina, visina);
	}

	public Pravougaonik(double x, double y, double sirina, double visina) {
		// Poziva konstruktor Oblik(double x, double y)
		super(x, y);
		init(sirina, visina);
	}

	public Pravougaonik(double sirina, double visina) {
		// Poziva konstruktor Oblik()
		super();
		init(sirina, visina);
	}

	/// Konstruktor kopije
	public Pravougaonik(Pravougaonik p) {
		// Poziva konstruktor Oblik(Tacka c)
		super(p.centar);
		init(p.sirina, p.visina);
	}

	private void init(double sirina, double visina) {
		this.visina = visina;
		this.sirina = sirina;
	}

	public double getSirina() {
		return sirina;
	}

	public double getVisina() {
		return visina;
	}

	public String toString() {
		return "Pravougaonik sirina = " + sirina + " visina = " + visina;
	}
}
