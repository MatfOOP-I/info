package dodatno;

public class SimpleAsciiArt {

	static void hello() {
		ascii();
	}

	static void ascii() {
		art();
	}

	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	// * Uocite pravilnost medju promenljivama.
	// * Pozovite ih redom u funkciji 'art' koristeci funkciju 'println'.
	// * Pokrenuti program.
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
	static void art() {
		String b0011 = " ____/_____\\__\\@  @/___/_____\\____ ";
		String b0010 = "      /   \\  (_\\  /_)   /   \\      ";
		String b0101 = "|              \\VV/               |";
		String b0111 = "|        dodatne  materijale      |";
		String b1010 = " |  /   V        ))       V   \\  | ";
		String b1001 = " |    /\\ /      \\\\       \\ /\\    | ";
		String b0100 = "|             |\\../|              |";
		String b1000 = "|_________________________________|";
		String b1100 = " `              V                '";
		String b0000 = "        ,     \\    /      ,        ";
		String b1011 = " |/     `       //        '     \\| ";
		String b0001 = "       / \\    )\\__/(     / \\       ";
		String b0110 = "|       Nastavite da pratite      |";
	}

	public static void main(String[] args) {
		hello();
	}

}
