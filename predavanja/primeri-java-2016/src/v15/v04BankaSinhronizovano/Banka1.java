package v15.v04BankaSinhronizovano;
// Define the bank
class Banka1
{
	// Perform a transaction
	synchronized public void izvrsiTransakciju(Transakcija trans)
	{
		int balance = trans.getRacun().getBalans(); // Get current balance

		switch (trans.getTipTransakcije())
		{
			case Transakcija.ULOZI:
				// Credits require a lot of checks...
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
				balance += trans.getIznos(); // Increment the balance
				break;

			case Transakcija.PODIGNI:
				// Debits require even more checks...
				try
				{
					Thread.sleep(150);
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
				balance -= trans.getIznos(); // Decrement the balance
				break;

			default : // We should never get here
				System.out.println("Invalidna transakcija");
				System.exit(1);
		}
		trans.getRacun().setBalans(balance); // Restore the account balance
	}
}
