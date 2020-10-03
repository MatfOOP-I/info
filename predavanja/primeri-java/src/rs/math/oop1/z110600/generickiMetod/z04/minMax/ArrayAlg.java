package rs.math.oop1.z110600.generickiMetod.z04.minMax;

public class ArrayAlg
{
	static class Pair<T>
	{
		private T first;
		private T second;
		
		public Pair( T first, T second )
		{
			this.first = first;
			this.second = second;
		}
		
		public T getFirst()
		{
			return first;
		}
		
		public T getSecond()
		{
			return second;
		}
	}
	
	public static <T extends Comparable> Pair<T> minmax( T[] a )
	{
		if( a == null || a.length == 0 )
			return null;
		T min = a[0];
		T max = a[0];
		for( int i = 1; i < a.length; i++ )
		{
			if( min.compareTo( a[i] ) > 0 )
				min = a[i];
			if( max.compareTo( a[i] ) < 0 )
				max = a[i];
		}
		return new Pair<T>( min, max );
	}
}
