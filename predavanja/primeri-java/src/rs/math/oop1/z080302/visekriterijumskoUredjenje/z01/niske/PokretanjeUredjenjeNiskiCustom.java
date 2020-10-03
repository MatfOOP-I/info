package rs.math.oop1.z080302.visekriterijumskoUredjenje.z01.niske;

import java.util.Arrays;
import java.util.Comparator;

public class PokretanjeUredjenjeNiskiCustom
{
	
	public static void main( String[] args )
	{
		String[] niz = { "Paja", "Miki", "Silja", "Aladin", "Snezana",
				"Herkules",	"Ariel", "Mandrak", "Banana Men" };
		
		System.out.println( "-Leksikografski-" );
		Arrays.sort( niz );
		for (int i = 0; i < niz.length; i++)
			System.out.println( niz[i] );
		
		System.out.println( "-Po broju samoglasnika-" );
		Comparator c = new BrojSamoglasnikaComparator();
		Arrays.sort( niz, c );
		for (int i = 0; i < niz.length; i++)
			System.out.println( niz[i] );
	}
	
}
