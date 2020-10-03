package rs.math.oop1.z070502.prevazilazenje.z05.petShop;

public abstract class Sisar extends ZivotinjskaVrsta
{
	private double trudnocaTrajeGod;
	
	private double tezinaBebeKg;
	
	public Sisar( String ime, String klasifikacijaLine,
			double ocekivanaStarostGod, double trudnocaTrajeGod, double tezinaBebeKg )
	{
		super( ime, klasifikacijaLine, ocekivanaStarostGod );
		this.trudnocaTrajeGod = trudnocaTrajeGod;
		this.tezinaBebeKg = tezinaBebeKg;
	}

	public double getTrudnocaTrajeGod()
	{
		return trudnocaTrajeGod;
	}

	public void setTrudnocaTrajeGod( double trudnocaTrajeGod )
	{
		this.trudnocaTrajeGod = trudnocaTrajeGod;
	}

	public double getTezinaBebeKg()
	{
		return tezinaBebeKg;
	}

	public void setTezinaBebeKg( double tezinaBebeKg )
	{
		this.tezinaBebeKg = tezinaBebeKg;
	}
	
}
