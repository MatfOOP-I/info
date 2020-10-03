/*
 
Написати Јава програм који омогућује да се, коришћењем дводимензионалног низа, реализује
приказ Паскаловог троугла.

Биномни коефицијенти су добијени по дефиницији.

 */

// Програм илуструје рад са дводимензионалним низом, где се у свакој од врста налази различити 
// број елемената. 
// Такође, програм илуструје последице прекорачења опсега за целобројни тип.

class PokretanjeDvodimenzionalniiNizBKPoDefiniciji {
    // deklarisi trougaoni niz
    static int[][] koeficijenti;

    // binomni koeficijenti dobijeni po definiciji
    static int bk(int n, int k) {
        int rez = 1;
        for (int i = k + 1; i <= n; i++)
            rez *= i;
        for (int i = 1; i <= (n - k); i++)
            rez /= i;
        return rez;
    }

    public static void main(String[] args) {
        int brojVrsta = 15; // 6
        // alociraj trougaoni niz
        koeficijenti = new int[brojVrsta + 1][];
        for (int n = 0; n <= brojVrsta; n++)
            koeficijenti[n] = new int[n + 1];
        // popuni trougaoni niz koriscenjem formule za binomni koeficijent
        for (int n = 0; n < koeficijenti.length; n++)
            for (int k = 0; k < koeficijenti[n].length; k++)
                koeficijenti[n][k] = bk(n, k);
        // prikazi elemente niza
        for (int[] vrsta : koeficijenti) {
            for (int elem : vrsta)
                System.out.printf("%15d", elem);
            System.out.println();
        }
    }
}
