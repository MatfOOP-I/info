package prave;

public class PravaITacka extends RelacijaIncidencije {

	private double x, y;
	
	public PravaITacka(final Prava p, double x, double y) {
		super(p);
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean odnos() {
		Prava p = getPrava();
		if(p.getA()*x + p.getB()*y + p.getC() == 0)
			return true;
		return false;
	}

	@Override
	public double izracunaj() {
		Prava p = getPrava();
		return Math.abs(p.getA()*x + p.getB()*y + p.getC()) / Math.sqrt(p.getA()*p.getA() + p.getB()*p.getB());
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String toString() {
		return super.toString() + "\tT: " + "(" + x + ", " + y + ")";
	}
}
