package softverskaMreza;

public class Editor extends Softver {

	private String najcesciJezik;
	
	public Editor(String ime, String programskiJezik, int brojLinija, String najcesciJezik) {
		super(ime, programskiJezik, brojLinija);
		this.najcesciJezik = najcesciJezik;
	}
	
	public String getNajcesciJezik() {
		return najcesciJezik;
	}
	
	public String toString() {
		return "[editor]: " + super.toString() + " najcesci jezik: " + najcesciJezik;
	}

}
