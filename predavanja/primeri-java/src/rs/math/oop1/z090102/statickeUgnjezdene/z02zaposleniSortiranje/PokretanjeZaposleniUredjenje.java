package rs.math.oop1.z090102.statickeUgnjezdene.z02zaposleniSortiranje;

import java.util.Arrays;
import java.util.Comparator;

public class PokretanjeZaposleniUredjenje
{
	private static class EmployeeNameComparator implements Comparator
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


	private static class EmployeeNameReverseComparator implements Comparator
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
			return e2.getIme().compareTo( e1.getIme() );
		}
	}


	public static void main( String[] args )
	{
		Zaposleni[] osoblje = new Zaposleni[4];

		osoblje[0] = new Zaposleni( "Marko Markovic", 35000 );
		osoblje[1] = new Zaposleni( "Janko Jankovic", 75000 );
		osoblje[2] = new Zaposleni( "Tony Tester", 38000 );
		osoblje[3] = new Zaposleni( "Milena Milenkovic", 35000 );

		System.out.println( "-Pre sortiranja-" );
		for (Zaposleni e : osoblje)
			System.out.println( e );

		System.out.println( "-Podrazumevano-" );
		Arrays.sort( osoblje );
		for (Zaposleni e : osoblje)
			System.out.println( e );

		System.out.println( "-Po imenu-" );
		Arrays.sort( osoblje, new EmployeeNameComparator() );
		for (Zaposleni e : osoblje)
			System.out.println( e );

		System.out.println( "-Po imenu obratno-" );
		Arrays.sort( osoblje, new EmployeeNameReverseComparator() );
		for (Zaposleni e : osoblje)
			System.out.println( e );
		
	}
}
