package primer03IzrazKloniranje;

public class Sabiranje extends BinarnaOperacija {
	
	public Sabiranje(Izraz levi, Izraz desni) {
		super(levi, /*NMDD*/ desni);
	}
	
	public Sabiranje(Sabiranje s) {
		// Ne vrsimo kloniranje operanada sabiranje vec
		// reference prosledjujemo nadklasi.
		// Klasa BinarnaOperacija
		// ciji konstruktor pozivamo, poziva kloniranje prosledjenih izraza.
		super(s.getLevi(), s.getDesni());
	}

	@Override
	public Izraz klon() {
		return new Sabiranje(this);
	}
	
	@Override
	public double izracunaj() {
		return getLevi().izracunaj() + getDesni().izracunaj();
	}
	
	@Override
	public String toString() {
		return getLevi().toString() + " + " + getDesni().toString();
	}
}
