package rs.math.oop1.z080204.interfejsi.z02.ljudi;

/**
 * 
 * Program ilustruje koncept polimorfizma i interfejsa.
 *
 */
public class PokretanjeLjudi1
{
	
	public static void main( String[] args )
	{
		Apsolvent marko = new Apsolvent("Marko", "Markovic", "I smer", "12/2009",
				3, 5);


		marko.predstaviSe();

		if (marko instanceof Apsolvent)
			System.out.println( "Marko je apsolvent!" );
		else
			System.out.println( "Marko NIJE apsolvent!" );
		if (marko instanceof Student)
			System.out.println( "Marko je student!" );
		else
			System.out.println( "Marko NIJE student!" );
		if (marko instanceof Covek)
			System.out.println( "Marko je covek!" );
		else
			System.out.println( "Marko NIJE covek!" );
		if (marko instanceof Deskripcija)
			System.out.println( "Marko moze pozvati prikaziSe()!" );
		else
			System.out.println( "Marko NE MOZE pozvati prikaziSe()!" );
		
	}
	
}
