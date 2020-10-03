package v13.v05KoriscenjeCuvanjeCitanje;

class TestKoriscenjeCuvanjeCitanje
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
					+ "Unesi 3 za izlistavanje celog imenika\n"
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
							"Telefonski broj osobe " + neko + " nije pronadjen. ");
					else
						System.out.println(
							"Telefonski broj osobe "
								+ neko
								+ " je "
								+ imenik.getElemenat(neko).getBroj());
					break;
				case 3 :
					imenik.izlistaj();
					break;
				case 9 :
					imenik.sacuvaj();
					System.out.println("Zavrsetak programa.");
					return;
				default :
					System.out.println("Nekorektan unos, pokusajte ponovo.");
					break;
			}
		}
	}
}
