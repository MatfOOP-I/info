package rs.math.oop1.z080301.uredjenje.z01.zaposleni;

import java.util.*;

public class PokretanjeUredjenjeZaposlenih
{
	public static void main( String[] args )
	{
		Zaposleni[] osoblje = new Zaposleni[4];
		
		osoblje[0] = new Zaposleni( "Paja Patak", 45000 );
		osoblje[1] = new Zaposleni( "Miki Maus", 85000 );
		osoblje[2] = new Zaposleni( "Hromi Daba", 20000 );
		osoblje[3] = new Zaposleni( "Dusko Dugousko", 45000 );

		System.out.println( "===================================" );
		System.out.println( "Pre sortiranja" );
		for (Zaposleni e : osoblje)
			System.out.println( e );
		
		Arrays.sort( osoblje );
		
		System.out.println( "===================================" );
		System.out.println( "Posle sortiranja" );
		for (Zaposleni e : osoblje)
			System.out.println( e );
	}
}


