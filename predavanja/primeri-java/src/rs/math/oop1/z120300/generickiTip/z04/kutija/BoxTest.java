package rs.math.oop1.z120300.generickiTip.z04.kutija;

public class BoxTest
{
	
	
	public static void main( String[] args )
	{
		Box<String> b0 = new Box<>("mika");
		System.out.println( b0 );
		b0.set( "pera" );
		System.out.println( b0 );
			
		Box<Box<String>> b1 = new Box<Box<String>>(
				new Box<>("alibaba")
				);
		System.out.println( b1 );

		b1.set(new Box<> ("aladin") );
		System.out.println( b1 );
		b1.get().set("sinbad");
		System.out.println( b1 );
	}
	
}
