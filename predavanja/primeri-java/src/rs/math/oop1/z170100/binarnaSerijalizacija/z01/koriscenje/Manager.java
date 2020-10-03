package rs.math.oop1.z170100.binarnaSerijalizacija.z01.koriscenje;

public class Manager extends Zaposleni
{
	public Manager( String n, double s, int godina, int mesec, int dan )
	{
		super( n, s, godina, mesec, dan );
		secretary = null;
	}
	
	public void setSecretary( Zaposleni s )
	{
		secretary = s;
	}
	
	public String toString()
	{
		return super.toString() + "[secretary=" + secretary + "]";
	}
	
	private Zaposleni secretary;
}

