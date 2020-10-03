package rs.math.oop1.z180203.referenceNaMetode.z01iteracija;

public class InferredParameterNotFinal
{
	public static void main( final String[] args )
	{
		Folks.friends.forEach(ime -> {
			ime = ime.toUpperCase();
			System.out.println( ime );
		} );
	}
}
