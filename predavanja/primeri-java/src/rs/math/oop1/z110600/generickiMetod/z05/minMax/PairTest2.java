package rs.math.oop1.z110600.generickiMetod.z05.minMax;

import java.util.*;

class ArrayAlg
{
	static class Pair<T>
	{
		private T first;
		private T second;

		public Pair()
		{
			first = null;
			second = null;
		}
		
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
		
		public void setFirst( T newValue )
		{
			first = newValue;
		}
		
		public void setSecond( T newValue )
		{
			second = newValue;
		}	
	}

	public static <T extends Comparable> Pair<T> minmax( T[] a )
	{
		if (a == null || a.length == 0)
			return null;
		T min = a[0];
		T max = a[0];
		for (int i = 1; i < a.length; i++)
		{
			if (min.compareTo( a[i] ) > 0)
				min = a[i];
			if (max.compareTo( a[i] ) < 0)
				max = a[i];
		}
		return new Pair<T>( min, max );
	}
}

public class PairTest2
{
	public static void main( String[] args )
	{
		GregorianCalendar[] birthdays = {
				new GregorianCalendar( 1906, Calendar.DECEMBER, 9 ), // G. Hopper
				new GregorianCalendar( 1815, Calendar.DECEMBER, 10 ), // A. Lovelace
				new GregorianCalendar( 1903, Calendar.DECEMBER, 3 ), // J. von Neumann
				new GregorianCalendar( 1910, Calendar.JUNE, 22 ), // K. Zuse
		};
		ArrayAlg.Pair<GregorianCalendar> mm = ArrayAlg
				.<GregorianCalendar> minmax( birthdays );
		System.out.println( "min = " + mm.getFirst().getTime() );
		System.out.println( "max = " + mm.getSecond().getTime() );
		
		String[] words = { "Mary", "had", "a", "little", "lamb", 
				"tra", "la", "la" };
		ArrayAlg.Pair<String> mm2 = ArrayAlg.minmax( words );
		System.out.println( "min = " + mm2.getFirst() );
		System.out.println( "max = " + mm2.getSecond() );
		
	}
}
