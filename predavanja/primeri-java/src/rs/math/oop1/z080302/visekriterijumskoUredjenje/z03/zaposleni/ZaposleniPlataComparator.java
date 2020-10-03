package rs.math.oop1.z080302.visekriterijumskoUredjenje.z03.zaposleni;

import java.util.Comparator;

public class ZaposleniPlataComparator implements Comparator
{
	@Override
	public int compare( Object o1, Object o2 )
	{
		if( !(o1 instanceof Zaposleni) )
			return 1;
		if( !(o2 instanceof Zaposleni) )
			return -1;
		Zaposleni e1 = (Zaposleni) o1;
		Zaposleni e2 = (Zaposleni) o2;
		double d = e2.getPlata() - e1.getPlata();
		if (d > 0)
			return 1;
		if (d < 0)
			return -1;
		return 0;
	}
}
