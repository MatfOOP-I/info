package v13.v03Karte;

class TestKarte
{
	public static void main(String[] args)
	{
		Spil spil = new Spil();
		spil.promesaj();
		Ruka mojeKarte = spil.podeliRuku(5);
		Ruka tvojeKarte = spil.podeliRuku(5);
		System.out.println("\nMoje karte su " + mojeKarte);
		System.out.println("\nTvoje karte su " + tvojeKarte);
	}
}
