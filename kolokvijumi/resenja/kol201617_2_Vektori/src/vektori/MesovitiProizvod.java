package vektori;

public class MesovitiProizvod extends VektorOperacija {

	private Vektor v1, v2, v3;
	
	public MesovitiProizvod(Vektor v1, Vektor v2, Vektor v3) {
		this.v1 = new Vektor(v1);
		this.v2 = new Vektor(v2);
		this.v3 = new Vektor(v3);
	}

	public Vektor getV1() {
		return v1;
	}

	public Vektor getV2() {
		return v2;
	}

	public Vektor getV3() {
		return v3;
	}

	@Override
	public double izracunaj() {
		Vektor pom = VektorskiProizvod(v1,  v2);
		SkalarniProizvod sp = new SkalarniProizvod(pom, v3);
		return sp.izracunaj();
	}
	
	public String toString(){
		return v1 + " . " + "( " + v2 + " x " + v3  + ") = " + this.izracunaj();
	}
}
