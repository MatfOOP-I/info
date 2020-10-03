package rs.math.oop1.z110600.generickiMetod.z00.par;

public class PairTest
{
	
	public static void main( String[] args )
	{
		Pair<Integer, String> p1 = new Pair<>( 1, "apple" );
		Pair<Integer, String> p2 = new Pair<>( 1, "jabuka" );
		boolean same = Util.<Integer, String> compare( p1, p2 );
		System.out.println( p1 + " i " + p2 + " su isti? " + same );
	}
	
}
