package predmeti;

public class IzborniPredmet extends Predmet {

	private char blok;
	
	public IzborniPredmet(String sifra, String naziv, int godina, int bodovi, char blok) {
		super(sifra, naziv, godina, bodovi);
		this.blok = blok;
	}

	public char getBlok() {
		return blok;
	}
	
	public int compareTo(Predmet k) {
		if(k == null)
			return 1;
		int rez = Integer.compare(this.getGodina(), k.getGodina());
		if(rez == 0) {
			if(k instanceof ObavezanPredmet)
				return 1;
			else {
				IzborniPredmet ok = (IzborniPredmet)k;
				if(blok == 'M' && ok.blok == 'R')
					return -1;
				else if(blok == 'R' && ok.blok == 'M')
					return 1;
				else {
					int rez1 = Integer.compare(ok.getBodovi(), this.getBodovi());
					if(rez1 == 0)
						return this.getNaziv().compareTo(ok.getNaziv());
					else return rez1;
				}
			}
		}
		else
			return rez;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString() + "\n");
		if(blok == 'M')
			sb.append("izborni blok - matematika");
		else
			sb.append("izborni blok - racunarstvo");
		return sb.toString();
	}
}
