package rs.math.oop1.z090401.anonimneUnutrasnje.z03.geometrijaSortiranje;

import java.util.Arrays;
import java.util.Comparator;

public class PokretanjeGeometrija2
{
	
	/**
	 * @param args
	 */
	public static void main ( String[] args )
	{
		Tacka f = new Tacka(200, 30, "F");
		
		Tacka b = new Tacka(100, 40, "B");
				
		Tacka c = new Tacka(800, 120, "C");
		
		Tacka d = new Tacka(160, 150, "D");
		
		Tacka[] niz = { f, b, c, d };
		System.out.println("\n Pre sortiranja ");
		for (Tacka t : niz)
			System.out.print( t );

		System.out.println("\n Po oznaci ");
		Arrays.sort(  niz, 
			new Comparator()
			{				
				@Override
				public int compare( Object o1, Object o2 )
				{
					if( !(o1 instanceof Tacka ) )
						return -1;
					if( !(o2 instanceof Tacka ) )
						return +1;
					Tacka t1 = (Tacka) o1;
					Tacka t2 = (Tacka) o2;
					return t1.getOznaka().compareTo( t2.getOznaka() );
				}

			}
);
		for (Tacka t : niz)
			System.out.print( t );

		System.out.println("\n Po poziciji ");
		Comparator comp = new Comparator()
		{			
				@Override
				public int compare( Object o1, Object o2 )
				{
					if (!(o1 instanceof Tacka))
						return -1;
					if (!(o2 instanceof Tacka))
						return +1;
					Tacka t1 = (Tacka) o1;
					Tacka t2 = (Tacka) o2;
					Tacka o = new Tacka( 0, 0, "O" );
					double d = o.rastojanje( t1 ) 
							- o.rastojanje( t2 );
					if (d > 0)
						return 1;
					if (d < 0)
						return -1;
					return (t1.getX() - t2.getX());
				}
				
			};
		Arrays.sort( niz, comp );
		for (Tacka t : niz)
			System.out.print( t );

	}
	
}
