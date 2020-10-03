package predikcija;

public class Osoba {
	private String ime;
	private double tezina;
	private char pol;
	
	public Osoba(String ime, double tezina, char pol) {
		this.ime = ime;
		this.tezina = tezina;
		this.pol = pol;
	}
	
	public Osoba(Osoba o) {
		this(o.ime, o.tezina, o.pol);
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public char getPol() {
		return pol;
	}

	public void setPol(char pol) {
		this.pol = pol;
	}
	
	public double getTezina() {
		return tezina;
	}
	
	public void setTezina(int tezina) {
		this.tezina = tezina;
	}
	
	@Override
	public String toString() {
		return ime + " pol: " + pol + " tezina: " + tezina + "kg";
	}
}
