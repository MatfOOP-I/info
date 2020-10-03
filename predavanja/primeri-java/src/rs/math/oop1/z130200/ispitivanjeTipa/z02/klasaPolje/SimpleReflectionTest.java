package rs.math.oop1.z130200.ispitivanjeTipa.z02.klasaPolje;

enum Miki
{
	A, B
};

public class SimpleReflectionTest
{
	
	public static void main( String[] args )
	{
		Class<?> c = "foo".getClass();
		System.out.println( c );
		Class<?> c2 = System.in.getClass();
		System.out.println( c2 );
	
		Class<?> c3 = Miki.A.getClass();
		System.out.println( c3 );
		byte[] bytes = new byte[1024];
		Class<?> c4 = bytes.getClass();
		System.out.println( c4 );
		boolean[] odgovori = new boolean[3];
		Class<?> c5 = odgovori.getClass();
		System.out.println( c5 );
		
		
		
	}
	
}
