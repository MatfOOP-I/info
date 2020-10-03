package v15.v03BankaViseRacuna;
// Define the bank
class Banka
{
	// Perform a transaction
	public void izvrsiTranskciju(Transakcija transakcija)
	{
		int balans = transakcija.getRacun().getBalans(); // Get current balance
		switch (transakcija.getTipTransakcije())
		{
			case Transakcija.ULOZI :
				// Credits require a lot of checks...
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
				balans += transakcija.getIznos(); // Increment the balance
				break;

			case Transakcija.PODIGNI :
				// Debits require even more checks...
				try
				{
					Thread.sleep(150);
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
				balans -= transakcija.getIznos(); // Decrement the balance
				break;

			default : // We should never get here
				System.out.println("Nekorektna transakcija.");
				System.exit(1);
		}
		transakcija.getRacun().setBalans(balans); // Restore the account balance
	}
}
