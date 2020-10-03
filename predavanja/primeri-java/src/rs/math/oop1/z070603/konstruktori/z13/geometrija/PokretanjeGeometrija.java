package rs.math.oop1.z070603.konstruktori.z13.geometrija;

public class PokretanjeGeometrija
{
	
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		Tacka a = new Tacka( 2, 3, "A" );
		System.out.println( a );
		Tacka b = new Tacka( 10, 4, "B" );
		System.out.println( b );
		System.out.println();
		
		System.out.print( "Rastojanje od " );
		System.out.println( a + "  do " + b + " je " + a.rastojanje( b ) );
		
		// Duz ab = new Duz( "AB", a, b );
		// System.out.println( ab );
		// System.out.println();
		
		//  Tacka c = new Tacka(12,12,"C"); c.prikaziSe(); System.out.println();
		 
		// Tacka d = new Tacka(16,15,"D"); d.prikaziSe(); System.out.println();
		
		// Trougao t1 = new Trougao("t1", a,b,c); t1.prikaziSe();
		// System.out.println();
		
		// Trougao t2 = new Trougao("t1", a,c, d); t2.prikaziSe();
		// System.out.println();
		
		// Cetvorougao c1 = new Cetvorougao("c1", a,b,c, d); c1.prikaziSe();
		// System.out.println();
	}
}
