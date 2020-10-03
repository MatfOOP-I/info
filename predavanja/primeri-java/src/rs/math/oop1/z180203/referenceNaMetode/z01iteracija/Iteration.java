package rs.math.oop1.z180203.referenceNaMetode.z01iteracija;

import java.util.function.Consumer;

public class Iteration
{
	public static void main( final String[] args )
	{
		for(int i = 0; i < Folks.friends.size(); i++ )
		{
			System.out.println( Folks.friends.get( i ) );
		}
		
		for( String ime : Folks.friends )
		{
			System.out.println( ime );
		}
		
		System.out.println( "//" + "START:INTERNAL_FOR_EACH_OUTPUT" );
		
		Folks.friends.forEach(new Consumer<String>()
		{
			public void accept( final String ime )
			{
				System.out.println( ime );
			}
		} );
		
		System.out.println( "//" + "END:INTERNAL_FOR_EACH_OUTPUT" );
		
		System.out.println( "//" + "START:INTERNAL_OUTPUT" );
		Folks.friends.forEach( (final String ime ) -> System.out.println( ime ) );
		System.out.println( "//" + "END:INTERNAL_OUTPUT" );
		
		Folks.friends.forEach( (ime ) -> System.out.println( ime ) );
		
		Folks.friends.forEach(ime -> System.out.println( ime ) );
		
		Folks.friends.forEach( System.out::println );
	}
}
