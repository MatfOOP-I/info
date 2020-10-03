package v13.v05KoriscenjeCuvanjeCitanje;

import java.io.*;

public class Osoba implements Comparable, Serializable
{
	private String ime; // First name of person
	private String prezime; // Second name of person

	// Constructor
	public Osoba(String ime, String prezime)
	{
		this.ime = ime;
		this.prezime = prezime;
	}

	public String toString()
	{
		return ime + " " + prezime;
	}

	// Compare Person objects
	public int compareTo(Object person)
	{
		int result = prezime.compareTo(((Osoba) person).prezime);
		return result == 0
			? ime.compareTo(((Osoba) person).ime)
			: result;
	}

	public boolean equals(Object person)
	{
		return compareTo(person) == 0;
	}

	public int hashCode()
	{
		return 7 * ime.hashCode() + 13 * prezime.hashCode();
	}

	// Read a person from the keyboard
	public static Osoba citajLicnost()
	{
		FormatizovaniUlaz in = new FormatizovaniUlaz();
		// Read in the first name and remove blanks front and back
		System.out.println("\nUnesi ime:");
		String ime = in.citajString().trim();

		// Read in the surname, also trimming blanks
		System.out.println("Unesi prezime:");
		String prezime = in.citajString().trim();
		return new Osoba(ime, prezime);
	}

}
