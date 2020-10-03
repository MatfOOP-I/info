package rs.math.oop1.z150704.noviKolekcijskiTipovi.z01.stekPrekoPovezaneListe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StackTest2
{
	
	public static void main( String[] args )
	{
		Collection<String> stek = new StekPrekoPovezaneListe<String>();
		stek.add( "Amy" );
		stek.add( "Bob" );
		stek.add( "Carl" );
		stek.add( "Deedee" );
		stek.add( "Emile" );
		stek.add( "Filip" );
		System.out.println( stek );
		
		for( String s : stek )
			System.out.print( s + " " );
		System.out.println("----");
		
		System.out.print( "Provirio: " );
		System.out.println( ((Stack<String>)stek).peek() );
		System.out.println();

		((Stack<String>)stek).push( "George" );
		System.out.println( "u stek dodat 'George'" );
		System.out.println( stek );
		System.out.println();
		
		System.out.println( "Velicina steka: " + stek.size() );
		System.out.println();
		
		List<String> al = new ArrayList<>(stek);
		System.out.println( al );
		
	}
}
