package zivotinjskaFarma;

public class Ovca extends Zivotinja
{
	private String[] parole;
	private int poslednjaParola = -1;
	
	private static int count = 0;

	public Ovca(String ime, String[] parole) {
        super(ime);
        this.parole = parole;
        count++;
    }

	public Ovca(final Ovca o) {
		this(o.getIme(), o.parole);
	}

	public void setParole(String[] parole) {
		this.parole = parole;
	}

	public String[] getParole() {
		return parole;
	}
	
	public String toString() {
		poslednjaParola++; 

		if (poslednjaParola >= parole.length)
				poslednjaParola = 0; 

		return "Ovca kaze '" + parole[poslednjaParola] + "'"; 
	}

	public void uglas() {
		System.out.println(getIme() + " ponavlja:\n"); 
		String out = toString(); // ovaj poziv mora da bude van petlje 
		                         // ako bi bio u petlji, onda bi se vise puta pozivao 
								 // metod toString()
		for (int i = 0; i < count; ++i)  
			System.out.println(out); 
		
	}

	public void naredi(Direktiva d) {
		
		if (d.getIme().equals(getIme())) {
				parole = new String[1]; 
				parole[0] = d.getNaredba(); 
				poslednjaParola = -1;  // ponovo inicijalizovati indeks poslednje parole
		}
	}
}

