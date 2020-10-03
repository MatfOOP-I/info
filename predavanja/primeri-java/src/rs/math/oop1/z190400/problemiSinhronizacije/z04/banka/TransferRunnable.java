package rs.math.oop1.z190400.problemiSinhronizacije.z04.banka;

/**
 * Nit koja prebacuje novac sa jednog na druge racune u banci
 * 
 */

public class TransferRunnable implements Runnable
{
	
	private Banka banka;
	private int saRacun;
	private double maxIznos;
	private int DELAY = 600;
	
	/**
	 * konstruise nit za prenos novca
	 * 
	 * @param b
	 *          banka izmedju cijih racuna se vrsi prenos novca
	 * @param sa
	 *          racun sa kog se vrsi prenos novca
	 * @param max
	 *          maksimalna kolicina novca koji se prebacuje u svakom transferu
	 */
	public TransferRunnable( Banka b, int sa, double max )
	{
		banka = b;
		saRacun = sa;
		maxIznos = max;
	}
	
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				int naRacun = (int) (banka.getBrojRacuna() * Math.random());
				double iznos = maxIznos * Math.random();
				banka.transfer( saRacun, naRacun, iznos );
				Thread.sleep( (int) (DELAY * Math.random()) );
			}
		}
		catch (InterruptedException e)
		{
			
		}
	}
}
