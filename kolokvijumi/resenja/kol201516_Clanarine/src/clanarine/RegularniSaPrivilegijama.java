package clanarine;

public class RegularniSaPrivilegijama extends Regularni {
	private double popust;
	private static int brRP;

	public RegularniSaPrivilegijama(String ime, int tezina, 
			int visina, String kategorija, double popust) {
		super(ime, tezina, visina, kategorija);
		this.popust = popust;
		brRP++;
	}

	public String toString() {
		return "\n" + super.toString() + "\nKoef: " + popust + 
				"\nPovlascena clanarina: " + clanarinaPrivilegovanog();
	}

	public static int getBrRP() {
		return brRP;
	}
	
	public double clanarinaPrivilegovanog() {
		return super.clanarinaRegularnog() * (1-popust/100);
	}
}
