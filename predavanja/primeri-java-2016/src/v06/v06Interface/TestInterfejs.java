package v06.v06Interface;

import java.util.Random;

public class TestInterfejs
{
	public static void main(String[] args)
	{
		Oglasavanje[] zivotinjke =
			{
				new Pas("Arcibald", "Pudla"),
				new Pas("Diksi", "Pudla"),
				new Pas("Eol", "Koli"),
				new Macka("Garpi", "Persijska"),
				new Macka("Djilda", "Sijamska"),
				new Patka("Daca", "Plovka"),
				new Spaniel("Grof"),
				new Spaniel("Fido")};

		Oglasavanje izabrana; 

		Random slucajan = new Random(); 
		for (int i = 0; i < 5; i++)
		{ 
			izabrana = zivotinjke[slucajan.nextInt(zivotinjke.length)];
			System.out.println("\nIzabrana je:\n" + izabrana);
			izabrana.oglasiSe(); 
		}
	}
}
