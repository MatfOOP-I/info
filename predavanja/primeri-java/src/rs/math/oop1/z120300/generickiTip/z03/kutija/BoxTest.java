package rs.math.oop1.z120300.generickiTip.z03.kutija;

public class BoxTest
{
	
	
	public static void main( String[] args )
	{
		Box<String> b1 = new Box<String>("baba");
		System.out.println( b1 );
		b1.set( "zaba" );
		System.out.println( b1 );
		Box<Integer> b2 = new Box<>(23);
		System.out.println( b2 );
		Box<Double> b3 = new Box<>(2.5);
		System.out.println( b3 );
	}
	
}
