package v13.v02SortiranjeZvezda;

import java.util.*;

class Guzva
{
	// Person store - only accessible through methods of this class
	private Vector ljudi;

	// Constructors
	public Guzva()
	{
		// Create default Vector object to hold people
		ljudi = new Vector();
	}

	public Guzva(int brojOsoba)
	{
		// Create Vector object to hold people with given capacity
		ljudi = new Vector(brojOsoba);
	}

	// Add a person to the crowd
	public boolean dodaj(Osoba neko)
	{
		return ljudi.add(neko); // Use the Vector method to add
	}

	// Get the person at a given index
	Osoba naPoziciji(int index)
	{
		return (Osoba) ljudi.get(index);
	}

	// Get number of persons in crowd
	public int velicina()
	{
		return ljudi.size();
	}

	// Get people store capacity
	public int kapacitet()
	{
		return ljudi.capacity();
	}

	// Get an iterator for the crowd
	public Iterator iterator()
	{
		return ljudi.iterator();
	}

	public void uredi() 
	{
		Collections.sort(ljudi); 
	}

}
