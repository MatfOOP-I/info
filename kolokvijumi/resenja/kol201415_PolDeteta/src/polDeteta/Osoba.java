package polDeteta;

public abstract class Osoba {
	
	private String ime_prezime;
	private char pol;
	
	public Osoba(String ime, char pol) {
		ime_prezime=ime;
		this.pol=pol;
	}
	public String getImePrezime() {
		return ime_prezime;
	}
	public void setImePrezime(String ime){
		ime_prezime=ime;
	}
	
	public abstract int brojGodinaOsobe(Datum danasnji_datum);
	
	public String toString() {
		return "ime: " + ime_prezime + "\npol: " + pol;
	}
}
