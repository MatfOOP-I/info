package rs.math.oop1.z070401.definicjeMetoda.z03.frekvencije;

/*
  
Написати Јава програм који пребројава елементе у низу бројева из интервала 1-10
и приказује их у бројчаном облику и у облику хистограма.
    
Пренос вредности између позивајућег и позваног метода је реализован преко
глобалних променљивих.

*/

class Frekfencije {
   int[] brojPojava;
   int min;
   int max;

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
