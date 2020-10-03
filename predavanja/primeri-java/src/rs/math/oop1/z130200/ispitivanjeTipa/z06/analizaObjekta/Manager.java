package rs.math.oop1.z130200.ispitivanjeTipa.z06.analizaObjekta;

public class Manager extends Zaposleni
{
  double bonus;
	
	public void setBonus( double bonus )
	{
		this.bonus = bonus;
	}

	public Manager( String n, double s, double b )
	{
		super( n, s );
		bonus = b;
	}
	
}
