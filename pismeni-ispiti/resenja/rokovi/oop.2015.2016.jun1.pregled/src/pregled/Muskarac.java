package pregled;

public class Muskarac extends Pacijent {
	
	public Muskarac(double T, double V, int G, FizickaAktivnost PA) {
		super(T, V, G, PA);
	}

	@Override
	public String pol() {
		return "pacijent";
	}

	@Override
	public double preporuceniDnevniUnosKalorija() {
		return 662 - 9.53 * getG() + 1.4 * (15.91 * getT() + 539.6 * getV()); 
	}
	
	@Override
	public String toString() {
		return "[" + pol() + "] " + super.toString();
	}

}
