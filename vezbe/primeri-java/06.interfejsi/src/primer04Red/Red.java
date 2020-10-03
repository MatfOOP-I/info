package primer04Red;

public interface Red {
	// Dodaje element 'x' na kraj reda.
	void add(int x);
	
	// Skida i vraca element sa pocetka reda.
	int remove();
	
	// Vraca element koji se nalazi na pocetku reda.
	int head();

	// Vraca element koji se nalazi na kraju reda.
	int back();
	
	// Vraca broj elemenata trenutno na redu.
	int size();
	
	// Prikazuje red na standardni izlaz.
	void prikaziRed();
}
