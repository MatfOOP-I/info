package rs.math.oop1.z110600.generickiMetod.z00.par;

public class Util
{
	// Generic static method
	public static <K, V> boolean compare( Pair<K, V> p1, Pair<K, V> p2 )
	{
		return p1.getKey().equals( p2.getKey() )
				&& p1.getValue().equals( p2.getValue() );
	}
}
