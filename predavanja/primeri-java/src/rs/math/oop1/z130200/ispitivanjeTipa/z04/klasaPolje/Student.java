package rs.math.oop1.z130200.ispitivanjeTipa.z04.klasaPolje;

import rs.math.oop1.z120601.genericiKloniranje.z02.kutijaMutabilnost.KloniraSe;

public class Student implements KloniraSe<Student>
{
	private String ime;
	private String prezime;
	
	public Student(String ime, String prezime)
	{
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public void setIme( String ime )
	{
		this.ime = ime;
	}
	
	public String getPrezime()
	{
		return prezime;
	}
	
	public void setPrezime( String prezime )
	{
		this.prezime = prezime;
	}
	
	@Override
	public String toString()
	{ 
		return "Student: " + ime + " " + prezime; 
	}
	
	@Override
	public Student clone() throws CloneNotSupportedException
	{
		return (Student) super.clone();
	}
}
