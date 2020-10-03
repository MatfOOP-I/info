package v13.v01Guzve;

public class Osoba
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

}
