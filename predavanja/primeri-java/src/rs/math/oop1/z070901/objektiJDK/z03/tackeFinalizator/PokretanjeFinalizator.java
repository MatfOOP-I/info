package rs.math.oop1.z070901.objektiJDK.z03.tackeFinalizator;

public class PokretanjeFinalizator
{
	
	public static void main( String[] args )
	{

		int i = 1;
		while (i <= 1_000)
		{
			if( 1 > 0 )
			{
				Tacka a = new Tacka( 2, 3, "A" + i );
				a.prikaziSe();
				System.out.println();
				
				Tacka b = new Tacka( 10, 4, "B" + i );
				b.prikaziSe();
				System.out.println();
			}
			if( i % 100 == 0 )
				System.gc();
			i++;
		}
		
	}
	
}
