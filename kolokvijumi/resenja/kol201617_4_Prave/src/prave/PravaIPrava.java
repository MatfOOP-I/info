package prave;

public class PravaIPrava extends RelacijaIncidencije {

	private Prava q;
	
	public PravaIPrava(final Prava p, final Prava q) {
		super(p);
		this.q = new Prava(q);
	}
	
	@Override
	public boolean odnos() {
		if(this.getPrava().k() != q.k())
			return true; // seku se
		return false; // paralelne su
	}

	@Override
	public double izracunaj() {
		double k1 = this.getPrava().k();
		double k2 = q.k();
		if(k1 != k2)
			return Math.toDegrees(
					Math.atan( Math.abs( (k1-k2) / (1 + k1*k2) ) )
				);
		return 0;
	}
	
	public Prava getQ() {
		return q;
	}
	
	public String toString() {
		return super.toString() + "\tq: " + q;
	}
}
