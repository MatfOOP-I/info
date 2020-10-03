package pakovanje;

public abstract class Paket {

	public abstract char vrsta();
	public abstract double zapremina();

	public String toString() {
		return Character.toString(vrsta());
	}

}
