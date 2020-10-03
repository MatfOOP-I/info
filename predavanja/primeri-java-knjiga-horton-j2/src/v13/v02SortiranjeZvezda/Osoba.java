package v13.v02SortiranjeZvezda;

public class Osoba implements Comparable 
{
	private String ime; // First name of person
	private String prezime; // Second name of person

	// Constructor
	public Osoba(String firstName, String surname)
	{
		this.ime = firstName;
		this.prezime = surname;
	}

	public String toString()
	{
		return ime + " " + prezime;
	}

	public int compareTo(Object osoba2) {
		int rezultat = prezime.compareTo(((Osoba)osoba2).prezime);
		return rezultat == 0 ? ime.compareTo(((Osoba)osoba2).ime): rezultat;
	}

}
