package primer01Geometrija;

// Klasa je apstraktna ako poseduje barem jednu
// apstraktnu funkciju. Apstraktne klase ne mozemo
// da instanciramo.
public abstract class Oblik {
	private Tacka centar;

	public Oblik(Tacka centar) {
		this.centar = new Tacka(centar);
	}

	// Ako nam korisnik ne prosledi argumente pri pozivu konstruktora,
	// centar oblika postavljamo na podrazumevanu vrednost (u ovom slucaju (0, 0))
	public Oblik() {
		centar = new Tacka();
	}

	public Tacka getCentar() {
		return centar;
	}

	// Apstraktne funckije samo deklarisemo, a podklasa
	// treba da implementira njihovu logiku.
	// U klasi oblik ne znamo kako bi implementirali sledece dve funkcije
	// 	jer nam nije poznato koji je oblik u pitanju.
	public abstract double getObim();
	public abstract double getPovrsina();

	public String toString() {
		return "Oblik{centar = " + centar + "}";
	}
}
