package rs.math.oop1.z140500.ispitivanjeZabeleski.z02.geometrija;

import java.util.Comparator;

public class TackaOznakaComparator implements Comparator
{
	
	@Override
	public int compare( Object o1, Object o2 )
	{
		if( !(o1 instanceof Tacka ) )
			return -1;
		if( !(o2 instanceof Tacka ) )
			return -1;
		Tacka t1 = (Tacka) o1;
		Tacka t2 = (Tacka) o2;
		return t1.getOznaka().compareTo( t2.getOznaka() );
	}
	
}
