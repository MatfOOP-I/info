package poruke;

public class SifrarTranslacija extends Sifrar {

	private int pomeraj;
	
	public SifrarTranslacija(Poruka p, int pom) {
		super(p);
		pomeraj=pom;
	}
	
	public void setPomeraj(int pomeraj) {
		this.pomeraj = pomeraj;
	}
	
	public int getPomeraj() {
		return pomeraj;
	}
	
	/* polimorfan metod */
	public Poruka sifruj() {
		String poruka = getPoruka().getTekstPoruke();
		char tekst_poruke[] = poruka.toCharArray();
		for(int i=0; i<poruka.length(); i++)			
			tekst_poruke[i]+=pomeraj;
		return new Poruka(new String(tekst_poruke));
	}
	
	public String toString() {
		return "Transliraj za " + pomeraj + ":\n" + getPoruka();
	}
	
	// ili (ako super.toString() nije apstraktan):
	/*
	public String toString() {
		return "Transliraj za " + pomeraj + ":\n" + super.toString());
	} */
}
