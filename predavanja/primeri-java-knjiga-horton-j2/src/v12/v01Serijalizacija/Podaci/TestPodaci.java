package v12.v01Serijalizacija.Podaci;

import java.io.*;

public class TestPodaci
{
	public static void main(String[] args)
	{
		Podatak podatak = new Podatak(1);
		try
		{
			// Create the object output stream
			ObjectOutputStream izlazniTokObjekata =
				new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("c:/Temp/Podaci.bin")));
			// Write three variants of the object to the file
			izlazniTokObjekata.writeObject(podatak); // Write object
			System.out.println("Prvi objekat ima vrednost: " + podatak.getBroj());
			podatak.setBroj(2); // Modify the object
			izlazniTokObjekata.writeObject(podatak); // and write it again
			System.out.println("Drugi objekat ima vrednost: " + podatak.getBroj());
			podatak.setBroj(3); // Modify the object again...
			izlazniTokObjekata.writeObject(podatak); // and write it once more
			System.out.println("Treci objekat ima vrednost: " + podatak.getBroj());
			izlazniTokObjekata.close(); // Close the output stream      
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		// Read the three objects back from the file
		System.out.println("\nCitanje objekata iz datoteke: ");
		try
		{
			ObjectInputStream ulazniTokObjekata =
				new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream("c:/Temp/Podaci.bin")));
			Podatak podatak1 = (Podatak) ulazniTokObjekata.readObject();
			Podatak podatak2 = (Podatak) ulazniTokObjekata.readObject();
			Podatak podatak3 = (Podatak) ulazniTokObjekata.readObject();
			System.out.println(
				"Prvi objekat "
					+ (podatak1.equals(podatak2) ? "jeste " : "nije ")
					+ "jednak drugom objektu.");
			System.out.println(
				"Drugi objekat "
					+ (podatak2.equals(podatak3) ? "jeste " : "nije ")
					+ "jednak trecem objektu.");
			System.out.println("podatak1 = " + podatak1.getBroj() // Display object values
			+"  podatak2 = " + podatak2.getBroj() + "  podatak3 = " + podatak3.getBroj());
			ulazniTokObjekata.close(); // Close the input stream
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
}
