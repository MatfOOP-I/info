package torta;

public class VocnaTorta extends ReceptTorta {

	private String voce;
	
	private static int brojac;
	
	public VocnaTorta(Sastojak[] sastojci, int stepenTezine, String voce) {
		super(sastojci, stepenTezine);
		this.voce = voce;
		
		brojac++;
	}
	
	public static int getBrojac() {
		return brojac;
	}
	
	public String toString() {
		return super.toString()
				+ "\nMasa torte: " + super.ukupnaMasaTorte() + "g"
				+ "\nVoce: " + voce;
	}
	
}
