package v05.v08ZecIzSesira;
public class TestMagicniSesir
{
	static public void main(String[] args)
	{
		// Create three magic hats and output them
		System.out.println(new MagicniSesir("Sivi kaubojski"));
		System.out.println(new MagicniSesir("Crni cilindar"));
		System.out.println(new MagicniSesir("Kacket"));

		MagicniSesir stariSesir = new MagicniSesir("Stari sesir"); // New hat object
		MagicniSesir.Zec zeka = stariSesir.new Zec(); // Create rabbit object
		System.out.println(stariSesir); // Show the hat
		System.out.println("\nNovi zec je: " + zeka); // Display the rabbit
	}
}
