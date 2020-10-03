package predmeti;

import java.util.ArrayList;
import java.util.List;

public class ObavezanPredmet extends Predmet {
	
	private List<String> uslovniPredmeti;
	
	public ObavezanPredmet(String sifra, String naziv, int godina, int brSemestara, int bodovi) {
		super(sifra, naziv, godina, brSemestara, bodovi);
		this.uslovniPredmeti = null;
	}
	
	public List<String> getUslovniPredmeti() {
		return uslovniPredmeti;
	}

	public void dodajUslovniPredmet(String uslovniPredmet) {
		if(uslovniPredmeti == null)
			uslovniPredmeti = new ArrayList<String>();
		uslovniPredmeti.add(uslovniPredmet);
	}
	
	public int compareTo(Predmet k) {
		if(k == null)
			return 1;
		int rez = Integer.compare(this.getGodina(), k.getGodina());
		if(rez == 0) {
			if(k instanceof IzborniPredmet)
				return -1;
			else {
				ObavezanPredmet ok = (ObavezanPredmet)k;
				int rez1 = Integer.compare(ok.getBrSemestara(), this.getBrSemestara());
				if(rez1 == 0) {
					int rez2 = Integer.compare(ok.getBodovi(), this.getBodovi());
					if(rez2 == 0)
						return this.getNaziv().compareTo(ok.getNaziv());
					else return rez2;
				}
				else return rez1;
			}
		}
		else 
			return rez;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(uslovniPredmeti == null)
			sb.append("Nema preduslova.");
		else {
			sb.append("Uslov: ");
			for(String kurs : uslovniPredmeti) 
				sb.append(kurs + ",");
			sb.deleteCharAt(sb.length()-1);
		}
		return super.toString() + "\n" + sb.toString();
	}
}
