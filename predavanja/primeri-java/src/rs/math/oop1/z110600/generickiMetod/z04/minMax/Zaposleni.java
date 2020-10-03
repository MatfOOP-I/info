package rs.math.oop1.z110600.generickiMetod.z04.minMax;

public class Zaposleni
{
	private String ime;
	private double plata;
	
	public Zaposleni( String n, double s )
	{
		ime = n;
		plata = s;
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public double getPlata()
	{
		return plata;
	}
	
	public void povecajPlatu( double zaProcenat )
	{
		double iznosPovisice = plata * zaProcenat / 100;
		plata += iznosPovisice;
	}
	
}
