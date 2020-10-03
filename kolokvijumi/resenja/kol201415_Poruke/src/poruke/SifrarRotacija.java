package poruke;

public class SifrarRotacija extends Sifrar {

	private String smer;
	private int br_mesta;
	
	public SifrarRotacija(Poruka p, String s, int bm) {
		super(p);
		smer = s;
		br_mesta = bm;
	}
	
	/* polimorfan metod */
	public Poruka sifruj() {
		StringBuffer sb = new StringBuffer(getPoruka().getTekstPoruke());
		//poruku rotiramo levo za br_mesta karaktera
		if(smer.equalsIgnoreCase("levo"))		
			for(int i=0; i<br_mesta; i++) {
				sb.append(sb.charAt(0));
				sb.deleteCharAt(0);
			}
		//ili rotiramo desno za br_mesta karaktera
		else if(smer.equalsIgnoreCase("desno"))
			for(int i=0; i<br_mesta; i++) {
				sb.insert(0, sb.charAt(sb.length()-1));
				sb.deleteCharAt(sb.length()-1);
			}
		return new Poruka(sb.toString());
	}
	
	public String toString() {
		return "Rotiraj u smeru " + smer + " za " + br_mesta + ":\n" + getPoruka();
	}
	
	// ili (ako super.toString() nije apstraktan):
	/*
	public String toString() {
		return "Rotiraj u smeru " + smer + " za " + br_mesta + ":\n" + super.toString();
	} */
}
