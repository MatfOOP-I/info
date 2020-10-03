package v15.v06BankaPrioriteti;
// Define the bank
class Banka1
{
	// Perform a transaction
	public void izvrsiTransakciju(Transakcija trans)
	{
		int balance = trans.getRacun().getBalans(); // Get current balance

		switch (trans.getTipTransakcije())
		{
			case Transakcija.ULOZI:
				synchronized (trans.getRacun() )
				{
					// Get current balance
					balance = trans.getRacun().getBalans();

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
					trans.getRacun().setBalans(balance);
					// Restore account balance
					break;
				}

			case Transakcija.PODIGNI :
				synchronized (trans.getRacun() )
				{
					// Get current balance
					balance = trans.getRacun().getBalans();

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
					trans.getRacun().setBalans(balance);
					// Restore account balance
					break;
				}

			default : // We should never get here
				System.out.println("Invalidna transakcija");
				System.exit(1);
		}
		trans.getRacun().setBalans(balance);
		// Restore the account balance
	}
}
