package rs.math.oop1.z080401.polimorfizam.z03.ljudiApstraktno;

/**
 * 
 * Program ilustruje polimorfizam sa apstraktnim klasama.
 * 
 */
public class PokretanjeLjudi
{
	
	public static void main( String[] args )
	{
		Apsolvent marko = new Apsolvent( "Marko", "Markovic", 
				"I smer", "12/2009", 4, 3 );
		
		Student janko = new Student( "Janko", "Jankovic", "I smer", "12/2010", 3 );
		
		Nastavnik milica = new Nastavnik( "Milica", "Jankovic", "OOP", 12 );
		
    Covek[] niz = {marko, janko, milica};
    for( Covek c:niz)
    	System.out.println(  c.opis() );
	}
	
}
