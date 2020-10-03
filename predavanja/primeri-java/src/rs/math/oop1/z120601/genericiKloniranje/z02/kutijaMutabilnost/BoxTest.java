package rs.math.oop1.z120601.genericiKloniranje.z02.kutijaMutabilnost;

public class BoxTest
{
	
	public static void main( String[] args )
	{
		try
		{
			Student pera = new Student( "Petar", "Petrovic" );
			Box<Student> kutija = new Box<>( pera );
			System.out.println( kutija );
			Student pera2 = pera.clone();
			pera.setIme( "Mitar" );
			System.out.println( pera + ", " + pera2 );
			System.out.println( kutija );
		}
		catch (CloneNotSupportedException e)
		{
			System.out.println( e );
		}
		
	}
	
}
