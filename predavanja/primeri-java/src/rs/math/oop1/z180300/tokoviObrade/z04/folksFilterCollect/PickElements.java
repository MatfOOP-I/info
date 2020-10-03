package rs.math.oop1.z180300.tokoviObrade.z04.folksFilterCollect;

import java.util.List;
import static rs.math.oop1.z180300.tokoviObrade.z04.folksFilterCollect.Folks.friends;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PickElements
{
	public static void main( final String[] args )
	{
		{
			final List<String> startsWithN = new ArrayList<String>();
			for( String ime : friends )
			{
				if( ime.startsWith( "N" ) )
				{
					startsWithN.add( ime );
				}
			}
			
			System.out
					.println( String.format( "Found %d names", startsWithN.size() ) );
		}
		
		System.out.println( "//" + "START:FILTER_OUTPUT" );
		final List<String> startsWithN = friends.stream()
				.filter( ime -> ime.startsWith( "N" ) )
				.collect( Collectors.toList() );
				
		System.out.println( String.format( "Found %d names", startsWithN.size() ) );
		
		System.out.println( "//" + "END:FILTER_OUTPUT" );
	}
}
