package softverskaMreza;

public class Softver {
	private String ime, programskiJezik;
	private int brojLinija;
	
	public Softver(String ime, String programskiJezik, int brojLinija) {
		super();
		this.ime = ime;
		this.programskiJezik = programskiJezik;
		this.brojLinija = brojLinija;
	}

	public String getIme() {
		return ime;
	}

	public String getProgramskiJezik() {
		return programskiJezik;
	}

	public int getBrojLinija() {
		return brojLinija;
	}

	@Override
	public String toString() {
		return "ime: " + ime + " jezik: "
				+ programskiJezik + " broj linija: "
				+ brojLinija;
	}
	
}
