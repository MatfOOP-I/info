package rs.math.oop1.z150704.noviKolekcijskiTipovi.z02.redPrekoKruznogNiza;

import java.util.Queue;

public class PokretanjeRed
{
	
	public static void main( String[] args )
	{
		Queue<String> q = new RedPrekoKruznogNiza<>(40);
		q.add( "Amy" );
		q.add( "Bob" );
		q.add( "Carl" );
		q.add( "Deedee" );
		q.add( "Emile" );
		q.add( "Filip" );
		for( String s : q )
			System.out.print( s + " " );
		System.out.println();
		
		System.out.println( "Uklonjena glava" );
		q.remove();
		System.out.println( q );
		System.out.println();
		
		q.add( "George" );
		System.out.println( "Na rep dodat 'George'" );
		System.out.println( q );
		System.out.println();
		
		System.out.println( "Velicina reda: " + q.size() );
	}
}
