package v05.v05Geometrija;

class Tacka
{
	double x;
	double y;

	Tacka(double xVal, double yVal)
	{
		x = xVal;
		y = yVal;
	}

	Tacka(final Tacka tacka)
	{
		x = tacka.x;
		y = tacka.y;
	}

	void pomeri(double xDelta, double yDelta)
	{
		x += xDelta;
		y += yDelta;
	}

	double rastojanje(final Tacka tacka)
	{
		return Math.sqrt(
			(x - tacka.x) * (x - tacka.x) + (y - tacka.y) * (y - tacka.y));
	}

	public String toString()
	{
		return Double.toString(x) + ", " + y; 
	}
	
}
