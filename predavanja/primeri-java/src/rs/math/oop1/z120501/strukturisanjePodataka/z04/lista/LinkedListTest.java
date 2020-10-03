package rs.math.oop1.z120501.strukturisanjePodataka.z04.lista;

public class LinkedListTest
{
	
	private static <T> void prikazi( PovezanaLista<T> ll )
	{
		T t = ll.getFirst();
		while (t != null)
		{
			System.out.print( t + " " );
			t = ll.getNext();
		} 
	}
	
	public static void main( String[] args )
	{
		PovezanaLista<String> ll1 = new PovezanaLista<String>( "baba" );
		ll1.addItem( "zaba" );
		Integer[] niz = {1,2,3,4};
		PovezanaLista<Integer> ll2 = new PovezanaLista<>(niz);
		ll2.addItem( 1 );
		ll2.addItem( 2 );
		ll2.addItem( 3 );
		prikazi( ll2 );
		System.out.println();
		prikazi( ll1 );
	}
	
}
