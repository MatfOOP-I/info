package poruke;

public abstract class Sifrar {

	private Poruka poruka;
	
	public Sifrar(final Poruka p) {
		poruka = new Poruka(p);
	}
	
	public Poruka getPoruka() {
		return poruka;
	}
	
	public void setPoruka(final Poruka p) {
		poruka = new Poruka(p);
	}
	
	public abstract Poruka sifruj();
	
	public abstract String toString();
	
	// ili:
	/*
	public String toString() {
		return poruka.toString();
		// return poruka + "";
	}
	*/
}
