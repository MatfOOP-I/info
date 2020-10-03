package polDeteta;

public class OsobaJMBG extends Osoba
{
	private String jmbg;
	
	public OsobaJMBG(String ime, char pol, String jmbg) {
		super(ime,pol);
		this.jmbg=jmbg;
	}
	
	public int brojGodinaOsobe(Datum danasnji_datum) {
		int dan=Integer.parseInt(jmbg.substring(0,2));
		int mesec=Integer.parseInt(jmbg.substring(2,4));
		int godina=1000+Integer.parseInt(jmbg.substring(4,7));

		int brGodina = danasnji_datum.getGodina()-godina;
		if(danasnji_datum.getMesec()<mesec) return brGodina-1;
		else if (danasnji_datum.getMesec()>mesec) return brGodina;
		else if (danasnji_datum.getDan()>dan) return brGodina;
		else return brGodina-1;
	}
	
	public String toString() {
		return "OsobaJMBG:\n"+super.toString()+"\njmbg: "+jmbg;
	}
}
