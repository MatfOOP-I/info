package rs.math.oop1.z190400.problemiSinhronizacije.z04.banka;

/**
 * program ilustruje "kvarenje" podataka kada im pristupa veci broj niti
 */

public class UnsyncBankaTest
{
	
	public static final int BROJ_RACUNA = 5;
	public static final double INICIJALNO_STANJE = 20;
	
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
