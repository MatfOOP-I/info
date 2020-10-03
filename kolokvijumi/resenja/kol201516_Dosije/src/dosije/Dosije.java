package dosije;

public class Dosije {
	private String osoba;
	private String jmbg;
	
	// konstruktor
	public Dosije(String osoba, String jmbg) {
		this.osoba = osoba;
		this.jmbg = jmbg;
	}
	// kopi-konstruktor
	public Dosije(final Dosije d) {
		this(d.osoba, d.jmbg);
	}
	
	// get() i set()
	public String getOsoba() {
		return osoba;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setOsoba(String osoba) {
		this.osoba = osoba;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	public String toString() {
		return osoba + "\njmbg: " + jmbg;
	}
	
	// van praga
	public static boolean jesteJmbg(String jmbg) {
		if(jmbg.length() != 13) {
			System.out.println("Jmbg nije duzine 13!");
			return false;
		}
		for(int i = 0; i < jmbg.length(); i++)
			if(!Character.isDigit(jmbg.charAt(i))) {
				System.out.println("Jmbg nije broj!");
				return false;
			}
		return true;
	}
}
