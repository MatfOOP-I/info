package primer01Covek;

public class Main {

	public static void main(String[] args) {
		Covek c = new Covek("Petar", "Sojic", 25);
		c.zdravo();
		c.hello();
		
		// Referenca c koja referise na objekat klase 'Covek'
		//   mozemo kastovati na "NESTO STO IMPLEMENTIRA INTERFEJS 'SrpskiJezik'".
		// Na ovaj nacin mozemo omoguciti polimorfno izvrsavanje metoda,
		//   a usput korisnika osloboditi brige o tome sa kojom klasom radi, ono
		//   sto je za korisnika bitno je koje to funkcije pruza interfejs.
		SrpskiJezik sj = c;
		sj.dovidjenja();
		sj.hvala();
		
		EngleskiJezik ej = c;
		ej.goodbye();
		ej.hello();
		
		if (c instanceof SrpskiJezik)
			System.out.println("Klasa Covek implementira interfejs SrpskiJezik");
		if (c instanceof EngleskiJezik)
			System.out.println("Klasa Covek implementira interfejs EngleskiJezik");
	}

}
