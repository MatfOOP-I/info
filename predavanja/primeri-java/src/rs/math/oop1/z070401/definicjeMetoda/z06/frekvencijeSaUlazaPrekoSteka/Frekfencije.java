
/*
  
Класа у којој је енкапсулирана функционалност одређивања фрекфенције бројева.

*/

package rs.math.oop1.z070401.definicjeMetoda.z06.frekvencijeSaUlazaPrekoSteka;

class Frekfencije {
   int[] brojPojava;
   int min;
   int max;

   void izracunaj(int donja, int gornja,
            StekCelihBrojeva brojevi) {
      min = donja;
      max = gornja;
      brojPojava = new int[max - min + 1];
      for (int i = 0; i < brojPojava.length; i++)
         brojPojava[i] = 0;
      while (brojevi.brojElemenata() > 0) {
         int x = brojevi.pop();
         brojPojava[x - min]++;
      }
   }

   void izracunaj(int[] nizVrednosti) {
      min = nizVrednosti[0];
      max = nizVrednosti[0];
      for (int x : nizVrednosti)
         if (x > max)
            max = x;
         else if (x < min)
            min = x;
      brojPojava = new int[max - min + 1];
      for (int i = 0; i < brojPojava.length; i++)
         brojPojava[i] = 0;
      for (int x : nizVrednosti)
         brojPojava[x - min]++;
   }

   void prikaziNumericki() {
      for (int i = 0; i < brojPojava.length; i++)
         System.out.printf("%d:%d %s", (i + min),
                  brojPojava[i],
                  ((i + 1) % 8 == 0) ? "\n" : "\t");
   }

   void prikaziGraficki() {
      for (int i = 0; i < brojPojava.length; i++) {
         System.out.printf("%3d:", i + min);
         for (int j = 0; j < brojPojava[i]; j++)
            System.out.print("*");
         System.out.println();
      }
   }

}
