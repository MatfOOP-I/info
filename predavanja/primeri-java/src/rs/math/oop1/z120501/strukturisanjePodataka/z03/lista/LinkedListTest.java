package rs.math.oop1.z120501.strukturisanjePodataka.z03.lista;

public class LinkedListTest
{
	
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		PovezanaLista ll = new PovezanaLista( "baba" );
		ll.dodajElemenat( "zaba" );
		ll.dodajElemenat(  1  );
		ll.dodajElemenat( new Integer( 2 ) );
		ll.dodajElemenat(  3  );
		ll.dodajElemenat( 4.5 );
		
		Object o = ll.getPrvi();
		while (o != null)
		{
			System.out.println( o );
			o = ll.getSledeci();
		} 
	}
	
}
