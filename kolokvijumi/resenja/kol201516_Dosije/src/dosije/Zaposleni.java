package dosije;

public class Zaposleni extends Dosije {
	
	protected int ugovor; // dostupan u izvedenoj klasi
		
	// konstruktor 
	public Zaposleni(String osoba, String jmbg, int ugovor){
		super(osoba, jmbg);
		this.ugovor = ugovor;
	}
}
