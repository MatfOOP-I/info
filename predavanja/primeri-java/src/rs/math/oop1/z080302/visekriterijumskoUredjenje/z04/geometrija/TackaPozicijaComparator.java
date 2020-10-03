package rs.math.oop1.z080302.visekriterijumskoUredjenje.z04.geometrija;

import java.util.Comparator;

public class TackaPozicijaComparator implements Comparator
{
	
	@Override
	public int compare( Object o1, Object o2 )
	{
		if (!(o1 instanceof Tacka))
			return 1;
		if (!(o2 instanceof Tacka))
			return -1;
		Tacka t1 = (Tacka) o1;
		Tacka t2 = (Tacka) o2;
		Tacka o = new Tacka( 0, 0, "O" );
		double d = o.rastojanje( t1 ) - o.rastojanje( t2 );
		if (d > 0)
			return 1;
		if (d < 0)
			return -1;
		return (t1.getX() - t2.getX());
	}
	
}
