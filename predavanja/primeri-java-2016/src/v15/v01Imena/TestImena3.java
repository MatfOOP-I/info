package v15.v01Imena;
import java.io.IOException;

public class TestImena3 implements Runnable
{
	private String ime; // Store for first name
	private String prezime; // Store for second name
	private long kasnjenje; // Delay in milliseconds

	// Constructor
	public TestImena3(String ime, String prezime, long kasnjenje)
	{
		this.ime = ime; // Store the first name
		this.prezime = prezime; // Store the second name
		this.kasnjenje = kasnjenje; // Store the delay
	}

	// Method where thread execution will start
	public void run()
	{
		try
		{
			while (true) // Loop indefinitely...
			{
				System.out.print(ime); // Output first name
				Thread.sleep(kasnjenje); // Wait aWhile msec.
				System.out.print(prezime + "\n"); // Output second name
			}
		}
		catch (InterruptedException e) // Handle thread interruption
		{
			System.out.println(ime + prezime + e); // Output the exception
		}
	}

	public static void main(String[] args)
	{
		// Create three threads
		Thread prvaNit = new Thread(new TestImena3("Miki ", "Manojlovic ", 200L));
		Thread drugaNit = new Thread(new TestImena3("Katarina ", "Zutic ", 300L));
		Thread trecaNit = new Thread(new TestImena3("Dragan ", "Nikolic ", 500L));

		// Set threads as daemon
		prvaNit.setDaemon(true);
		drugaNit.setDaemon(true);
		trecaNit.setDaemon(true);

		System.out.println("Kada se umoris, pritisni Enter......\n");
		prvaNit.start(); // Start the first thread
		drugaNit.start(); // Start the second thread
		trecaNit.start(); // Start the third thread
		try
		{
			System.in.read(); // Wait until Enter key pressed
			System.out.println("Enter je pritisnut...\n");
		}
		catch (IOException e) // Handle IO exception
		{
			System.out.println(e); // Output the exception
		}
		System.out.println("Zavrsetak main()-a");
		return;
	}
}
