package rs.math.oop1.z070603.konstruktori.z09.duziVezani;

public class PokretanjeGeometrija
{
	
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		Tacka ta = new Tacka( 2, 3, "A" );
		ta.prikaziSe();
		System.out.println();
		
		Tacka tb = new Tacka( 10, 4, "B" );
		tb.prikaziSe();
		System.out.println();
		
		System.out.println( "Rastojanje od " + ta.oznaka + " do " + tb.oznaka + " je "
				+ ta.rastojanje( tb ) );
				
		Duz ab = new Duz( "AB", ta, tb );
		ab.prikaziSe();
		System.out.println();
		System.out.println( "Duzina duzi " + ab.oznaka + " je " + ab.duzina() );
		System.out.println();
		
//		a.setY( 1000 );
//		ab.prikaziSe();
//		System.out.println();
		
		ab.a.setY( -1000 );
		ta.prikaziSe();
	}
	
}
