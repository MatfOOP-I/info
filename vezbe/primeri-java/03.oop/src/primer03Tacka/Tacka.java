package primer03Tacka;

public class Tacka {
	private double x, y;
	
	// Konstruktor bez argumenata nazivamo "PODRAZUMEVANI KONSTRUKTOR".
	// Pozivali bi ga sa: Tacka t = new Tacka();
	public Tacka() {
		this.x = 0;
		this.y = 0;
	}
	
	// Standardan konstruktor za tacku, pozivamo sa:
	// Tacka t = new Tacka(2, 5);
	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	// Pravimo funkciju koja poredi tacke.
	// Primetimo da ova funkcija poredi objekte 'this' i 't' koji tu tacke.
	// Funkcija je jako slicna onoj koju poseduje klasa String.
	public boolean equals(Tacka t) {
		return this.x == t.x && this.y == t.y;
	}
	
	// Tacku mozemo da transliramo za neki pomeraj (dx, dy)
	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}
	
	public double distance(Tacka t) {
		// Smemo pristupiti privatnim clanovima tacke 't' jer smo unutar klase
		// Primetimo da racunamo rastojanje izmedju objekata 'this' i 't'
		return Math.sqrt((this.x-t.x)*(this.x-t.x) + (y - t.y)*(y - t.y));
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

