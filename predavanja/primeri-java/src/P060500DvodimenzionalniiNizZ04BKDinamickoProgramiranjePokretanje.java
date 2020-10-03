/*
 
Написати Јава програм који омогућује да се, коришћењем дводимензионалног низа, реализује
приказ Паскаловог троугла.

Биномни коефицијенти су добијени на три начина:
1) множењем
2) рекурзивним путем и
3) коришћењем концепта динамичког програмирања.
 
 */

class PokretanjeDvodimenzionalniiNizBKDinamickoProgramiranje {

   // deklarisi trougaoni niz
   static long[][] koeficijenti;

   static int bkMnozenje(int n, int k) {
      int rez = 1;
      if (k > n - k) {
         for (int i = k + 1; i <= n; i++)
            rez *= i;
         for (int i = 1; i <= n - k; i++)
            rez /= i;
         return rez;
      } else {
         for (int i = n - k + 1; i <= n; i++)
            rez *= i;
         for (int i = 1; i <= k; i++)
            rez /= i;
         return (int) rez;
      }
   }

   static long bkRekurzija(int n, int k) {
      if (n == 0 || n == 1)
         return 1;
      if (k == 0 || k == n)
         return 1;
      return bkRekurzija(n - 1, k) + bkRekurzija(n - 1, k - 1);
   }

   static long bkDimanicko(int n, int k) {
      if (koeficijenti[n][k] >= 0)
         return koeficijenti[n][k];
      if (n == 0 || n == 1)
         return 1;
      if (k == 0 || k == n)
         return 1;
      koeficijenti[n][k] = bkDimanicko(n - 1, k) + bkDimanicko(n - 1, k - 1);
      return koeficijenti[n][k];
   }

   public static void main(String[] args) {
      System.out.println("Unesi dimenziju Paskalovog trougla: "); //15 30
      java.util.Scanner skener = new java.util.Scanner(System.in);
      int brojVrsta = skener.nextInt();
      skener.close();

      // racunanje mnozenjem
      long vremePocetka = System.nanoTime();
      koeficijenti = new long[brojVrsta + 1][];
      for (int n = 0; n <= brojVrsta; n++)
         koeficijenti[n] = new long[n + 1];
      for (int n = 0; n < koeficijenti.length; n++)
         for (int k = 0; k < koeficijenti[n].length; k++)
            koeficijenti[n][k] = bkMnozenje(n, k);
      for (long[] vrsta : koeficijenti) {
         for (long elem : vrsta)
            System.out.printf("%15d", elem);
         System.out.println();
      }
      double trajanje = (System.nanoTime()-vremePocetka)/1e9;
      System.out.println("Izracunavanje  mnozenjem je trajalo " + trajanje + " sekundi.");

      // racunanje rekurzivno
      vremePocetka = System.nanoTime();
      koeficijenti = new long [brojVrsta + 1][];
      for (int n = 0; n <= brojVrsta; n++)
         koeficijenti[n] = new long [n + 1];
      for (int n = 0; n < koeficijenti.length; n++)
         for (int k = 0; k < koeficijenti[n].length; k++)
            koeficijenti[n][k] = bkRekurzija(n, k);
      for (long[] vrsta : koeficijenti) {
         for (long elem : vrsta)
            System.out.printf("%15d", elem);
         System.out.println();
      }
      trajanje = (System.nanoTime()-vremePocetka)/1e9;
      System.out.println("Izracunavanje rekurzijom je trajalo " + trajanje + " sekundi.");


      // racunanje dinamicki
      vremePocetka = System.nanoTime();
      koeficijenti = new long[brojVrsta + 1][];
      for (int n = 0; n <= brojVrsta; n++)
         koeficijenti[n] = new long[n + 1];
      for (int i = 0; i < koeficijenti.length; i++)
         for (int j = 0; j < koeficijenti[i].length; j++)
            koeficijenti[i][j] = -1;
      for (int n = 0; n < koeficijenti.length; n++)
         for (int k = 0; k < koeficijenti[n].length; k++)
            koeficijenti[n][k] = bkDimanicko(n, k);
      for (long[] vrsta : koeficijenti) {
         for (long elem : vrsta)
            System.out.printf("%15d", elem);
         System.out.println();
      }
      trajanje = (System.nanoTime()-vremePocetka)/1e9;
      System.out.println("Izracunavanje dinamickom programiranjem je trajalo " + trajanje + " sekundi.");
   }
}
