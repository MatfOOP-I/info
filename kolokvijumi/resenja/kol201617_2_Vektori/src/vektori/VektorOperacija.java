package vektori;

public abstract class VektorOperacija {
	
	// Klasa ne sadrzi podatke (polja), treba obezbediti samo 
	// staticki metod za vektorski proizvod 
	// i apstraktni metod izracunaj()
	
	public static Vektor VektorskiProizvod(Vektor u, Vektor v) {
		double s1, s2, s3;
		
		s1 = u.getY() * v.getZ() - u.getZ() * v.getY();
		s2 = u.getZ() * v.getX() - u.getX() * v.getZ();
		s3 = u.getX() * v.getY() - u.getY()*v.getX();
		
		return new Vektor(s1, s2, s3);
	}
	
	public abstract double izracunaj() ;
	
}
