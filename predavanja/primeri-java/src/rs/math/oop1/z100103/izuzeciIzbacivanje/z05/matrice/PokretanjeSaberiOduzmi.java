package rs.math.oop1.z100103.izuzeciIzbacivanje.z05.matrice;

import java.util.Scanner;

public class PokretanjeSaberiOduzmi {
   private static boolean kontrolaDim(double[][] m) throws MatricaNePostojiException {
      if (m == null)
         throw new MatricaNePostojiException();
      if (m[0] == null)
         throw new MatricaNePostojiException();
      int n1 = m[0].length;
      for (int i = 1; i < m.length; i++) {
         if (m[i] == null)
            throw new MatricaNePostojiException();
         if (m[i].length != n1)
            return false;
      }
      return true;
   }

   private static double[][] ucitaj() throws NegativnaDimenzijaMatriceException {
      Scanner ulaz = new Scanner(System.in);
      System.out.println("Broj vrsta matrice");
      int m = ulaz.nextInt();
      if (m < 0)
         throw new NegativnaDimenzijaMatriceException(m);
      System.out.println("Broj kolona matrice");
      int n = ulaz.nextInt();
      if (n < 0)
         throw new NegativnaDimenzijaMatriceException(n);
      System.out.println("Elementi matrice su");
      double mat[][] = new double[m][n];
      for (int i = 0; i < m; i++)
         for (int j = 0; j < n; j++)
            mat[i][j] = ulaz.nextDouble();
      return mat;
   }

   private static void prikazi(double[][] a) throws MatricaNePostojiException {
      if (a == null) {
         MatricaNePostojiException npe = new MatricaNePostojiException();
         throw npe;
      }
      System.out.println("Elementi matrice su");
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[i].length; j++)
            System.out.printf("%15.4f", a[i][j]);
         System.out.println();
      }
   }

   private static double[][] saberi(double[][] a, double[][] b) throws NekompatibilneDimenzijeMatriceException,
         MatricaNePostojiException, DvodimenzionalniNizNijeMatricaException {
      if (a == null)
         throw new MatricaNePostojiException();
      if (b == null)
         throw new MatricaNePostojiException();
      if (!kontrolaDim(a))
         throw new DvodimenzionalniNizNijeMatricaException(a);
      if (!kontrolaDim(b))
         throw new DvodimenzionalniNizNijeMatricaException(b);
      if (a.length != b.length)
         throw new NekompatibilneDimenzijeMatriceException(a.length, b.length);
      for (int i = 0; i < a.length; i++)
         if (a[i].length != b[i].length)
            throw new NekompatibilneDimenzijeMatriceException(a[i].length,
                  b[i].length);
      double[][] c = new double[a.length][a[0].length];
      for (int i = 0; i < c.length; i++)
         for (int j = 0; j < c[i].length; j++)
            c[i][j] = a[i][j] + b[i][j];
      return c;
   }

   private static double[][] oduzmi(double[][] a, double[][] b) throws NekompatibilneDimenzijeMatriceException,
         MatricaNePostojiException, DvodimenzionalniNizNijeMatricaException {
      if (a == null)
         throw new MatricaNePostojiException();
      if (b == null)
         throw new MatricaNePostojiException();
      if (!kontrolaDim(a))
         throw new DvodimenzionalniNizNijeMatricaException(a);
      if (!kontrolaDim(b))
         throw new DvodimenzionalniNizNijeMatricaException(b);
      if (a.length != b.length)
         throw new NekompatibilneDimenzijeMatriceException(a.length, b.length);
      for (int i = 0; i < a.length; i++)
         if (a[i].length != b[i].length)
            throw new NekompatibilneDimenzijeMatriceException(a[i].length,
                  b[i].length);
      double[][] c = new double[a.length][a[0].length];
      for (int i = 0; i < c.length; i++)
         for (int j = 0; j < c[i].length; j++)
            c[i][j] = a[i][j] - b[i][j];
      return c;
   }

   public static void main(String[] args) {
      try {
         double[][] a = {{1, 2, 3}, {3, 4}};
         //a = ucitaj();
         System.out.println("A je: ");
         prikazi(a);
         double[][] b = {{1, 2, 3.5}, {3, 4, 5}};
         //b = ucitaj();
         System.out.println("B je: ");
         prikazi(b);
         System.out.println("Zbir je: ");
         prikazi(saberi(a, b));
         System.out.println("Razlika je: ");
         prikazi(oduzmi(a, b));
      } catch ( //NegativnaDimenzijaMatriceException |
            NekompatibilneDimenzijeMatriceException |
                  MatricaNePostojiException |
                  DvodimenzionalniNizNijeMatricaException
                  e) {
         System.out.println("Doslo je do greske " + e);
         e.printStackTrace();
      }
   }

}
