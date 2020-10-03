package rs.math.oop1.z170100.binarnaSerijalizacija.z01.koriscenje;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Zaposleni implements Serializable
{
	private static final long serialVersionUID = 2084538915166046307L;
	private String ime;
	private double plata;
	private Date hireDay;

	public Zaposleni()
	{
	}
	
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
	
	public String toString()
	{
		return getClass().getName() + "[ime=" + ime + ",plata=" + plata
				+ ",hireDay=" + hireDay + "]";
	}	
}

