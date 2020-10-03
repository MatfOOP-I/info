package rs.math.oop1.z080100.apstraktneKlase.z05.petShop;

public abstract class ZivotinjskaVrsta
{
	private String ime;
	
	private String klasifikacijaLine;
	
	private double ocekivanaStarostGod;

	public ZivotinjskaVrsta( String ime, String klasifikacijaLine, double ocekivanaStarostGod)
	{
		this.ime = ime;
		this.klasifikacijaLine = klasifikacijaLine;
		this.ocekivanaStarostGod = ocekivanaStarostGod;
	}
	
	public String getIme()
	{
		return ime;
	}

	public void setIme( String ime )
	{
		this.ime = ime;
	}

	public String getKlasifikacijaLine()
	{
		return klasifikacijaLine;
	}

	public void setKlasifikacijaLine( String klasifikacijaLine )
	{
		this.klasifikacijaLine = klasifikacijaLine;
	}

	public double getOcekivanaStarostGod()
	{
		return ocekivanaStarostGod;
	}

	public void setOcekivanaStarostGod( double ocekivanaStarostGod )
	{
		this.ocekivanaStarostGod = ocekivanaStarostGod;
	}
	
	public abstract int brojNogu();
	
	public abstract int naciniKretanja();
	
	@Override
	public String toString()
	{
		return "Zivotinjska vrsta: " + ime + " (" + klasifikacijaLine + ") " 
				+ "zivi do: " + ocekivanaStarostGod;
	}
}
