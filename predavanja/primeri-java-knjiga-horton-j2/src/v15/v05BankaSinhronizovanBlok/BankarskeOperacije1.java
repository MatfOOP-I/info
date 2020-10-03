package v15.v05BankaSinhronizovanBlok;

import java.util.Random;

public class BankarskeOperacije1
{
	public static void main(String[] args)
	{
		int[] pocetniBalans = { 500, 800 }; // The initial account balances
		int[] ukupnoPodizanje = new int[pocetniBalans.length];
		//Two different cr totals
		int[] ukupnoUlaganje = new int[pocetniBalans.length];
		//Two different db totals
		int brojTransakcija = 20; // Number of debits and credits

		// Create the bank and the clerks...
		Banka1 banka = new Banka1(); // Create a bank
		Sluzbenik sluzbenik1 = new Sluzbenik(banka); // Create the first clerk
		Sluzbenik sluzbenik2 = new Sluzbenik(banka); // Create the second clerk

		// Create the accounts, and initialize total credits and debits
		Racun[] racuni = new Racun[pocetniBalans.length];
		for (int i = 0; i < pocetniBalans.length; i++)
		{
			racuni[i] = new Racun(i + 1, pocetniBalans[i]); // Create accounts
			ukupnoPodizanje[i] = ukupnoUlaganje[i] = 0;
		}

		// Create the threads for the clerks as daemon, and start them off
		Thread sluzbenik1Nit = new Thread(sluzbenik1);
		Thread sluzbenik2Nit = new Thread(sluzbenik2);
		sluzbenik1Nit.setDaemon(true); // Set first as daemon
		sluzbenik2Nit.setDaemon(true); // Set second as daemon
		sluzbenik1Nit.start(); // Start the first
		sluzbenik2Nit.start(); // Start the second

		// Create transactions randomly distributed between the accounts
		Random slucaj = new Random(); // Random number generator
		Transakcija transakcija; // Stores a transaction
		int iznos = 0; // stores an amount of money
		int izabraniRacun = 0; // Selects an account
		for (int i = 1; i <= brojTransakcija; i++)
		{
			// Generate a random account index for credit operation
			izabraniRacun = slucaj.nextInt(racuni.length);
			iznos = 50 + slucaj.nextInt(26); // Generate amount of $50 to $75
			transakcija = new Transakcija(racuni[izabraniRacun], // Account
				Transakcija.PODIGNI, // Credit transaction
				iznos); //  of amount
			ukupnoPodizanje[izabraniRacun] += iznos; // Keep total credit tally

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
			sluzbenik1.izvrsiTransakciju(transakcija); // Now do the credit

			// choose an account at random for debit operation
			izabraniRacun = slucaj.nextInt(racuni.length);
			iznos = 30 + slucaj.nextInt(31); // Generate amount of $30 to $60
			transakcija = new Transakcija(racuni[izabraniRacun], // Account
				Transakcija.ULOZI, // Debit transaction
				iznos); //  of amount
			ukupnoUlaganje[izabraniRacun] += iznos; // Keep total debit tally

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
			sluzbenik2.izvrsiTransakciju(transakcija); // Now do the debit
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
		for (int i = 0; i < racuni.length; i++)
			System.out.println(
				"Broj racuna:"
					+ racuni[i].getBrojRacuna()
					+ "\n"
					+ "Pocetni balans      : $"
					+ pocetniBalans[i]
					+ "\n"
					+ "Ukupno podignuto    : $"
					+ ukupnoPodizanje[i]
					+ "\n"
					+ "Ukupno ulozeno      : $"
					+ ukupnoUlaganje[i]
					+ "\n"
					+ "Zavrsni balans      : $"
					+ racuni[i].getBalans()
					+ "\n"
					+ "Treba da bude       : $"
					+ (pocetniBalans[i] - ukupnoPodizanje[i] + ukupnoUlaganje[i])
					+ "\n");
	}
}
