package primeri;

public class Primer02 {

	public static void main(String[] args) {
		// Deklarisemo promenljive i dodeljujemo im vrednosti.
		int x = 10;
		int y = 20;
		int z = x + y;
		
		// Vrednost promenljive z ispisujemo kao String
		System.out.println(z);
		
		// Izracunava se vrednost izraza 'x + y' i ispisuje
		// na standardni izlaz.
		System.out.println(x + y);
		
		// Slicno, ispisujemo vrednost izraza 'x+y'.
		// Primetimo da se vrednost izraza 'x+y' prebacuje u String
		// i spaja sa String-om "Zbir: "
		System.out.println("Zbir: " + (x+y));
		
		// ------------------------------------------------------------------------------
		//  Java ima i ugradjen tip za rad sa stringovima.
		// Ono sto je zabavno je sto stringove mozemo spajati koristeci operator +.
		// ------------------------------------------------------------------------------
		
		// Pravimo promenljivu tipa 'String' koju cemo nazvati 'str'.
		String str = "Zdravo";
		
		// Dodajemo stringu razmak.
		str = str + " ";
		
		// Mozemo koristiti i operator += da 'uvecamo za neki string'.
		str += "svete" + "!";

		// Ispisujemo rezultat na standardni izlaz.
		System.out.println(str);

		// ------------------------------------------------------------------------------
		// Napomena: String nije primitivni tip poput 'int', 'double' i ostalih
		// vec se ubraja u klasni tip, no String je poseban u Javi.
		// Vise o njemu na narednim casovima.
		// ------------------------------------------------------------------------------
	}
}
