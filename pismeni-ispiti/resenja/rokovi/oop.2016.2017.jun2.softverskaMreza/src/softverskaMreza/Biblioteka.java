package softverskaMreza;

public class Biblioteka extends Softver {
	
	private String opis;
	
	public Biblioteka(String ime, String programskiJezik, int brojLinija, String opis) {
		super(ime, programskiJezik, brojLinija);
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "[biblioteka]: " + super.toString() + " opis: " + opis;
	}
}
