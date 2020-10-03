package rs.math.oop1.z080204.interfejsi.z02.ljudi;


/**
 * 
 * Program ilustruje koncept polimorfizma i interfejsa.
 *
 */
public class PokretanjeLjudi3
{
	
	public static void main( String[] args )
	{
		Student marko = new Student("Marko", "Markovic", "I smer", "12/2009", 3);
		marko.setDobrota(75);
		Papagaj koko = new Papagaj();
		Student janko = new Student("Janko", "Jankovic", "I smer", "12/2010", 3);
		janko.setPostenje(99);
		Nastavnik milica = new Nastavnik("Milica", "Jankovic", "OOP", 12);

		Deskripcija[] niz = { marko, koko, janko, milica };
		for (int i = 0; i < niz.length; i++)
		{
			niz[i].predstaviSe();
		}
		System.out.println();

		for (Deskripcija des : niz)
		{
			des.predstaviSe();
			if( des instanceof Kvalitet) {
				Kvalitet kva = (Kvalitet) des;
				System.out.printf("postenje: %d dobrota: %d\n",kva.jePosten(), kva.jeDobar() );
			}
		}

	}
	
}
