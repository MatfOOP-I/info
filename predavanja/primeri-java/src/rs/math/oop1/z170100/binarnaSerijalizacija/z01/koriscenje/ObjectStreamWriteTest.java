package rs.math.oop1.z170100.binarnaSerijalizacija.z01.koriscenje;

import java.io.*;


class ObjectStreamWriteTest
{
	public static void main( String[] args )
	{
		Zaposleni harry = new Zaposleni( "Marko Markovic", 50000, 1989, 10, 1 );
		Manager carl = new Manager( "Janko Jankovic", 80000, 1987, 12, 15 );
		carl.setSecretary( harry );
		Manager tony = new Manager( "Tony Tester", 40000, 1990, 3, 15 );
		tony.setSecretary( harry );
		
		Zaposleni[] osoblje = new Zaposleni[3];
		
		osoblje[0] = carl;
		osoblje[1] = harry;
		osoblje[2] = tony;
		
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream( "employee1.dat" ) );
			out.writeObject( osoblje );
			out.close();			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

