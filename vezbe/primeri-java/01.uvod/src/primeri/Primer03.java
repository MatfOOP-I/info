package primeri;

public class Primer03 {
	
	// Mozemo pisati funkcije kao u programskom jeziku C.
	// Nije treuntno neophodno razumeti sta je static.
	// Kratko objasnjenje je da ako ga ne stavimo, funkcija ce biti
	// shvacena kao metod koji jedino mozemo pozivati nad konkretnim objektom,
	// a ne kao jednostavnu (C-oliku) funkciju.
	//
	// static POVRATNA_VREDNOST IME(ARGUMENTI...) {
	// 	    ...
	//    	...
	// }
	static int saberi(int x, int y) {
		return x + y;
	}
	
	static void ispisi(int x, int y) {
		System.out.printf("%d + %d = %d\n", x, y, saberi(x, y));
	}
	
	public static void main(String[] args) {
		int a = 20;
		int b = 30;
		int c = saberi(a, b);
	
		System.out.println(c);
		System.out.println(a + " + " + b + " = " + c);
		System.out.println(a + " + " + b + " = " + (a+b));
		System.out.println(a + " + " + b + " = " + saberi(a, b));
		
		// Za one koji vole printf. (funkcije format i printf su iste)
		System.out.printf("%d + %d = %d\n", a, b, (a+b));
		System.out.format("%d + %d = %d\n", a, b, saberi(a, b));
		ispisi(a, b);
	}
}
