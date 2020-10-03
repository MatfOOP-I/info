package primer01Student;

public class Student {
	// Polja koja opisuju stanje nase klase.
	private String ime, prezime, indeks;
	private double prosek;
	
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// Konstruktor - funkcija koja se poziva pri
	// pravljenju objekta
	//
	// this - referenca na objekat u kojem se trenutno nalazimo
	// U konstruktoru cesto koristimo kako bi razresili koliziju imena
	// 	kada konstruktor prima argument koji se zove isto kao neko od polja.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public Student(String ime, String prezime, String indeks, double prosek) {
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.prosek = prosek;
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// "GETERI" - Funkcije koje vracaju korisniku nase klase deo trenutnog
	// 				stanja objekta.
	// Ne mora da znaci da svako polje TREBA da ima svoj geter. Konkretan geter
	// pravimo onda kada procenimo da ce nam neka vrednost biti potrebna.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public String getIndeks() {
		return indeks;
	}
	
	public int getGodinaUpisa() {
		String tmp = "20" + indeks.charAt(2) + indeks.charAt(3);
		// Klasa 'Integer' sadrzi staticki metod 'parseInt' koji moze da
		// konvertuje objekat klase String u primitivni tip 'int'
		return Integer.parseInt(tmp);
	}
	
	public int getBrojIndeksa() {
		String tmp = "" + indeks.charAt(4) + indeks.charAt(5) + indeks.charAt(6);
		return Integer.parseInt(tmp);
	}
	
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getSmer() {
		char studije = indeks.charAt(0);
		char smer = indeks.charAt(1);
		if (studije == 'm')
			switch (smer) {
				case 'm': return "Teorijska matematika";
				case 'n': return "Primenjena matematika";
				case 'v': return "Statistika i aktuarska i finansijska matematika";
				case 'l': return "Profesor matematike i racunarstva";
				case 'r': return "Racunarstvo i informatika";
				case 'i': return "Informatika";
				default:  return "Nepoznat smer...";
			}
		else if (studije == 'a' && smer == 'f')
			return "Astrofizika";
		else if (studije == 'a' && smer == 'i')
			return "Astroinformatika";
		else
			return "Nepoznat smer...";
	}

	public double getProsek() {
		return prosek;
	}
	
	public String toString() {
		return ime + " " + prezime + ", " + indeks + ", " + prosek;
	}
}

