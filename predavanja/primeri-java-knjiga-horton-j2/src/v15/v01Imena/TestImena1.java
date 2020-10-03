package v15.v01Imena;
import java.io.IOException;

public class TestImena1 extends Thread
{
	private String ime; // Store for first name
	private String prezime; // Store for second name
	private long cekanje; // Delay in milliseconds

	public TestImena1(String ime, String prezime, long kasnjenje)
	{
		this.ime = ime; // Store the first name
		this.prezime = prezime; // Store the second name
		cekanje = kasnjenje; // Store the delay
		setDaemon(true); // Thread is daemon
	}

	public static void main(String[] args)
	{
		// Create three threads
		Thread prvaNit = new TestImena1("Miki ", "Manojlovic ", 200L);
		Thread drugaNit = new TestImena1("Katarina ", "Zutic ", 300L);
		Thread trecaNit = new TestImena1("Dragan ", "Nikolic ", 500L);

		System.out.println("Kada se umoris, pritisni Enter...\n");
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

	// Method where thread execution will start
	public void run()
	{
		try
		{
			while (true) // Loop indefinitely...
			{
				System.out.print(ime); // Output first name
				sleep(cekanje); // Wait aWhile msec.
				System.out.print(prezime + "\n"); // Output second name
			}
		}
		catch (InterruptedException e) // Handle thread interruption
		{
			System.out.println(ime + prezime + e); // Output the exception
		}
	}
}
