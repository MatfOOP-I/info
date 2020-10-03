package v15.v06BankaPrioriteti;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class Sluzbenik1 implements Runnable
{
	private Banka1 banka; // The employer - an electronic marvel
	// The in-tray holding transactions
	private List traka = Collections.synchronizedList(new LinkedList());

	private int maksimalnoTransakcija = 8; // Maximum transactions in the in-tray

	// Constructor
	public Sluzbenik1(Banka1 banka)
	{
		this.banka = banka; // Who the clerk works for
		//inTray = null;                    // No transaction initially
	}

	// Receive a transaction
	synchronized public void izvrsiTransakciju(Transakcija trans)
	{
		while (traka.size() >= maksimalnoTransakcija)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				System.out.println(e);
			}
		}
		traka.add(trans);
		notifyAll();
	}

	// The working clerk...
	synchronized public void run()
	{
		while (true)
		{
			while (traka.size() == 0) // No transaction waiting?
			{
				try
				{
					wait(); // Then take a break until there is
				}
				catch (InterruptedException e)
				{
					System.out.println(e);
				}
			}
			banka.izvrsiTransakciju((Transakcija) traka.remove(0));
			notifyAll(); // Notify other threads locked on this clerk
		}
	}

	// Busy check
	synchronized public boolean zauzet()
	{
		while (traka.size() != 0) // Is this object busy?
		{
			try
			{
				wait(); // Yes, so wait for notify call
			}
			catch (InterruptedException e)
			{
				System.out.println(e);
			}
			return false; // It is free now
		}
		return false;
	}
}
