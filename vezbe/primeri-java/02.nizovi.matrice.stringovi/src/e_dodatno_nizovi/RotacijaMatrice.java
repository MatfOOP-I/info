package e_dodatno_nizovi;

public class RotacijaMatrice {

	/** Zamislimo da pravimo Tetris.
	 * Potrebna nam je rotacija bloka.
	 * Ako blok cuvamo u matrici, onda nam u stvari treba rotacija matrice.
	 * Matricu mozemo trivijalo rotirati koristeci pomocni niz ili matricu,
	 * ali rotacija matrice u mestu (bez pomocnih nizova/matrica) nije ocigledna.
	 * Sledi primer koji implementira rotaciju matrice u mestu.
	 * 
	 * VAZAN USLOV: Ne mozemo rotirati matricu u mesto ukoliko
	 * joj broj vrsti i kolona nije jednak. U kodu koji sledi
	 * nije vrsena provera oko dimenzija matrice, pretpostavlja
	 * se da su jednake.
	 * 
	 * Autorova opaska (procitati posle gledanja koda):
	 * Kodovi za obrtanje vrsti i kolona bi se mogli apstrahovati jednom funkcijom
	 * i time rasteretiti funkcije rotateLeft i rotateRight, no nije neophodno komplikovati dalje.
	 */
	public static void main(String[] args) {
		// Blok za tetris: 		ili jos lepse:
		//  * 						█
		// *** 			           ███
		int[][] block = {
			{0, 0, 0},
			{0, 1, 0},
			{1, 1, 1}
		};
		System.out.println("Originalni blok:");
		showBlock(block);
		
		System.out.println("Rotacija u levo:");
		rotateLeft(block); showBlock(block);
		rotateLeft(block); showBlock(block);
		rotateLeft(block); showBlock(block);
		rotateLeft(block); showBlock(block);
		
		System.out.println("Rotacija u desno:");
		rotateRight(block); showBlock(block);
		rotateRight(block); showBlock(block);
		rotateRight(block); showBlock(block);
		rotateRight(block); showBlock(block);
	}

	/**
	 * Rotaciju u desno mozemo izvrsiti na sledeci nacin:
	 * 1. Transponujemo matricu.
	 * 2. Obrnemo kolone.
	 */
	static void rotateRight(int[][] block) {
		transpose(block);

		// Obrcemo kolone.
		for (int i = 0; i < block.length; i++) {
			int master = 0, blaster = block[i].length-1;
			while (master < blaster) {
				int tmp = block[i][master];
				block[i][master] = block[i][blaster];
				block[i][blaster] = tmp;
				master++; blaster--;
			}
		}
	}

	/**
	 * Rotaciju u levo mozemo izvrsiti na sledeci nacin:
	 * 1. Transponujemo matricu.
	 * 2. Obrnemo vrste.
	 */
	static void rotateLeft(int[][] block) {
		transpose(block);

		// Sada obrcemo kolone.
		for (int i = 0; i < block.length; i++) {
			int master = 0, blaster = block.length-1;
			while (master < blaster) {
				int tmp = block[master][i];
				block[master][i] = block[blaster][i];
				block[blaster][i] = tmp;
				master++; blaster--;
			}
		}
	}
	
	/**
	 * Vrsi transponovanje matrice u mestu.
	 */
	static void transpose(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a[i].length; j++) {
				int tmp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = tmp;
			}
		}
	}

	/**
	 * Prikazuje prosledjeni blok za tetris.
	 */
	private static void showBlock(int[][] block) {
		for (int[] row: block) {
			for (int e: row) {
				if (e == 1)
					System.out.print("█"); 		// Unicode simbol koji lepo prikazuje blok ^_^
				else
					System.out.print(" ");
					
			}
			System.out.println();
		}
		System.out.println();
	}

}
