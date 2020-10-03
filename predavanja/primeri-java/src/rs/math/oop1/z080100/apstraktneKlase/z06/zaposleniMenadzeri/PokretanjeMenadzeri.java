package rs.math.oop1.z080100.apstraktneKlase.z06.zaposleniMenadzeri;

public class PokretanjeMenadzeri
{
	public static void main( String[] args )
	{
		// construct a Direktor object
		Direktor sef = new Direktor( "Broj Jedan", 80000, 1987, 12, 15 );
		sef.setBonus( 5000 );
		
		Zaposleni[] spisak = new Zaposleni[3];
		
		spisak[0] = sef;
		spisak[1] = new Zaposleni( "Sir Oliver", 50000, 1989, 10, 1 );
		spisak[2] = new Zaposleni( "Bob Rok", 40000, 1990, 3, 15 );
		
		Student s = new Student( "Alan Ford", "Inf.", 2000, 2, 27 );

		Osoba[] p = new Osoba[4];
		for (int i = 0; i < 3; i++)
			p[i] = spisak[i];
		p[3] = s;
		for (Osoba per : p)
			System.out.println( per );
	}
}
