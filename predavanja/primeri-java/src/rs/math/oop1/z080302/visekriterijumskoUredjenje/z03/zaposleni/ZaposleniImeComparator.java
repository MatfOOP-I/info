package rs.math.oop1.z080302.visekriterijumskoUredjenje.z03.zaposleni;

import java.util.Comparator;

public class ZaposleniImeComparator implements Comparator
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
		return e1.getIme().compareTo( e2.getIme() );
	}
}
