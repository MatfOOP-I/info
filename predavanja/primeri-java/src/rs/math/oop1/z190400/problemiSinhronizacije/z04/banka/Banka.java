package rs.math.oop1.z190400.problemiSinhronizacije.z04.banka;

/**
 * 
 * banka sa izvesnim brojem racuna
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
	 * prebacuje novac sa jednog racuna na drugi
	 * 
	 * @param sa
	 *          racun sa kog se prebacuje novac
	 * @param na
	 *          racun na koji se novac prebacuje
	 * @param iznos
	 *          kolicina novca koja se prebacuje
	 */
	public void transfer( int sa, int na, double iznos )
	{
		if (racuni[sa] < iznos)
			return;
		System.out.print( Thread.currentThread() );
		racuni[sa] -= iznos;
		System.out.printf( " %10.2f sa %d na %d", iznos, sa, na );
		racuni[na] += iznos;
		System.out.printf( " Ukupan iznos: %10.2f%n", getUkupnoStanje() );
	}
	
	/**
	 * vraca sumu stanja na svim racunima
	 * 
	 * @return ukupno stanje
	 */
	public double getUkupnoStanje()
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