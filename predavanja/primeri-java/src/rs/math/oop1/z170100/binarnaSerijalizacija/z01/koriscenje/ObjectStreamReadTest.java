package rs.math.oop1.z170100.binarnaSerijalizacija.z01.koriscenje;

import java.io.*;

/**
 * @version 1.10 17 Aug 1998
 * @author Cay Horstmann
 */
class ObjectStreamReadTest
{
	public static void main( String[] args )
	{
		
		try
		{			
			// retrieve all records into a new array
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream( "employee1.dat" ) );
			Zaposleni[] newStaff = (Zaposleni[]) in.readObject();
			in.close();
			
			// iznosPovisice secretary's plata
			newStaff[1].povecajPlatu( 10 );
			
			// print the newly read employee records
			for( Zaposleni e : newStaff )
				System.out.println( e );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
