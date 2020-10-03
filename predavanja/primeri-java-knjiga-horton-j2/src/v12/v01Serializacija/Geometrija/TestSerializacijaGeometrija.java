package v12.v01Serializacija.Geometrija;

import java.io.*;

public class TestSerializacijaGeometrija
{

	public static void main(String[] args)
	{
		// Create an array of coordinate pairs
		double[][] koordinate = { { 1., 1. }, {
				1., 2. }, {
				2., 3. }, {
				-3., 5. }, {
				-5., 1. }, {
				0., 0. }
		};
		// Create a polyline from the coordinates and display it
		Mnogougao poligon = new Mnogougao(koordinate);
		System.out.println(poligon);
		// Add a point and display the polyline again
		poligon.dodajTacku(10., 10.);
		System.out.println(poligon);
		// Create Point objects from the coordinate array
		Tacka[] tacke = new Tacka[koordinate.length];
		for (int i = 0; i < tacke.length; i++)
			tacke[i] = new Tacka(koordinate[i][0], koordinate[i][1]);
		// Use the points to create a new polyline and display it
		Mnogougao noviPoligon = new Mnogougao(tacke);
		System.out.println(noviPoligon);
		// Write both polyline objects to the file
		System.out.println("\nUpis objekata iz fajla: ");
		try
		{
			// Create the object output stream
			ObjectOutputStream izlazniTokObjekata =
				new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("C:/Temp/Poligoni.bin")));
			izlazniTokObjekata.writeObject(poligon); // Write first object
			izlazniTokObjekata.writeObject(noviPoligon); // Write second object
			izlazniTokObjekata.close(); // Close the output stream
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		// Read the objects back from the file
		System.out.println("\nCitanje objekata iz fajla: ");
		try
		{
			ObjectInputStream ulazniTokObjekata =
				new ObjectInputStream(
					new BufferedInputStream( new FileInputStream("c:/Temp/Poligoni.bin")));
			Mnogougao mnogougao = (Mnogougao) ulazniTokObjekata.readObject();
			System.out.println(mnogougao); // Display the first object
			mnogougao = (Mnogougao) ulazniTokObjekata.readObject();
			System.out.println(mnogougao); // Display the second object
			ulazniTokObjekata.close(); // Close the input stream
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
}
