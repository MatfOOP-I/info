package torta;

public class ReceptTorta extends Recept {

	private int stepenTezine;
	
	public ReceptTorta(Sastojak[] sastojci, int stepenTezine) {
		super(sastojci);
		if(this.stepenTezine > 5 || this.stepenTezine < 1)
			this.stepenTezine = 3;
		else
			this.stepenTezine = stepenTezine;
	}

	public String tezinaRecepta() {
		String nivo = "srednji";
		
		switch(stepenTezine) {
			case 1: nivo = "lak"; break;
			case 2: nivo = "srednje lak"; break;
			case 3: nivo = "srednji"; break;
			case 4: nivo = "srednje tezak"; break;
			case 5: nivo = "tezak"; break;
		}
		
		return nivo;
	}

	public double ukupnaMasaTorte() {
		double masa = 0;
		Sastojak s[] = getSastojci();
 		for(int i = 0; i < getSastojci().length; i++) 
 			if(s[i].getJedinicaMere().equalsIgnoreCase("g"))
 				masa += s[i].getKolicina();
		return masa;
	}
	
}
