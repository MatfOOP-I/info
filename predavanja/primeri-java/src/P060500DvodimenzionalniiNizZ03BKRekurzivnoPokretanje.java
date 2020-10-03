/*
 
Написати Јава програм који омогућује да се, коришћењем дводимензионалног низа, реализује
приказ Паскаловог троугла.

Ради се са дводимензионалним низом, где се у свакој од врста налази различити број 
елемената.

Биномни коефицијенти су добијени рекурзивним путем.
 
 */

// Програм илуструје рад са дводимензионалним низом, где се у свакој од врста налази различити 
// број елемената. 
// Такође, програм илуструје последице прекорачења опсега за целобројни тип ќасније него у 
// прошлом случају, али ипак наступа прекорачење.
// На крају, програм илуструје како директна примена рекурзије може да успори програм.

class PokretanjeDvodimenzionalniiNizBKRekurzivno {
   // deklarisi trougaoni niz
   static int[][] koeficijenti;

   static int bk(int n, int k) {
      if (n == 0 || n == 1)
         return 1;
      if (k == 0 || k == n)
         return 1;
      return bk(n - 1, k) + bk(n - 1, k - 1);
   }

   public static void main(String[] args) {
      int brojVrsta = 15; // 6
      // alociraj trougaoni niz
      koeficijenti = new int[brojVrsta + 1][];
      for (int n = 0; n <= brojVrsta; n++)
         koeficijenti[n] = new int[n + 1];
      // popuni trougaoni niz koriscenjem bk
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
