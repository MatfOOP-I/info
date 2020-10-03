package v12.v01Serializacija.Vrednosti;

import java.io.*;

public class TestSerializacijaVrednosti
{
	public static void main(String[] args)
	{
		Vrednost obj1 = new Vrednost("Ako kanis pobijediti, ne smijes izgubiti.");
		Vrednost obj2 =
			new Vrednost("Brojno su jaci - njih su dvojica a mi smo sami.");
		Vrednost obj3 = new Vrednost("More je slano, zasecerimo ga.");
		ObjectOutputStream izlazniTokObjekata = null;
		try
		{
			// Create the object output stream
			izlazniTokObjekata =
				new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("c:/Temp/Vrednosti.bin")));

			// Write three objects to the file
			izlazniTokObjekata.writeObject(obj1); // Write object
			izlazniTokObjekata.writeObject(obj2); // Write object
			izlazniTokObjekata.writeObject(obj3); // Write object
			System.out.println(
				"\n\nobj1:\n" + obj1 + "\n\nobj2:\n" + obj2 + "\n\nobj3:\n" + obj3);
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		// Close the stream
		try
		{
			izlazniTokObjekata.close(); // Close the output stream
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
}
