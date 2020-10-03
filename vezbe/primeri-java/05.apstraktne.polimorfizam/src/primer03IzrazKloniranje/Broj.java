package primer03IzrazKloniranje;

public class Broj extends Izraz {
	private double vrednost;
	
	public Broj(double vrednost) {
		this.vrednost = vrednost;
	}
	
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// KONSTRUKTOR KOPIJE
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	public Broj(Broj b) {
		this.vrednost = b.vrednost;
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	@Override
	public Izraz klon() {
		// Mozemo iskoristiti konstruktor kopije za klasu kako
		// bi izbegli ponavljanje logike.
		return new Broj(this);
	}
	
	public double getVrednost() {
		return vrednost;
	}
	
	@Override
	public double izracunaj() {
		return vrednost;
	}
	
	@Override
	public String toString() {
		return "" + vrednost;
	}
}





