package v12.v01Serializacija.Geometrija;

import java.io.*;

public class Tacka implements Serializable
{
	// Create a point from its coordinates
	public Tacka(double xVal, double yVal)
	{
		x = xVal;
		y = yVal;
	}

	// Create a point from another point
	public Tacka(Tacka point)
	{
		x = point.x;
		y = point.y;
	}

	// Convert a point to a string
	public String toString()
	{
		return x + "," + y;
	}

	// Coordinates of the point
	protected double x;
	protected double y;
}
