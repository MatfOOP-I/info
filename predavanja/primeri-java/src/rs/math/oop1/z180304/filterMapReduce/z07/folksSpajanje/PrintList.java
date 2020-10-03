
package rs.math.oop1.z180304.filterMapReduce.z07.folksSpajanje;

import static java.util.stream.Collectors.joining;

public class PrintList
{
	public static void main( final String[] args )
	{
		System.out.println( "//" + "START:FOREACH_OUTPUT" );
		for( String ime : Folks.friends )
		{
			System.out.print( ime + ", " );
		}
		System.out.println();
		System.out.println( "//" + "END:FOREACH_OUTPUT" );
		
		System.out.println( "//" + "START:FOR_OUTPUT" );
		for(int i = 0; i < Folks.friends.size() - 1; i++ )
		{
			System.out.print( Folks.friends.get( i ) + ", " );
		}
		
		if( Folks.friends.size() > 0 )
			System.out.println( Folks.friends.get( Folks.friends.size() - 1 ) );
		System.out.println( "//" + "END:FOR_OUTPUT" );
		
		System.out.println( "//" + "START:JOIN_OUTPUT" );
		System.out.println( String.join( ", ", Folks.friends ) );
		System.out.println( "//" + "END:JOIN_OUTPUT" );
		
		System.out.println( "//" + "START:MAP_JOIN_OUTPUT" );
		System.out.println( Folks.friends.stream().map( String::toUpperCase )
				.collect( joining( ", " ) ) );
		System.out.println( "//" + "END:MAP_JOIN_OUTPUT" );
		
	}
}
