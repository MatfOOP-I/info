package rs.math.oop1.z070603.konstruktori.z11.duziKopirajuci;

public class PokretanjeGeometrija
{
	
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		Tacka a = new Tacka( 2, 3, "A" );
		a.prikaziSe();
		System.out.println();
		
		Tacka b = new Tacka( 10, 4, "B" );
		b.prikaziSe();
		System.out.println();
		
		System.out.println( "Rastojanje od " + a.oznaka + " do " + b.oznaka + " je "
				+ a.rastojanje( b ) );
				
		Duz ab = new Duz( "AB", a, b );
		ab.prikaziSe();
		System.out.println();
		
		a.setY( 1000 );
		ab.prikaziSe();
		System.out.println();
		
	}
	
}
