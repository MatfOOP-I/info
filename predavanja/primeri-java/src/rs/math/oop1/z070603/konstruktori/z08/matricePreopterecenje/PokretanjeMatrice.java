/*
  
Написати Јава програм који омогућује да се реализују
основне операције над матрицама (сабирање, одузимање, множење и израчунавање детерминанте).
 
Рад са матрицом треба издвојити у посебну класу. Матрица ће бити реализована коришћењем 
дводимензионалног низа. 
 
 */

// Задатак представља и илустрацију преоптерећења конструктора (Matrica).

package rs.math.oop1.z070603.konstruktori.z08.matricePreopterecenje;

public class PokretanjeMatrice {

   public static void main(String[] args) {
      double[][] a1 = { { 1.5, 2, 3 }, { 4, 5, 6 } };
      Matrica a = new Matrica(a1);
      System.out.println("A je: ");
      a.prikazi();
      double[][] b1 = { { 2, 3, 4 }, { 5, 6.6, 7 } };
      Matrica b = new Matrica(b1);
      System.out.println("B je: ");
      b.prikazi();
      System.out.println("A+B je: ");
      a.saberi(b).prikazi();
      System.out.println("A-B je: ");
      a.oduzmi(b).prikazi();
      System.out.println("A je: ");
      a.setElemenat(1, 0, 0.5);
      a.prikazi();
      double[][] c1 = { { 2, 1.5 }, { 3, 0 }, { -1.5, 1 } };
      Matrica c = new Matrica(c1);
      System.out.println("C je: ");
      c.prikazi();
      System.out.println("A*C je: ");
      Matrica d = a.pomnozi(c);
      d.prikazi();
      if (d.jeKvadratna())
         System.out.println("Determinanta matrice A*C je: " + d.determinanta());
      else
         System.out.println("Matrica A*C nije kvadratna, pa se ne moze odrediti njena determinanta");
      double[][] d1 = { { 3, 2, 3 }, { 1, 1, 0 }, { 1.5, 2, 1 } };
      d = new Matrica(d1);
      System.out.println("D je: ");
      d.prikazi();
      System.out.println("Determinanta matrice D je: " + d.determinanta());
   }
}
