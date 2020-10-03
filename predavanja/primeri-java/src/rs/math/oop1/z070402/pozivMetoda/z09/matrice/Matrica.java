/*
  
Јава класа која представља матрицу.
 
 */

package rs.math.oop1.z070402.pozivMetoda.z09.matrice;

class Matrica {

   double[][] mat;

   int brojVrsta() {
      return mat.length;
   }

   int brojKolona() {
      return mat[0].length;
   }

   double elemenat(int vrsta, int kolona) {
      return mat[vrsta][kolona];
   }

   void postaviElemenat(int vrsta, int kolona, double vrednost) {
      mat[vrsta][kolona] = vrednost;
   }

   boolean jeKorektnaPomocno(double[][] m) {
      int num = m[0].length;
      for (int i = 1; i < m.length; i++)
         if (m[i].length != num)
            return false;
      return true;
   }

   boolean jeKorektna() {
      if (mat == null)
         return true;
      return jeKorektnaPomocno(mat);
   }

   void init(int m, int n) {
      if (m <= 0 || n <= 0) {
         mat = null;
         return;
      }
      mat = new double[m][n];
      for (int i = 0; i < m; i++)
         for (int j = 0; j < n; j++)
            mat[i][j] = 0;
   }

   void init(double[][] a) {
      if (!jeKorektnaPomocno(a)) {
         mat = null;
         return;
      }
      mat = new double[a.length][a[0].length];
      for (int i = 0; i < mat.length; i++)
         for (int j = 0; j < mat[i].length; j++)
            mat[i][j] = a[i][j];
   }

   void init(Matrica a) {
      init(a.mat);
   }

   void prikazi() {
      if (mat == null) {
         System.out.println("GRESKA!");
         return;
      }
      System.out.println("Elementi matrice su");
      for (double[] vrsta : mat) {
         for (double x : vrsta)
            System.out.printf("%15.4f", x);
         System.out.printf("\n");
      }
   }

   Matrica transponuj() {
      Matrica rez = new Matrica();
      rez.init(brojKolona(), brojVrsta());
      for (int i = 0; i < rez.brojVrsta(); i++)
         for (int j = 0; j < rez.brojKolona(); j++)
            rez.postaviElemenat(i, j, elemenat(j, i));
      return rez;
   }

   Matrica saberi(Matrica b) {
      if (brojVrsta() != b.brojVrsta() || brojKolona() != b.brojKolona())
         return null;
      Matrica c = new Matrica();
      c.init(brojVrsta(), brojKolona());
      for (int i = 0; i < c.brojVrsta(); i++)
         for (int j = 0; j < c.brojKolona(); j++)
            c.postaviElemenat(i, j, elemenat(i, j) + b.elemenat(i, j));
      return c;
   }

   Matrica oduzmi(Matrica b) {
      if (brojVrsta() != b.brojVrsta() || brojKolona() != b.brojKolona())
         return null;
      Matrica c = new Matrica();
      c.init(brojVrsta(), brojKolona());
      for (int i = 0; i < c.brojVrsta(); i++)
         for (int j = 0; j < c.brojKolona(); j++)
            c.postaviElemenat(i, j, elemenat(i, j) - b.elemenat(i, j));
      return c;
   }

   Matrica pomnozi(Matrica b) {
      if (brojKolona() != b.brojVrsta())
         return null;
      Matrica c = new Matrica();
      c.init(brojVrsta(), b.brojKolona());
      for (int i = 0; i < c.brojVrsta(); i++)
         for (int j = 0; j < c.brojKolona(); j++) {
            double x = 0;
            for (int k = 0; k < brojKolona(); k++)
               x += elemenat(i, k) * b.elemenat(k, j);
            c.postaviElemenat(i, j, x);
         }
      return c;
   }

   boolean jeKvadratna() {
      return (jeKorektna() && mat.length == mat[0].length);
   }

   double[][] iskljuciPomocno(double[][] a, int vrsta, int kolona) {
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

   double determinanta() {
      int n = mat.length;
      if (n == 1)
         return mat[0][0];
      if (n == 2)
         return mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1];
      double det = 0;
      double znak = 1;
      for (int j = 0; j < n; j++) {
         Matrica m = new Matrica();
         m.init(iskljuciPomocno(mat, 0, j));
         det += znak * mat[0][j] * m.determinanta();
         znak = -znak;
      }
      return det;
   }

}
