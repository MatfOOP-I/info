package rs.math.oop1.z190500.katanci.z03.banka;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Banka sa odredjenim brojem racuna koja koristi katance za serijalizovanje
 * pristupa
 * 
 */

public class Banka
{
	
	private final double[] racuni;
	private Lock bankaLock;
	private Condition dovoljnoSredstava;
	
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
		bankaLock = new ReentrantLock();
		dovoljnoSredstava = bankaLock.newCondition();
	}
	
	/**
	 * vrsi prenos novca sa jednog racuna na drugi
	 * 
	 * @param sa
	 *          racun sa koga se vrsi prenos
	 * @param na
	 *          racun na koji se vrsi prenos
	 * @param iznos
	 *          kolicina novca koja se prenosi
	 */
	public void transfer( int sa, int na, double iznos )
			throws InterruptedException
	{
		bankaLock.lock();
		try
		{
			while (racuni[sa] < iznos)
				dovoljnoSredstava.await();
			System.out.print( Thread.currentThread() );
			racuni[sa] -= iznos;
			System.out.printf( " %10.2f sa %d na %d", iznos, sa, na );
			racuni[na] += iznos;
			System.out.printf( " Ukupan iznos: %10.2f%n", getUkupnoStanje() );
			dovoljnoSredstava.signalAll();
		}
		finally
		{
			bankaLock.unlock();
		}
	}
	
	/**
	 * vraca sumu stanja na svim racunima
	 * 
	 * @return ukupno stanje
	 */
	public double getUkupnoStanje()
	{
		bankaLock.lock();
		try
		{
			double suma = 0;
			for (double a : racuni)
				suma += a;
			return suma;
		}
		finally
		{
			bankaLock.unlock();
		}
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
