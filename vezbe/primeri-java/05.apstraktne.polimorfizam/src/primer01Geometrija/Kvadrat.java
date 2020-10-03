package primer01Geometrija;

public class Kvadrat extends Pravougaonik {
	public Kvadrat(Tacka centar, double dim) {
		super(centar, dim, dim);
	}

	public double getDimenzijaStranice() {
		return getSirina();
	}
	
	@Override
	public String toString() {
		return "Kvadrat{centar = " + getCentar() + " a = " + getSirina() + "}";
	}
}
