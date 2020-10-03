package rs.math.oop1.z140500.ispitivanjeZabeleski.z02.geometrija;

import java.util.Arrays;

public class GeometrijaTest2
{
	
	/**
	 * @param args
	 */
	public static void main ( String[] args )
	{
		Tacka a = new Tacka(200, 30, "F");
		
		Tacka b = new Tacka(100, 40, "B");
				
		Tacka c = new Tacka(800, 120, "C");
		
		Tacka d = new Tacka(160, 150, "D");
		
		Tacka[] niz = { a, b, c, d };
		System.out.println("\n Pre sortiranja ");
		for (Tacka t : niz)
			System.out.print( t );

		System.out.println("\n Po oznaci ");
		Arrays.sort(  niz, new TackaOznakaComparator() );
		for (Tacka t : niz)
			System.out.print( t );

		System.out.println("\n Po poziciji ");
		Arrays.sort(  niz, new TackaPozicijaComparator() );
		for (Tacka t : niz)
			System.out.print( t );

	}
	
}
