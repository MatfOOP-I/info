package d_stringovi;

/// Program ilistruje kako mozemo sortirati String.
/// -> Ne mozemo ga sortirati u mestu usled imutabilnosti,
///     no mozemo ga transforsmisati u niz karaktera,
///     sortirati niz karaktera i dobiti nazad String.
public class Primer07StringSort {
	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog!";
		System.out.println(str);

		char[] tmp = str.toCharArray();
		java.util.Arrays.sort(tmp);

		String sorted = new String(tmp);
		// String sorted = String.valueOf(tmp); 	// alternativno
		System.out.println(sorted);
	}
}
