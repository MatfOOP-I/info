package v12.v01Serializacija.Lista;

import java.io.*;

public class JednostrukoPovezanaLista implements Serializable  
{
	private class ClanListe implements Serializable
	{
		Object element;
		ClanListe sledeci; // Refers to next item in the list

		// Constructor 
		public ClanListe(Object clan)
		{
			this.element = clan; // Store the item
			sledeci = null; // Set next as end point
		}

		// Return class name & object
		public String toString()
		{
			return "Clan liste " + element;
		}

	}

	private ClanListe pocetak = null; // First ListIem in the list
	private ClanListe kraj = null; // Last ListIem in the list
	private ClanListe tekuci = null; // The current item for iterating

	// Default constructor - creates an empty list
	public JednostrukoPovezanaLista()
	{
	}

	// Constructor to create a list containing one object
	public JednostrukoPovezanaLista(Object clan)
	{
		if (clan != null)
			tekuci = kraj = pocetak = new ClanListe(clan);
		// item is the start and end
	}

	// Construct a linked list from an array of objects
	public JednostrukoPovezanaLista(Object[] clanovi)
	{
		if (clanovi != null)
		{
			// Add the items to the list
			for (int i = 0; i < clanovi.length; i++)
				dodajNaKraj(clanovi[i]);
			tekuci = pocetak;
		}
	}

	// Add an item object to the list
	public void dodajNaKraj(Object item)
	{
		ClanListe noviKraj = new ClanListe(item); // Create a new ListItem
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
		return (pocetak == null) ? null : pocetak.element;
	}

	// Get the next object in the list
	public Object getSledeci()
	{
		if (tekuci != null)
			tekuci = tekuci.sledeci; // Get the reference to the next item
		return tekuci == null ? null : tekuci.element;
	}
}
	