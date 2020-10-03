package posiljke;

public class Paket extends Posiljka {
	private String sadrzaj;
	
	public Paket(String primalac, int brojPoste, String sadrzaj) {
		super(primalac, brojPoste);
		this.sadrzaj = sadrzaj;
	}
	
	public String getSadrzaj() {
		return sadrzaj;
	}
	
	public String toString() {
		return super.toString() + " " + sadrzaj;
	}
}
