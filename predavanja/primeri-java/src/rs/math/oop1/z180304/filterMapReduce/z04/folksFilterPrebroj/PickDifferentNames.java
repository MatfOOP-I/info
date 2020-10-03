package rs.math.oop1.z180304.filterMapReduce.z04.folksFilterPrebroj;

import java.util.function.Predicate;
import java.util.function.Function;

public class PickDifferentNames
{
	public static Predicate<String> checkIfStartsWith( final String letter )
	{
		return ime -> ime.startsWith( letter );
	}
	
	public static void main( final String[] args )
	{
		{
			final Predicate<String> startsWithN = ime -> ime.startsWith( "N" );
			final Predicate<String> startsWithB = ime -> ime.startsWith( "B" );
			
			final long countFriendsStartN = Folks.friends.stream().filter( startsWithN )
					.count();
			final long countFriendsStartB = Folks.friends.stream().filter( startsWithB )
					.count();
					
			System.out.println( countFriendsStartN );
			System.out.println( countFriendsStartB );
		}
		
		{
			final long countFriendsStartN = Folks.friends.stream()
					.filter( checkIfStartsWith( "N" ) ).count();
			final long countFriendsStartB = Folks.friends.stream()
					.filter( checkIfStartsWith( "B" ) ).count();
					
			System.out.println( countFriendsStartN );
			System.out.println( countFriendsStartB );
		}
		
		{
			final Function<String, Predicate<String>> startsWithLetter = (
					String letter ) -> {
				Predicate<String> checkStarts = ( String ime ) -> ime
						.startsWith( letter );
				return checkStarts;
			};
			
			final long countFriendsStartN = Folks.friends.stream()
					.filter( startsWithLetter.apply( "N" ) ).count();
					
			final long countFriendsStartB = Folks.friends.stream()
					.filter( startsWithLetter.apply( "B" ) ).count();
					
			System.out.println( countFriendsStartN );
			System.out.println( countFriendsStartB );
		}
		
		{
			final Function<String, Predicate<String>> startsWithLetter = (
					String letter ) -> ( String ime ) -> ime.startsWith( letter );
					
			final long countFriendsStartN = Folks.friends.stream()
					.filter( startsWithLetter.apply( "N" ) ).count();
					
			final long countFriendsStartB = Folks.friends.stream()
					.filter( startsWithLetter.apply( "B" ) ).count();
					
			System.out.println( countFriendsStartN );
			System.out.println( countFriendsStartB );
		}
		
		{
			final Function<String, Predicate<String>> startsWithLetter = letter -> ime -> ime
					.startsWith( letter );
					
			final long countFriendsStartN = Folks.friends.stream()
					.filter( startsWithLetter.apply( "N" ) ).count();
			final long countFriendsStartB = Folks.friends.stream()
					.filter( startsWithLetter.apply( "B" ) ).count();
					
			System.out.println( countFriendsStartN );
			System.out.println( countFriendsStartB );
		}
		
	}
}
