package rs.math.oop1.z120501.strukturisanjePodataka.z02.listaObjekata;

public class PovezanaLista
{
	private class ElemenatListe
	{
		private Object sadrzaj;
		private ElemenatListe sledeci;
		
		// Constructor
		public ElemenatListe( Object elem )
		{
			this.sadrzaj = elem; // Store the item
			sledeci = null; // Set next as end point
		}
		
		// Return class ime & object
		@Override
		public String toString()
		{
			return "Elemenat liste: " + sadrzaj;
		}
	}
	
	// First ListIem in the list
	private ElemenatListe pocetak = null;
	// Last ListIem in the list
	private ElemenatListe kraj = null;
	// The current item for iterating
	private ElemenatListe tekuci = null;
	
	// Default constructor - creates an empty list
	public PovezanaLista()
	{
	}
	
	// Constructor to create a list containing one object
	public PovezanaLista( Object elem )
	{
		if (elem != null)
			tekuci = kraj = pocetak = new ElemenatListe( elem ); // item is the start
																														// and end
	}
	
	// Construct a linked list from an array of objects
	public PovezanaLista( Object[] elementi )
	{
		if (elementi == null)
			return;
		// Add the items to the list
		for (int i = 0; i < elementi.length; i++)
			dodajElemenat( elementi[i] );
		tekuci = pocetak;
	}
	
	// Add an item object to the list
	public void dodajElemenat( Object elem )
	{
		ElemenatListe noviKraj = new ElemenatListe( elem ); // Create a new ListItem
		if (pocetak == null) // Is the list empty?
			pocetak = kraj = noviKraj; // Yes, so new element is start and end
		else
		{ // No, so append new element
			kraj.sledeci = noviKraj; // Set next variable for old end
			kraj = noviKraj; // Store new item as end
		}
	}
	
	// Get the first object in the list
	public Object getPrvi()
	{
		tekuci = pocetak;
		return tekuci == null ? null : tekuci.sadrzaj;
	}
	
	// Get the next object in the list
	public Object getSledeci()
	{
		if (tekuci != null)
			tekuci = tekuci.sledeci; // Get the reference to the next item
		return tekuci == null ? null : tekuci.sadrzaj;
	}
	
}
