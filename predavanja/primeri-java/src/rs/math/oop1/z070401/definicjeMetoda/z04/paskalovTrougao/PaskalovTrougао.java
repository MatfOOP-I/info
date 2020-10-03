/*
 
Класа за Паскалов троугао.

 */

package rs.math.oop1.z070401.definicjeMetoda.z04.paskalovTrougao;

class PaskalovTrougао {
   // deklarisi trougaoni niz
   int[][] koeficijenti;
   int brojVrsta;

   void odredi(int broj) {
      brojVrsta = broj;
      // alociraj trougaoni niz
      koeficijenti = new int[brojVrsta + 1][];
      for (int n = 0; n <= brojVrsta; n++)
         koeficijenti[n] = new int[n + 1];
      // popuni trougaoni niz
      for (int n = 0; n < koeficijenti.length; n++)
         for (int k = 0; k < koeficijenti[n].length; k++) {
            if (n == 0 || n == 1)
               koeficijenti[n][k] = 1;
            else if (k == 0 || k == n)
               koeficijenti[n][k] = 1;
            else
               koeficijenti[n][k] = koeficijenti[n - 1][k]
                        + koeficijenti[n - 1][k - 1];
         }
   }

   void prikazi() {
      // prikazi elemente niza
      for (int[] vrsta : koeficijenti) {
         for (int elem : vrsta)
            System.out.printf("%15d", elem);
         System.out.println();
      }
   }

}
