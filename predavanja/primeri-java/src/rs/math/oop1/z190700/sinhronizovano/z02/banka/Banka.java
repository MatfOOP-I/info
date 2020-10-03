package rs.math.oop1.z190700.sinhronizovano.z02.banka;

/**
 * Banka sa odredjenim brojem racuna koja koristi synchronized
 * 
 */

public class Banka
{
	
	private final double[] racuni;
	
	/**
	 * konstruise banku
	 * 
	 * @param n
	 *          broj racuna
	 * @param inicijalnoStanje
	 *          inicijalno stanje svakog racuna
	 */
	public Banka( int n, double inicijalnoStanje )
	{
		racuni = new double[n];
		for (int i = 0; i < racuni.length; i++)
			racuni[i] = inicijalnoStanje;
	}
	
	/**
	 * vrsi prenos novca sa jednog racuna na drugi
	 * 
	 * @param sa
	 *          racun sa koga se vrsi prenos
	 * @param na
	 *          racun na koji se vrsi prenos
	 * @param iznos
	 *          kolicina novca koji se prenosi
	 */
	public synchronized void transfer( int sa, int na, double iznos )
			throws InterruptedException
	{
		while (racuni[sa] < iznos)
			wait();
		System.out.print( Thread.currentThread() );
		racuni[sa] -= iznos;
		System.out.printf( " %10.2f sa %d na %d", iznos, sa, na );
		racuni[na] += iznos;
		System.out.printf( " Ukupan iznos: %10.2f%n", getUkupnoStanje() );
		notifyAll();
	}
	
	/**
	 * vraca sumu stanja svih racuna
	 * 
	 * @return ukupno stanje
	 */
	public synchronized double getUkupnoStanje()
	{
		double suma = 0;
		for (double a : racuni)
			suma += a;
		return suma;
	}
	
	/**
	 * vraca broj racuna u banci
	 * 
	 * @return broj racuna
	 */
	public int getBrojRacuna()
	{
		return racuni.length;
	}
}
