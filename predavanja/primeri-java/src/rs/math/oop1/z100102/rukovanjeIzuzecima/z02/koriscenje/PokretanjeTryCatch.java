package rs.math.oop1.z100102.rukovanjeIzuzecima.z02.koriscenje;

public class PokretanjeTryCatch
{
	public static void main( String[] args )
	{
		int i = 1;
		int j = 0;
		
		try
		{
			System.out.println( "Try block entered " + "i = " + i + " j = " + j );
			System.out.println( i / j ); // Divide by 0 - exception thrown
			System.out.println( "Ending try block" );			
		}
		catch (ArithmeticException e)
		{ // Catch the exception
			System.out.println( "Arithmetic exception caught " + e );
		}
		System.out.println( "After try block" );
		return;
	}
}
