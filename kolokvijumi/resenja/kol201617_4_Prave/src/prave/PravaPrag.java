package prave;

public class PravaPrag {
	private double A, B, C; 
	
	public PravaPrag(double A, double B, double C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public PravaPrag(final PravaPrag p) {
		this(p.A, p.B, p.C);
	}
	
	public double getA() {
		return A;
	}

	public void setA(double a) {
		A = a;
	}

	public double getB() {
		return B;
	}

	public void setB(double b) {
		B = b;
	}

	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public String toString() {
		return A + "*x + " + B + "*y + " + C + " = 0";
	}
}
