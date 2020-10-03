package primer03VisestrukiCatchIzuzeci;

public class Primer01 {

	public static void testiranjeIzuzetaka(int x) {
		if (x == 1)
			throw new ArrayIndexOutOfBoundsException("x = 1 :)");
		else if (x == 2)
			throw new ArithmeticException("x = 2 :)");
		else if (x == 3)
			throw new NullPointerException("x = 3 :)");
	}
	
	public static void main(String[] args) {
		try {
			testiranjeIzuzetaka(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
		
		// Isti (od java7 standardna) efekat mozemo postici sledecom konstrukcijom.
		try {
			testiranjeIzuzetaka(1);
		} catch (ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e) {
			System.err.println(e.getMessage());
		}
	}

}
