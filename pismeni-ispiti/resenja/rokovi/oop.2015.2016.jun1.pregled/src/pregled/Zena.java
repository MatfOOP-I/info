package pregled;

public class Zena extends Pacijent {
	
	public Zena(double T, double V, int G, FizickaAktivnost PA) {
		super(T, V, G, PA);
	}

	@Override
	public String pol() {
		return "pacijentkinja";
	}

	@Override
	public double preporuceniDnevniUnosKalorija() {
		return 354 - 6.91 * getG() + 1.2 * (9.36 * getT() + 726 * getV()); 
	}
	
	@Override
	public String toString() {
		return "[" + pol() + "] " + super.toString();
	}

}
