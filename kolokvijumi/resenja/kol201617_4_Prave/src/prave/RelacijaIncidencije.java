package prave;

public abstract class RelacijaIncidencije {
	private Prava p;
	
	public RelacijaIncidencije(final Prava p) {
		this.p = new Prava(p);
	}
	
	public Prava getPrava() {
		return p;
	}
	
	public abstract boolean odnos();
	public abstract double izracunaj();
	
	public String toString() {
		return "p: " + p;
	}
}
