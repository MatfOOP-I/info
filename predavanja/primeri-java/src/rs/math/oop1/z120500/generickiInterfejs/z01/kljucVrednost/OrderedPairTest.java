package rs.math.oop1.z120500.generickiInterfejs.z01.kljucVrednost;

public class OrderedPairTest
{
	
	public static void main( String[] args )
	{
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>(
				"Paran", 8 );
		System.out.println( p1 );
		Pair<String, String> p2 = new OrderedPair<>( "hello", "world" );
		System.out.println( p2 );
		OrderedPair<String, Box<Integer>> op3 = new OrderedPair<>( 
				"prosti",
				new Box<Integer>( 2977 ) );
		Pair<String, Box<Integer>> p3 = op3;
		System.out.println( p3 );
		Pair<Pair<Integer, Box<Double>>, Pair<String, String>> p4 = 
				new OrderedPair<Pair<Integer, Box<Double>>, Pair<String, String>>(
				new OrderedPair<Integer, Box<Double>>( 2, new Box<>( 3.5 ) ),
				new OrderedPair<String, String>( "miki", "maus" ) );
		System.out.println( p4 );
		 Pair<
		   Pair<Box<Integer>,String>,
		   Pair<Double,Box<String> >
		 > p5
		 = new OrderedPair<Pair<Box<Integer>,String>,
		 Pair<Double,Box<String>>>
		 ( new OrderedPair<>( new Box<>(3), "tri" ) ,
		 new OrderedPair<>( 2.5, new Box<>("baba") ) );
		 System.out.println( p5 );
	}
	
}
