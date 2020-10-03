package rs.math.oop1.z090102.statickeUgnjezdene.z02zaposleniSortiranje;

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
	
	@Override
	public String toString()
	{
		return "ime=" + getIme() + ",plata=" + getPlata();
	}
	
	@Override
	public int compareTo(Object o)	
	{
		if( ! (o instanceof Zaposleni) )
			return -1;
		Zaposleni e = (Zaposleni) o;
		if( plata - e.getPlata() != 0)
			return -(int)(plata - e.getPlata());
		return ime.compareTo( e.getIme() );
	}
}
