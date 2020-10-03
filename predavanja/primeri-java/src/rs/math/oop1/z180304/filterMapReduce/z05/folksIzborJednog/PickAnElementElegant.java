package rs.math.oop1.z180304.filterMapReduce.z05.folksIzborJednog;

import java.util.List;
import java.util.Optional;

public class PickAnElementElegant
{
	public static void pickName( final List<String> names,
			final String startingLetter )
	{
		
		final Optional<String> foundName = names.stream()
				.filter( ime -> ime.startsWith( startingLetter ) ).findFirst();
				
		System.out.println( String.format( "A ime starting with %s: %s",
				startingLetter,
				foundName.orElse( "No ime found" ) ) );
	}
	
	public static void main( final String[] args )
	{
		System.out.println( "//" + "START:NAME_OUTPUT" );
		pickName( Folks.friends, "N" );
		pickName( Folks.friends, "Z" );
		System.out.println( "//" + "END:NAME_OUTPUT" );
		
		final Optional<String> foundName = Folks.friends.stream()
				.filter( ime -> ime.startsWith( "N" ) ).findFirst();
				
		System.out.println( "//" + "START:CLOSURE_OUTPUT" );
		foundName.ifPresent( ime -> System.out.println( "Hello " + ime ) );
		System.out.println( "//" + "END:CLOSURE_OUTPUT" );
	}
}
