package dosije;

public class Nastavnik extends Zaposleni {
	
	// Kako za svaki objekat klase atribut 'zvanje' moze da uzme neku od zadatih vrednosti
	// iz niza, niz je staticki
	public static String zvanja[] = {"docent", "vanredni", "redovni"};
	
	// staticki niz za potrebe metoda jmbgUDatum()
	public static int daniUmesecu[] = {31,29,31,30,31,30,31,31,30,31,30,31};
		
	private String zvanje; 
	
	public Nastavnik(String osoba, String jmbg, int ugovor, String zvanje) {
		super(osoba, jmbg, ugovor);
		this.zvanje = zvanje;
	}
	public Nastavnik(final Nastavnik n) {
		// posto nema kopi-konstruktora u baznoj
		super(n.getOsoba(), n.getJmbg(), n.ugovor); // razlicit pristup atributima!
		zvanje = n.zvanje;
		// ili:
		// this(n.getOsoba(), n.getJmbg(), n.ugovor, n.zvanje);
	}
	
	public static boolean ispravnoZvanje(String zvanje) {
		for(int i = 0; i < zvanja.length; i++)
			if(zvanje.equalsIgnoreCase(zvanja[i]))
				return true;
		return false;
	}
	
	// datum rodjenja je od znacaja samo za nastavnika
	public static String jmbgUDatum(String jmbg) {
		if(!Nastavnik.jesteJmbg(jmbg)) 
			return null;
		String dS = jmbg.substring(0,2); 
		String mS = jmbg.substring(2,4); 
		String gS = "1" + jmbg.substring(4,7); 
		
		int d = Integer.parseInt(dS); 
		int m = Integer.parseInt(mS); 
		int g = Integer.parseInt(gS); 
		
		if (!(g>1900  && (m>=1 && m<=12) && (d>=1 && d<=daniUmesecu[m-1]))) {
			System.out.println("Pogresan format za jmbg!");
			return null;
		} 
		
		return dS + "." + mS + "." + gS + "."; 
	}

	public String toString() {
		// za nastavnika se ne ispisuje jmbg, pa ne moze super.toString()
		return "Nastavnik: " + getOsoba() + "\nDatum rodjenja: " + jmbgUDatum(getJmbg()) + 
			   "\nradni odnos: " + ugovor + "%" + "\nzvanje: " + zvanje;
	}
}
