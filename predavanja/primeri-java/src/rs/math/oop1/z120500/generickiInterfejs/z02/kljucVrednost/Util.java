package rs.math.oop1.z120500.generickiInterfejs.z02.kljucVrednost;

public class Util
{
	// Generic static method
	public static <T, W> boolean areEqual(
			Pair<T, W> p1, Pair<T, W> p2 )
	{
		return p1.getKey().equals( p2.getKey() )
				&& p1.getValue().equals( p2.getValue() );
	}
}