package rs.math.oop1.z070903.prevazilazenje.z02.niskaReprezentacijaZaposleniMenadzeri;

import java.util.*;

public class PokretanjeZaposleniMenadzeri
{
	public static void main( String[] args )
	{
		Zaposleni alice1 = new Zaposleni( "Alice Adams", 75000, 1987, 12, 15 );
		Zaposleni alice2 = alice1;
		Zaposleni alice3 = new Zaposleni( "Alice Adams", 75000, 1987, 12, 15 );
		Zaposleni bob = new Zaposleni( "Bob Brandson", 50000, 1989, 10, 1 );
		
		System.out.println( "alice1 == alice2: " + (alice1 == alice2) );
		
		System.out.println( "alice1 == alice3: " + (alice1 == alice3) );
		
		System.out.println( "alice1.equals(alice3): " + alice1.equals( alice3 ) );
		
		System.out.println( "alice1.equals(bob): " + alice1.equals( bob ) );
		
		System.out.println( "bob.toString(): " + bob );
		
		Manager carl = new Manager( "Janko Jankovic", 80000, 1987, 12, 15 );
		Manager boss = new Manager( "Janko Jankovic", 80000, 1987, 12, 15 );
		boss.setBonus( 5000 );
		System.out.println( "boss.toString(): " + boss );
		System.out.println( "carl.equals(boss): " + carl.equals( boss ) );
		System.out.println( "alice1.hashCode(): " + alice1.hashCode() );
		System.out.println( "alice3.hashCode(): " + alice3.hashCode() );
		System.out.println( "bob.hashCode(): " + bob.hashCode() );
		System.out.println( "carl.hashCode(): " + carl.hashCode() );
	}
}

class Zaposleni
{
	private String ime;
	private double plata;
	private Date hireDay;

	public Zaposleni( String n, double s, int godina, int mesec, int dan )
	{
		ime = n;
		plata = s;
		GregorianCalendar calendar = new GregorianCalendar( godina, mesec - 1, dan );
		hireDay = calendar.getTime();
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public double getPlata()
	{
		return plata;
	}
	
	public Date getHireDay()
	{
		return hireDay;
	}
	
	public void povecajPlatu( double zaProcenat )
	{
		double iznosPovisice = plata * zaProcenat / 100;
		plata += iznosPovisice;
	}
	
	@Override
	public boolean equals( Object otherObject )
	{
		// a quick test to see if the objects are identical
		if (this == otherObject)
			return true;
		// must return false if the explicit parameter is null
		if (otherObject == null)
			return false;
		// if the classes don't match, they can't be equal
		if (getClass() != otherObject.getClass())
			return false;
		// now we know otherObject is a non-null Zaposleni
		Zaposleni drugi = (Zaposleni) otherObject;
		// test whether the fields have identical values
		return ime.equals( drugi.ime ) && plata == drugi.plata
				&& hireDay.equals( drugi.hireDay );
	}
	
	@Override
	public int hashCode()
	{
		return 7 * ime.hashCode() + 11 * new Double( plata ).hashCode() + 13
				* hireDay.hashCode();
	}
	
	@Override
	public String toString()
	{
		return getClass().getName() + "[ime=" + ime + ",plata=" + plata
				+ ",hireDay=" + hireDay + "]";
	}
	
}

class Manager extends Zaposleni
{
	private double bonus;

	public Manager( String n, double s, int godina, int mesec, int dan )
	{
		super( n, s, godina, mesec, dan );
		bonus = 0;
	}
	
	@Override
	public double getPlata()
	{
		double baseSalary = super.getPlata();
		return baseSalary + bonus;
	}
	
	public void setBonus( double b )
	{
		bonus = b;
	}
	
	@Override
	public boolean equals( Object otherObject )
	{
		if (!super.equals( otherObject ))
			return false;
		if (!(otherObject instanceof Manager))
			return false;
		Manager drugi = (Manager) otherObject;
		// super.equals checked that this and drugi belong to the same class
		return (bonus == drugi.bonus);
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode() + 17 * new Double( bonus ).hashCode();
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "[bonus=" + bonus + "]";
	}
}
