package rs.math.oop1.z080302.visekriterijumskoUredjenje.z03.zaposleni;

import java.util.*;

public class PokretanjeZaposleniUredjenje
{
	public static void main( String[] args )
	{
		Zaposleni[] osoblje = new Zaposleni[4];
		
		osoblje[0] = new Zaposleni( "Marko Markovic", 75000 );
		osoblje[1] = new Zaposleni( "Janko Jankovic", 75000 );
		osoblje[2] = new Zaposleni( "Tony Tester", 38000 );
		osoblje[3] = new Zaposleni( "Milena Milenkovic", 18000 );
		
		System.out.println( "-Pre sortiranja-" );
		for (Zaposleni e : osoblje)
			System.out.println( "ime=" + e.getIme() + ",plata=" + e.getPlata() );
		
		System.out.println( "-Podrazumevano-" );
		Arrays.sort( osoblje );
		for (Zaposleni e : osoblje)
			System.out.println( "ime=" + e.getIme() + ",plata=" + e.getPlata() );
		
		System.out.println( "-Po imenu-" );
		Comparator c = new ZaposleniImeComparator();
		Arrays.sort( osoblje, c );
		for (Zaposleni e : osoblje)
			System.out.println( "ime=" + e.getIme() + ",plata=" + e.getPlata() );
		
		System.out.println( "-Po imenu obratno-" );
		Arrays.sort( osoblje, new ZaposleniImeObratnoComparator() );
		for (Zaposleni e : osoblje)
			System.out.println( "ime=" + e.getIme() + ",plata=" + e.getPlata() );
		
		System.out.println( "-Po plati-" );
		Arrays.sort( osoblje, new ZaposleniPlataComparator() );
		for (Zaposleni e : osoblje)
			System.out.println( "ime=" + e.getIme() + ",plata=" + e.getPlata() );


	}
}
