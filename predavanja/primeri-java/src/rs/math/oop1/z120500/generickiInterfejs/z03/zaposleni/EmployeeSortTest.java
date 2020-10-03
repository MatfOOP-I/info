package rs.math.oop1.z120500.generickiInterfejs.z03.zaposleni;

import java.util.Arrays;

public class EmployeeSortTest
{
	public static void main( String[] args )
	{
		Zaposleni[] osoblje = new Zaposleni[4];
		
		osoblje[0] = new Zaposleni( "Marko Markovic", 85000 );
		osoblje[1] = new Zaposleni( "Janko Jankovic", 45000 );
		osoblje[2] = new Zaposleni( "Tony Tester", 20000 );
		osoblje[3] = new Zaposleni( "Mickey Mouse", 45000 );
		
		System.out.println( "Before sort" );
		for (Zaposleni e : osoblje)
			System.out.println( e );
		
		Arrays.sort( osoblje );
		
		// print out information about all Zaposleni objects
		System.out.println( "===================================" );
		System.out.println( "After sort" );
		for (Zaposleni e : osoblje)
			System.out.println( e );
	}
}

class Zaposleni implements Comparable<Zaposleni>
{
	private String imePrezime;
	private double plata;
	
	public Zaposleni( String n, double s )
	{
		imePrezime = n;
		plata = s;
	}
	
	public String getImePrezime()
	{
		return imePrezime;
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
	public String toString() {
		return "Zaposleni: imePrezime=" + imePrezime + ",plata=" + plata;
	}

	@Override
	public boolean equals(Object o)
	{
		if( o == null )
			return false;
		if( getClass() != o.getClass())
			return false;
		Zaposleni e = (Zaposleni) o;
		return imePrezime.equals(e.imePrezime) && plata==e.plata;
	}

	@Override
	public int hashCode()
	{
		return 3 * imePrezime.hashCode() + 7 * new Double(plata).hashCode();
	}

	@Override
	public int compareTo( Zaposleni e )
	{
		if (plata > e.plata)
			return -1;
		if (plata < e.plata)
			return 1;
		return imePrezime.compareTo( e.imePrezime);
	}
}
