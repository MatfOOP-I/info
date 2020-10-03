package posiljke;

public class Pismo extends Posiljka {
	private boolean preporuceno;
	
	public Pismo(String primalac, int brojPoste, boolean preporuceno) {
		super(primalac, brojPoste);
		this.preporuceno = preporuceno;
	}

	public boolean isPreporuceno() {
		return preporuceno;
	}

	public void setPreporuceno(boolean preporuceno) {
		this.preporuceno = preporuceno;
	}
	
	public String toString() {
		return preporuceno ? super.toString() + " P" : super.toString();
	}
}
