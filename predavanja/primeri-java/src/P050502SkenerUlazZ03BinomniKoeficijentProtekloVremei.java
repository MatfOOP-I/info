/*
 
 Написати Јава програм који за унесене бројеве врши рачунање биномног
 коефицијента на два начина (рекурзивно и динамичким програмирањем) и
 приказује добијене резултате и времена извршавања за оба начина.
 
 */

// Задатак представља илустрацију мерења времена

public class P050502SkenerUlazZ03BinomniKoeficijentProtekloVremei {

   static int bkRekurzija(int n, int k) {
      if (n == 0 || n == 1)
         return 1;
      if (k == 0 || k == n)
         return 1;
      return bkRekurzija(n - 1, k) + bkRekurzija(n - 1, k - 1);
   }

   static int bkMnozenje(int n, int k) {
      long rez = 1;
      if (k > n - k) {
         for (int i = k + 1; i <= n; i++)
            rez *= i;
         for (int i = 1; i <= n - k; i++)
            rez /= i;
         return (int) rez;
      } else {
         for (int i = n - k + 1; i <= n; i++)
            rez *= i;
         for (int i = 1; i <= k; i++)
            rez /= i;
         return (int) rez;
      }
   }

   public static void main(String[] args) {
      System.out.println("Racunanje binomnog koeficijenta");
      System.out.println("Unesi n i k: ");
      java.util.Scanner skener = new java.util.Scanner(System.in);
      int n = skener.nextInt();
      int k = skener.nextInt();
      skener.close();

      long vremePocetka = System.nanoTime();
      int rez = bkMnozenje(n, k);
      double trajanje = (System.nanoTime() - vremePocetka) / 1e6;
      System.out.printf("\nMnozenjem i deljenjem dobijen je\n");
      System.out.printf("rezultat %d, za vreme %10.4f msec\n", rez, trajanje);

      vremePocetka = System.nanoTime();
      rez = bkRekurzija(n, k);
      trajanje = (System.nanoTime() - vremePocetka) / 1e6;
      System.out.printf("Cisto rekurzivnim putem dobijen je\n");
      System.out.printf("rezultat %d, za vreme je %10.4f msec\n", rez, trajanje);
   }
}
