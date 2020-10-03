package v15.v02Banka;
import java.util.Random;

public class BankarskeOperacije
{
	public static void main(String[] args)
	{
		int pocetniBalans = 500; // The initial account balance
		int ukupnoPodignuto = 0; // Total credits on the account
		int ukupnoUlozeno = 0; // Total debits on the account
		int brojTransakcija = 20; // Number of debits and credits

		// Create the account, the bank and the clerks...
		Banka banka = new Banka(); // Create a bank
		Sluzbenik sluzbenik1 = new Sluzbenik(banka); // Create the first clerk
		Sluzbenik sluzbenik2 = new Sluzbenik(banka); // Create the second clerk
		Racun racun = new Racun(1, pocetniBalans); // Create an account

		// Create the threads for the clerks as daemon, and start them off
		Thread sluzbenik1Nit = new Thread(sluzbenik1);
		Thread sluzbenik2Nit = new Thread(sluzbenik2);
		sluzbenik1Nit.setDaemon(true); // Set first as daemon
		sluzbenik2Nit.setDaemon(true); // Set second as daemon
		sluzbenik1Nit.start(); // Start the first
		sluzbenik2Nit.start(); // Start the second

		// Generate the transactions of each type and pass to the clerks
		Random rand = new Random(); // Random number generator
		Transakcija trans; // Stores a transaction
		int iznos = 0; // stores an amount of money
		for (int i = 1; i <= brojTransakcija; i++)
		{
			iznos = 50 + rand.nextInt(26); // Generate amount of $50 to $75
			trans = new Transakcija(racun, Transakcija.ULOZI, 	iznos); //  of amount
			ukupnoPodignuto += iznos; // Keep total credit tally
			// Wait until the first clerk is free
			while (sluzbenik1.zauzet())
			{
				try
				{
					Thread.sleep(25); // Busy so try later
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
			}
			sluzbenik1.izvrsiTransakciju(trans); // Now do the credit
			iznos = 30 + rand.nextInt(31); // Generate amount of $30 to $60
			trans = new Transakcija(racun, Transakcija.PODIGNI, iznos); //  of amount
			ukupnoUlozeno += iznos; // Keep total debit tally
			// Wait until the second clerk is free
			while (sluzbenik2.zauzet())
			{
				try
				{
					Thread.sleep(25); // Busy so try later
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
			}
			sluzbenik2.izvrsiTransakciju(trans); // Now do the debit
		}
		// Wait until both clerks are done
		while (sluzbenik1.zauzet() || sluzbenik2.zauzet())
		{
			try
			{
				Thread.sleep(25);
			}
			catch (InterruptedException e)
			{
				System.out.println(e);
			}
		}
		// Now output the results
		System.out.println(
			    "Pocetni balans   : "
				+ pocetniBalans
				+ "\n"
				+ "Ukupno podignuto : "
				+ ukupnoPodignuto
				+ "\n"
				+ "Ukupno ulozeno   : "
				+ ukupnoUlozeno
				+ "\n"
				+ "Zavrsni balans   : "
				+ racun.getBalans()
				+ "\n"
				+ "Treba da bude    : "
				+ (pocetniBalans + ukupnoPodignuto - ukupnoUlozeno));
	}
}
