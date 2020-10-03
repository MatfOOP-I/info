package rs.math.oop1.z070603.konstruktori.z04.tackePreopterecenje;

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
		
		Tacka b = new Tacka();
		b.prikaziSe();
		System.out.println();
		
		double x = Math.sqrt( Math.pow( a.x - b.x, 2 ) + Math.pow( a.y - b.y, 2 ) );
		System.out.println(
				"Rastojanje od " + a.oznaka + " do " + b.oznaka + " je " + x );
		System.out.println(
				"Rastojanje od " + a.oznaka + " do " + b.oznaka + " je " + 
		    a.rastojanje( b ) );
				
	}
	
}
