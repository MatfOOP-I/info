package rs.math.oop1.z120601.genericiKloniranje.z01.kutijaMutabilnost;

public class BoxTest
{
	
	
	public static void main( String[] args )
	{
		Student pera = new Student("Petar", "Petrovic");
		Box<Student> kutija = new Box<>(pera);
		System.out.println( kutija );
		pera.setIme( "Mitar" );
		System.out.println( kutija );

		Box<Student> kutija2 = new Box<>(pera);
		kutija2.get().setIme( "Žika" );
		System.out.println( kutija + ", " + kutija2);
		
		
	}
	
}
