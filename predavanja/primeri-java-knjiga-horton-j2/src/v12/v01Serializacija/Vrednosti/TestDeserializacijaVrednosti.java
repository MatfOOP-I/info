package v12.v01Serializacija.Vrednosti;

import java.io.*;

class TestDeserializacijaVrednosti
{

	public static void main(String args[])
	{
		ObjectInputStream ulazniTokObjekata = null; // Stores the stream reference
		int brojObjekata = 0; // Number of objects read
		Vrednost object = null; // Stores an object reference
		try
		{
			ulazniTokObjekata =
				new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream("c:/Temp/Vrednosti.bin")));
			// Read from the stream until we hit the end
			while (true)
			{
				object = (Vrednost) ulazniTokObjekata.readObject(); // Read an object
				brojObjekata++; // Increment the count
				System.out.println(object); // Output the object
				System.out.println();
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		catch (EOFException e)
		{ // This will execute when we reach EOF
			System.out.println("Stiglo se do EOF. Broj procitanih objekata je " + brojObjekata + ".");
		}
		catch (IOException e)
		{ // This is for other I/O errors
			e.printStackTrace(System.err);
			System.exit(1);
		}
		// Close the stream
		try
		{
			ulazniTokObjekata.close(); // Close the input stream
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
}
