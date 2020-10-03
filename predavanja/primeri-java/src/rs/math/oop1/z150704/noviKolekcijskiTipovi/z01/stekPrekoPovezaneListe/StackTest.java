package rs.math.oop1.z150704.noviKolekcijskiTipovi.z01.stekPrekoPovezaneListe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StackTest
{
	
	public static void main( String[] args )
	{
		Set<String> q = new HashSet<String>();
		q.add( "Amy" );
		q.add( "Bob" );
		q.add( "Carl" );
		q.add( "Deedee" );
		q.add( "Emile" );
		q.add( "Filip" );
		//System.out.println( q );
		
		Stack<String> noviStek = new StekPrekoPovezaneListe<>(q);
		for( String s : noviStek )
			System.out.print( s + " " );
		System.out.println("----");
		
		System.out.print( "Provirio: " );
		System.out.println( noviStek.peek() );
		System.out.println();
		
		noviStek.push( "George" );
		System.out.println( "u stek dodat 'George'" );
		System.out.println( noviStek );
		System.out.println();
		
		System.out.println( "Velicina steka: " + noviStek.size() );
		System.out.println();
		
		List<String> al = new ArrayList<>(noviStek);
		System.out.println( al );
		
	}
}
