package clanarine;

public class Clan {
	private String ime; // Ime i prezime clana
	private int tezina; // Tezina u kg kao ceo broj
	private int visina; // Visina u cm
	
	// Konstruktor na osnovu datog imena, tezine i visine
	public Clan(String ime, int tezina, int visina) {
		this.ime = ime;
		this.tezina = tezina;
		this.visina = visina;
		br++; // van praga
	}
	
	// Kopi konstruktor
	public Clan(final Clan c) {
		this(c.ime, c.tezina, c.visina);
	}

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	// get i set i za druge dve clanice

	public String toString() {
		return "Ime: " + ime + "\nVisina: " + visina + "\nTezina: " + tezina;
	}
	
	// van dela za prag
	
	// Metod za racunanje indeksa telesne mase
	public double itm() {
		return (double) tezina * 10000 / Math.pow(visina, 2);
	}
		
	public String program() {
		return this.itm() > 25 ? "Kardio" : "Individualni";
	}
	
	protected static int br;
}
