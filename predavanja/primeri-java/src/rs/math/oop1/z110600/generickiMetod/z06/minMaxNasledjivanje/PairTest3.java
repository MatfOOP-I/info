package rs.math.oop1.z110600.generickiMetod.z06.minMaxNasledjivanje;

import java.util.*;

class Zaposleni
{
	private String ime;
	private double plata;
	private Date hireDay;

	public Zaposleni( String n, double s, int godina, int mesec, int dan )
	{
		ime = n;
		plata = s;
		GregorianCalendar calendar = new GregorianCalendar( godina, mesec - 1, dan );
		hireDay = calendar.getTime();
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public double getPlata()
	{
		return plata;
	}
	
	public Date getHireDay()
	{
		return hireDay;
	}
	
	public void povecajPlatu( double zaProcenat )
	{
		double iznosPovisice = plata * zaProcenat / 100;
		plata += iznosPovisice;
	}
}

class Manager extends Zaposleni
{
	private double bonus;

	public Manager( String n, double s, int godina, int mesec, int dan )
	{
		super( n, s, godina, mesec, dan );
		bonus = 0;
	}
	
	@Override
	public double getPlata()
	{
		double baseSalary = super.getPlata();
		return baseSalary + bonus;
	}
	
	public void setBonus( double b )
	{
		bonus = b;
	}
	
	public double getBonus()
	{
		return bonus;
	}
	
}

class PairAlg
{
	public static boolean hasNulls( Pair<?> p )
	{
		return p.getFirst() == null || p.getSecond() == null;
	}
	
	public static void swap( Pair<?> p )
	{
		swapHelper( p );
	}
	
	public static <T> void swapHelper( Pair<T> p )
	{
		T t = p.getFirst();
		p.setFirst( p.getSecond() );
		p.setSecond( t );
	}
}


public class PairTest3
{
	public static void printBuddies( Pair<? extends Zaposleni> p )
	{
		Zaposleni first = p.getFirst();
		Zaposleni second = p.getSecond();
		System.out.println( first.getIme() + " i " + second.getIme()
				+ " su drugari." );
	}
	
	public static void minmaxBonus( 
			Manager[] a, Pair<? super Manager> result )
	{
		if (a == null || a.length == 0)
			return;
		Manager min = a[0];
		Manager max = a[0];
		for (int i = 1; i < a.length; i++)
		{
			if (min.getBonus() > a[i].getBonus())
				min = a[i];
			if (max.getBonus() < a[i].getBonus())
				max = a[i];
		}
		result.setFirst( min );
		result.setSecond( max );
	}
	
	public static void maxminBonus( Manager[] a, Pair<? super Manager> result )
	{
		minmaxBonus( a, result );
		PairAlg.swapHelper( result ); // OK--swapHelper captures wildcard type
	}

	public static void main( String[] args )
	{
		Manager ceo = new Manager( 
				"Gus Greedy", 800_000, 2003, 12, 15 );
		Manager cfo = new Manager( 
				"Sid Sneaky", 600_000, 2003, 12, 15 );
		Manager vlasnikovSin = new Manager( 
				"Tatin sin", 800_000, 2012, 1, 12 );
		Pair<Manager> buddies = new Pair<Manager>( ceo, cfo );
		printBuddies( buddies );
		
		ceo.setBonus( 1_000_000 );
		cfo.setBonus( 1_500_000 );
		vlasnikovSin.setBonus( 450_000 );
		Manager[] managers = { ceo, cfo, vlasnikovSin };
		
		Pair<Zaposleni> result = new Pair<>();
		minmaxBonus( managers, result );
		System.out.println( "first: " + result.getFirst().getIme() + ", second: "
				+ result.getSecond().getIme() );
		maxminBonus( managers, result );
		System.out.println( "first: " + result.getFirst().getIme() + ", second: "
				+ result.getSecond().getIme() );
	}
	
}


