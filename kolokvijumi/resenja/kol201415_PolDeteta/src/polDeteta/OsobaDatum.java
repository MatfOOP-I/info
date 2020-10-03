package polDeteta;

public class OsobaDatum extends Osoba 
{
	private Datum d_rodj;
	
	public OsobaDatum(String ime, char pol, Datum d) {
		super(ime, pol);
		d_rodj = new Datum(d);
	}
	
	public int brojGodinaOsobe(Datum danasnji_datum) {
		int brGodina = danasnji_datum.getGodina()-d_rodj.getGodina();
		if(danasnji_datum.getMesec()<d_rodj.getMesec()) return brGodina-1;
		else if (danasnji_datum.getMesec()>d_rodj.getMesec()) return brGodina;
		else if (danasnji_datum.getDan()>d_rodj.getDan()) return brGodina;
		else return brGodina-1;
	}
	
	public String toString() {
		return "OsobaDatum:\n"+super.toString()+"\ndatum rodjenja: "+d_rodj;
	}
}
