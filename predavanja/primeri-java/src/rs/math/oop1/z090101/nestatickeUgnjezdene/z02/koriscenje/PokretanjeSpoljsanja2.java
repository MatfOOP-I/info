package rs.math.oop1.z090101.nestatickeUgnjezdene.z02.koriscenje;

public class PokretanjeSpoljsanja2
{
	
	public static void main( String[] args )
	{
		Spoljasnja2 sp = new Spoljasnja2();
		Spoljasnja2.Unutrasnja unutra = sp.new Unutrasnja(14);
		System.out.println( unutra );
		
		Spoljasnja2 sp2 = new Spoljasnja2();
		Spoljasnja2.Unutrasnja unutra2 = sp2.new Unutrasnja();
		System.out.println( unutra2 );
	}
	
}
