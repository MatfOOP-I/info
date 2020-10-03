package rs.math.oop1.z110600.generickiMetod.z04.minMax;

import java.util.*;


public class PairTest2
{
	public static void main( String[] args )
	{
		GregorianCalendar[] birthdays = {
				new GregorianCalendar( 1906, Calendar.DECEMBER, 9 ), // G. Hopper
				new GregorianCalendar( 1815, Calendar.DECEMBER, 10 ), // A. Lovelace
				new GregorianCalendar( 1903, Calendar.DECEMBER, 3 ), // J. von Neumann
				new GregorianCalendar( 1910, Calendar.JUNE, 22 ), // K. Zuse
		};
		ArrayAlg.Pair<GregorianCalendar> mm = ArrayAlg.<GregorianCalendar> minmax( birthdays );
		System.out.println( "min = " + mm.getFirst().getTime() );
		System.out.println( "max = " + mm.getSecond().getTime() );
		
		String[] words = { "mary", "had", "a", "little", "lamb", 
				"tra", "la", "la" };
		ArrayAlg.Pair<String> mm2 = ArrayAlg.minmax( words );
		System.out.println( "min = " + mm2.getFirst() );
		System.out.println( "max = " + mm2.getSecond() );
		
		Double[] d = { 12.0, 14.0, -3.5, 15.0, 0.0 , 7.0 };
		ArrayAlg.Pair<Double> mm3 = ArrayAlg.minmax( d );
		System.out.println( "min = " + mm3.getFirst() );
		System.out.println( "max = " + mm3.getSecond() );
		
		Long[] nizL = { 12l, 14l, -3l, 15l, 0l , 7l };
		ArrayAlg.Pair<Long> mm4 = ArrayAlg.minmax( nizL );
		System.out.println( "min = " + mm4.getFirst() );
		System.out.println( "max = " + mm4.getSecond() );
		
		Zaposleni[] ljudi = {new Zaposleni( "pera", 100 ),
				new Zaposleni( "zika", 200 ),
				new Zaposleni( "lika", 30 )};
		//ArrayAlg.Pair<Zaposleni> =  ArrayAlg.minmax( ljudi );
		
	}
}
