package rs.math.oop1.z080401.polimorfizam.z03.ljudiApstraktno;

public class Student extends Covek
{

	private String smer;
	private String brojIndeksa;
	private int godinaStudija;
	
	
	public Student()
	{
	}
	
	public Student( String ime, String prezime, String smer, String brojIndeksa,
			int gs )
	{
		super( ime, prezime );
		this.smer = smer;
		this.brojIndeksa = brojIndeksa;
		this.godinaStudija = gs;
	}
	
	public String getSmer()
	{
		return smer;
	}
	
	public String getBrojIndeksa()
	{
		return brojIndeksa;
	}
	
	public int getGodinaStudija()
	{
		return godinaStudija;
	}
	
	@Override
	public String toString()
	{
		return getClass().getSimpleName() + ": " + getIme() + " " + getPrezime()
				+ " " + smer + " " + brojIndeksa + " " + godinaStudija + ".";
	}
	
	@Override
	public String opis()
	{
		return toString();
	}
}