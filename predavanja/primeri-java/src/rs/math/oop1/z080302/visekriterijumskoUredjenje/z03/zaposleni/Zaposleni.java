package rs.math.oop1.z080302.visekriterijumskoUredjenje.z03.zaposleni;


public class Zaposleni implements Comparable
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
	
	public int compareTo( Object o )
	{
		if (!(o instanceof Zaposleni))
			return -1;
		Zaposleni drugi = (Zaposleni) o;
		if (plata < drugi.plata)
			return 1;
		if (plata > drugi.plata)
			return -1;
		return 0;
	}
	
}
