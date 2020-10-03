package v12.v01Serializacija.Geometrija;

import java.io.*;

import v12.v01Serializacija.Lista.*;


public class Mnogougao implements Serializable
{

	private JednostrukoPovezanaLista mnogougao; // The linked list of points

	// Construct a polyline from an array of coordinate pairs
	public Mnogougao(double[][] koordinate)
	{
		Tacka[] tacke = new Tacka[koordinate.length]; // Array to hold points
		// Create points from the coordinates
		for (int i = 0; i < koordinate.length; i++)
			tacke[i] = new Tacka(koordinate[i][0], koordinate[i][1]);
		// Create the polyline from the array of points
		mnogougao = new JednostrukoPovezanaLista(tacke);
	}

	// Construct a polyline from an array of points
	public Mnogougao(Tacka[] tacke)
	{
		mnogougao = new JednostrukoPovezanaLista(tacke); // Create the polyline
	}

	// Add a Point object to the list
	public void dodajTacku(Tacka tacka)
	{
		mnogougao.dodajNaKraj(tacka); // Add the point to the list
	}

	// Add a point from a coordinate pair to the list
	public void dodajTacku(double x, double y)
	{
		mnogougao.dodajNaKraj(new Tacka(x, y)); // Add the point to the list
	}

	// String representation of a polyline
	public String toString()
	{
		StringBuffer str = new StringBuffer("Poligon:");
		Tacka tacka = (Tacka) mnogougao.getPrvi();
		// Set the 1st point as start
		while (tacka != null)
		{
			str.append(" (" + tacka + ")"); // Append the current point
			tacka = (Tacka) mnogougao.getSledeci(); // Make the next point current
		}
		return str.toString();
	}
	
}
