package v15.v02Banka;
class Transakcija
{
	// Transaction types
	public static final int PODIGNI = 0;
	public static final int ULOZI = 1;
	public static String[] tipovi = { "Podigni", "Ulozi" };

	private Racun racun;
	private int iznos;
	private int tipTransakcije;

	// Constructor
	public Transakcija(Racun racun, int tipTransakcije, int iznos)
	{
		this.racun = racun;
		this.tipTransakcije = tipTransakcije;
		this.iznos = iznos;
	}

	public Racun getRacun()
	{
		return racun;
	}

	public int getTipTransakcije()
	{
		return tipTransakcije;
	}

	public int getIznos()
	{
		return iznos;
	}

	public String toString()
	{
		return "Transakcija nad racunom:" + racun 
			+ " " + tipovi[tipTransakcije] 
			+ ", svota: " + iznos;
	}

}
