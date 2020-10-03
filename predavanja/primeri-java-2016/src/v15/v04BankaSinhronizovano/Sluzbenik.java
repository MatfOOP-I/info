package v15.v04BankaSinhronizovano;

public class Sluzbenik implements Runnable
{
	private Banka1 banka; // The employer - an electronic marvel
	private Transakcija traka; // The in-tray holding a transaction

	// Constructor
	public Sluzbenik(Banka1 banka)
	{
		this.banka = banka; // Who the clerk works for
		traka = null; // No transaction initially
	}

	// Receive a transaction
	public void izvrsiTransakciju(Transakcija transaction)
	{
		traka = transaction;
	}

	// The working clerk...
	public void run()
	{
		while (true)
		{
			while (traka == null) // No transaction waiting?
			{
				try
				{
					Thread.sleep(150); // Then take a break...
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
			}
			banka.izvrsiTransakciju(traka);
			traka = null; // In-tray is empty
		}
	}
	// Busy check
	public boolean zauzet()
	{
		return traka != null; // A full in-tray means busy!
	}
}
