package pregled;

public abstract class Pacijent implements Comparable<Pacijent> {

	private double T;
	private double V;
	private int G;
	private FizickaAktivnost PA;
	
	public Pacijent(double T, double V, int G, FizickaAktivnost PA) {
		this.T = T;
		this.V = V;
		this.G = G;
		this.PA = PA;
	}
	
	public double getT() {
		return T;
	}
	public double getV() {
		return V;
	}
	public int getG() {
		return G;
	}
	public FizickaAktivnost getPA() {
		return PA;
	}	
	
	public abstract String pol();	
	public abstract double preporuceniDnevniUnosKalorija();
	
	/* compareTo - prvi nacin, sazeto */
	@Override
	public int compareTo(Pacijent o) {
		int rez = Integer.compare(this.G, o.G);
		return rez == 0 ? 
				Double.compare(this.preporuceniDnevniUnosKalorija(), o.preporuceniDnevniUnosKalorija())
				: rez;
	}

	/* compareTo() - drugi nacin */
//	public int compareTo(Pacijent o) {
//		if(this.G < o.G)
//			return -1;
//		else if(this.G > o.G)
//			return 1;
//		else {
//			if(this.preporuceniDnevniUnosKalorija() < o.preporuceniDnevniUnosKalorija())
//				return -1;
//			else if(this.preporuceniDnevniUnosKalorija() < o.preporuceniDnevniUnosKalorija())
//				return 1;	
//			else
//				return 0;
//		}
//	}
	
	@Override
	public String toString() {
		return "masa: " + T + "kg, visina: " + V + "cm, starost: " + G + " god\nnivo aktivnosti: " 
	    + PA + ", preporuceni dnevni unos kalorija: " + preporuceniDnevniUnosKalorija() 
	    + "\n-----------------------------------------------------"; 
	}
}
