package v13.v04KoriscenjeHashMape;

class TestKoriscenjeHashMape
{
	public static void main(String[] args)
	{
		TelefonskiImenik imenik = new TelefonskiImenik(); // The phone book
		FormatizovaniUlaz ulaz = new FormatizovaniUlaz(); // Keyboard input
		Osoba neko;

		for (;;)
		{
			System.out.println(
				"Unesi 1 za ubacivanje novog elementa u imenik\n"
					+ "Unesi 2 za odredjivanje broja telefona date licnosti\n"
					+ "Unesi 9 za kraj.");

			int unos = ulaz.citajCeoBroj();
			switch (unos)
			{
				case 1 :
					imenik.dodajElemenat(ElemenatTelefonskogImenika.citajElemenat());
					break;
				case 2 :
					neko = Osoba.citajLicnost();
					ElemenatTelefonskogImenika elemenat = imenik.getElemenat(neko);
					if (elemenat == null)
						System.out.println(
							"Telefonski broj osobe " + neko + " nije pronadjen.\n ");
					else
						System.out.println(
							"Telefonski broj osobe "
								+ neko
								+ " je "
								+ imenik.getElemenat(neko).getBroj() 
								+ "\n" );
					break;
				case 9 :
					System.out.println("Zavrsetak programa.");
					return;
				default :
					System.out.println("Nekorektan unos, pokusajte ponovo.");
					break;
			}
		}
	}
}
