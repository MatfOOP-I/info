package v05.v04Lopte;

class Lopta
{
	static final double PI = 3.14; // Class variable that has a fixed value
	static int broj = 0; // Class variable to count objects

	// Instance variables
	double poluprecnik; // Radius of a sphere

	double xCentar; // 3D coordinates
	double yCentar; // of the center
	double zCentar; // of a sphere

	// Class constructors

	// Construct a unit sphere at the origin
	Lopta()
	{
		poluprecnik = 1.0;
		// Other data members will be zero by default
		++broj; // Update object count
	}

	// Construct a unit sphere at a point
	Lopta(double x, double y, double z)
	{
		this(); // Call the constructor with no arguments
		xCentar = x;
		yCentar = y;
		zCentar = z;
	}

	Lopta(double poluprec, double x, double y, double z)
	{
		this(x, y, z); // Call the 3 argument constructor
		poluprecnik = poluprec; // Set the radius
	}

	// Static method to report the number of objects created
	static int getBroj()
	{
		return broj; // Return current object count
	}

	// Instance method to calculate volume
	double zapremina()
	{
		return 4.0 / 3.0 * PI * poluprecnik * poluprecnik * poluprecnik;
	}
}
