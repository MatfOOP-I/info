package predikcija;

public class PredikcijaLinearnaRegresija extends Predikcija {
	private double a, b;

	public PredikcijaLinearnaRegresija(Osoba osoba, double a, double b) {
		super(osoba);
		this.a = a;
		this.b = b;
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public void setA(double a) {
		this.a = a;
	}
	
	public void setB(double b) {
		this.b = b;
	}

	@Override
	public double visina() {
		return getOsoba().getTezina()*a + b;
	}

	@Override
	public String toString() {
		return "Linearna regresija:\nvisina = " + a + "*tezina + " + b;
	}
}
