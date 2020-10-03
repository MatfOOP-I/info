package rs.math.oop1.z090101.nestatickeUgnjezdene.z01.koriscenje;

public class PokretanjeSpoljsanja1
{
	
	public static void main( String[] args )
	{
		Spoljasnja1 sp = new Spoljasnja1();
		Spoljasnja1.Unutrasnja unutra = sp.new Unutrasnja();
		System.out.println( unutra );
	}
	
}
