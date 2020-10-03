package posiljke;

public class Ekspres extends Posiljka {
	private EkspresUsluga tip;
	
	public Ekspres(String primalac, int brojPoste, EkspresUsluga tip) {
		super(primalac, brojPoste);
		this.tip = tip;
	}
	
	public EkspresUsluga getTip() {
		return tip;
	}
	
	public String toString() {
		return super.toString() + " " + tip;
	}
}
