package v14.v01UseJavaUtil;
import java.util.Observer;
import java.util.Observable;

public class Osoba implements Observer
{
	String ime; // Person's identity
	String izgovara; // What they say when startled

	// Constructor
	public Osoba(String ime, String izgovara)
	{
		this.ime = ime;
		this.izgovara = izgovara;
	}

	// Called when observing an object that changes
	public void update(Observable lice, Object o)
	{
		System.out.println(
			"To je " + ((DzekilHajd) lice).getIme() + ".\n" + ime + ": " + izgovara);
	}
}
