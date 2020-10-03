package v14.v01UseJavaUtil;
import java.util.Random;
import java.io.IOException;

public class Kockica
{

	public static void main(String[] args)
	{
		System.out.println(
			"Sest puta bacate kockice.\n"
				+ "Cilj je da se dobiju dve sestice. Krecemo...\n");

		Random slucaj = new Random(); // Random number generator
		String[] pokusaj =
			{ "Prvi\t", "Drugi\t", "Treci\t", "Cetvrti\t", "Peti\t", "Sesti\t " };
		int kockica1 = 0; // First die value
		int kockica2 = 0; // Second die value

		for (int i = 0; i < 6; i++)
		{
			kockica1 = 1 + slucaj.nextInt(6); // Number from 1 to 6
			kockica2 = 1 + slucaj.nextInt(6); // Number from 1 to 6
			System.out.println( pokusaj[i] 
				+ "pokusaj:  " + kockica1 + " i " + kockica2);
			if (kockica1 + kockica2 == 12)
			{ // Is it double 6?
				System.out.println("Cestitamo!! Pobedili ste!!"); // Yes !!!
				return;
			}
		}
		System.out.println("Zao nam je, vise srece sledeci put...");
		return;
	}
}
