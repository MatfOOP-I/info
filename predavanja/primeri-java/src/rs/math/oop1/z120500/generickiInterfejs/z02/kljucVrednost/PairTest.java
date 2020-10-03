package rs.math.oop1.z120500.generickiInterfejs.z02.kljucVrednost;


public class PairTest
{
	
	
	public static void main( String[] args )
	{
		OrderedPair<Integer, String> p1 = 
				new OrderedPair<>(1, "apple");
		OrderedPair<Integer, String> p2 = 
				new OrderedPair<>(2, "banana");
		boolean same1 = Util.<Integer, String>areEqual(p1, p2);
		if( same1 )
			System.out.println( p1 + " i " + p2 + " su isti." );
		else
			System.out.println( p1 + " i " + p2 + " nisu isti." );
		p2 = new OrderedPair<>(10/10, "apple");		
		boolean same2 = Util.areEqual(p1, p2);
		if( same2 )
			System.out.println( p1 + " i " + p2 + " su isti." );
		else
			System.out.println( p1 + " i " + p2 + " nisu isti." );
	}
	
}
