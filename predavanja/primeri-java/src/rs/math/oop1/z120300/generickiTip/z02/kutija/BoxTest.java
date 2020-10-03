package rs.math.oop1.z120300.generickiTip.z02.kutija;

public class BoxTest
{
	
	
	public static void main( String[] args )
	{
		Box<String> b1 = new Box<String>();
		b1.set( "baba" );
		System.out.println( b1.get() );
		b1.set( "zaba" );
		System.out.println( b1.get() );
		//b1.set(23);
		Box<Integer> b2 = new Box<>();
		b2.set( 23 );
		int x = b2.get();
		System.out.println( x );
		Box<Double> b3 = new Box<>();
		b3.set( 2.5 );
		System.out.println( b3.get() );
	}
	
}
