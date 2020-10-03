/*
  
Написати Јава програм који омогућује да се, коришћењем дводимензионалног низа, реализују
основне операције над матрицама (сабирање, одузимање, множење и израчунавање детерминанте).
 
 */

// Програм илуструје рад са дводимензионалним низовима и реализацију рекурзије.


class PokretanjeDvodimenzionalniiNizMatrice {

   static void prikazi(double[][] a) {
      if (a == null) {
         System.err.println("GRESKA!");
         return;
      }
      System.out.println("Elementi matrice su");
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[i].length; j++)
            System.out.printf("%15.4f", a[i][j]);
         System.out.printf("\n");
      }
   }

   static void prikazi2(double[][] a) {
      if (a == null) {
         System.err.println("GRESKA!");
         return;
      }
      System.out.println("Elementi matrice su");
      for (double[] vrsta : a) {
         for (double x : vrsta)
            System.out.printf("%15.4f", x);
         System.out.printf("\n");
      }
   }

   static boolean nijeMatrica(double[][] mat) {
      for (int i = 1; i < mat.length; i++)
         if (mat[i].length != mat[0].length)
            return true;
      return false;
   }

   static double[][] saberi(double[][] a, double[][] b) {
      if (a == null || b == null)
         return null;
      if (a.length != b.length)
         return null;
      if (nijeMatrica(a))
         return null;
      if (nijeMatrica(b))
         return null;
      for (int i = 0; i < a.length; i++)
         if (a[i].length != b[i].length)
            return null;
      double[][] c = new double[a.length][a[0].length];
      for (int i = 0; i < c.length; i++)
         for (int j = 0; j < c[i].length; j++)
            c[i][j] = a[i][j] + b[i][j];
      return c;
   }

   static double[][] oduzmi(double[][] a, double[][] b) {
      if (a == null || b == null)
         return null;
      if (a.length != b.length)
         return null;
      if (nijeMatrica(a))
         return null;
      if (nijeMatrica(b))
         return null;
      if (a.length != b.length)
         return null;
      for (int i = 0; i < a.length; i++)
         if (a[i].length != b[i].length)
            return null;
      if (nijeMatrica(a)) return null;
      double[][] c = new double[a.length][a[0].length];
      for (int i = 0; i < c.length; i++)
         for (int j = 0; j < c[i].length; j++)
            c[i][j] = a[i][j] - b[i][j];
      return c;
   }

   static double[][] pomnozi(double[][] a, double[][] b) {
      if (a == null || b == null)
         return null;
      if (nijeMatrica(a))
         return null;
      if (nijeMatrica(b))
         return null;
      if (a[0].length != b.length)
         return null;
      double[][] c = new double[a.length][b[0].length];
      for (int i = 0; i < c.length; i++)
         for (int j = 0; j < c[i].length; j++) {
            c[i][j] = 0;
            for (int k = 0; k < a[i].length; k++)
               c[i][j] += a[i][k] * b[k][j];
         }
      return c;
   }

   static double[][] transponuj(double[][] a) {
      if( a== null)
         return null;
      if (nijeMatrica(a))
         return null;
      double[][] b = new double[a[0].length][a.length];
      for (int i = 0; i < b.length; i++)
         for (int j = 0; j < b[i].length; j++)
            b[i][j] = a[j][i];
      return b;
   }

   static boolean jeKvadratna(double[][] a) {
      if( a==null)
         return false;
      if(nijeMatrica(a))
         return false;
      for (int i = 0; i < a.length; i++)
         if (a.length != a[i].length)
            return false;
      return true;
   }

   static double[][] iskljuci(double[][] a, int vrsta, int kolona) {
      int n = a.length;
      double[][] mat = new double[n - 1][n - 1];
      for (int i = 0; i < vrsta; i++)
         for (int j = 0; j < kolona; j++)
            mat[i][j] = a[i][j];
      for (int i = vrsta; i < n - 1; i++)
         for (int j = 0; j < kolona; j++)
            mat[i][j] = a[i + 1][j];
      for (int i = 0; i < vrsta; i++)
         for (int j = kolona; j < n - 1; j++)
            mat[i][j] = a[i][j + 1];
      for (int i = vrsta; i < n - 1; i++)
         for (int j = kolona; j < n - 1; j++)
            mat[i][j] = a[i + 1][j + 1];
      return mat;
   }

   static double determinanta(double[][] a) {
      int n = a.length;
      if (n == 1)
         return a[0][0];
      if (n == 2)
         return a[0][0] * a[1][1] - a[1][0] * a[0][1];
      double det = 0;
      double znak = 1;
      for (int j = 0; j < n; j++) {
         det += znak * a[0][j] * determinanta(iskljuci(a, 0, j));
         znak = -znak;
      }
      return det;
   }

   public static void main(String[] args) {
      double[][] g = {{1.5, 2, 3}, {4, 5, 6}};
      System.out.println("G je: ");
      prikazi(g);
      prikazi2(g);
      System.out.println("G transponovano je: ");
      double[][] h = transponuj(g);
      prikazi2(h);

      h[1][0] = 0.5;
      System.out.println("promenjeno H je: ");
      prikazi2(h);

      double[][] a = {{1.5, 2, 3}, {4, 5, 6}};
      System.out.println("A je: ");
      prikazi2(a);
      double[][] b = {{2, 3, 4}, {5, 6.6, 7}};
      System.out.println("B je: ");
      prikazi(b);
      System.out.println("A+B je: ");
      prikazi2(saberi(a, b));
      System.out.println("A-B je: ");
      prikazi2(oduzmi(a, b));
      double[][] c = {{2, 1.5}, {3, 0}, {-1.5, 1}};
      System.out.println("C je: ");
      prikazi(c);
      System.out.println("A*C je: ");
      double[][] d = pomnozi(a, c);
      prikazi(d);
      System.out.println("C*A je: ");
      d = pomnozi(c, a);
      prikazi(d);

      if (jeKvadratna(d))
         System.out.println("Determinanta matrice C*A je: " + determinanta(d));
      else
         System.out.println("Matrica C*A nije kvadratna, pa se ne moze odrediti njena determinanta");
   }
}
