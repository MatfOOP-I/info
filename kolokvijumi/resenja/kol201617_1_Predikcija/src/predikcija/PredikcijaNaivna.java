package predikcija;

public class PredikcijaNaivna extends Predikcija {
	private int uvecanje;
	
	public PredikcijaNaivna(Osoba o, int uvecanje) {
		super(o);
		this.uvecanje = uvecanje;
	}
	
	@Override
	public double visina() {  
		if (getOsoba().getPol() == 'm')
			return 1.2*getOsoba().getTezina() + uvecanje;
		else
			return 0.8*getOsoba().getTezina() + uvecanje;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Naivna predikcija:\n");
		sb.append("m: visina = 1.2*tezina + " + uvecanje + "\n");
		sb.append("z: visina = 0.8*tezina + " + uvecanje + "\n");
		return sb.toString();
	}
}
