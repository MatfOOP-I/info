package rs.math.oop1.z150000.koriscenjeKolekcije.z01.nizovnaLista;

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
	
	@Override
	public String toString()
	{
		return "(" + ime + ":" + hireDay + ":" + plata + ")";
	}
	
	@Override 
	public int hashCode()
	{
		return 3 * ime.hashCode()+ 5 * hireDay.hashCode()
				+ 7 *  new Double( plata).hashCode();
	}
}

public class ArrayListTest
{
	
	public static void main( String[] args )
	{
		Collection c;
	    // fill the osoblje array list with three Zaposleni objects
		Collection<Zaposleni> osoblje = new ArrayList<Zaposleni>();

		osoblje.add( new Zaposleni( "Janko Jankovic", 75000, 1987, 12, 15 ) );
		osoblje.add( new Zaposleni( "Marko Markovic", 50000, 1989, 10, 1 ) );
		osoblje.add( new Zaposleni( "Tony Tester", 40000, 1990, 3, 15 ) );
		
		// iznosPovisice everyone's plata by 5%
		for (Zaposleni e : osoblje)
			e.povecajPlatu( 5 );
		
		// print out information about all Zaposleni objects
//		for (Zaposleni e : osoblje)
//			System.out.println( "ime=" + e.getIme() + ",plata=" + e.getPlata()
//					+ ",hireDay=" + e.getHireDay() );
		
		System.out.println(osoblje);
    
//		ArrayList<Integer> a = new ArrayList<>();
//		for( int i=0; i <1_000; i++)
//			a.add( (i+1)*2 );
//		System.out.println(a);

	}
	
}
