package rs.math.oop1.z190500.katanci.z03.banka;

public class KatanciUsloviBankaTest
{
	
	public static final int BROJ_RACUNA = 100;
	public static final double INICIJALNO_STANJE = 1000;
	
	public static void main( String[] args )
	{
		Banka b = new Banka( BROJ_RACUNA, INICIJALNO_STANJE );
		for (int i = 0; i < BROJ_RACUNA; i++)
		{
			TransferRunnable r = new TransferRunnable( b, i, INICIJALNO_STANJE );
			Thread t = new Thread( r );
			t.start();
		}
	}
}
