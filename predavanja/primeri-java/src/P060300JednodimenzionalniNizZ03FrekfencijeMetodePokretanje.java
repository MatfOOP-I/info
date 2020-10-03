/*
  
Написати Јава програм који пребројава елементе у низу бројева из интервала 1-10
и приказује их у бројчаном облику и у облику хистограма.
  
Различите активности у извршавању програма су издвојене као посебни методи.
  
Пренос вредности између позивајућег и позваног метода је реализован преко
параметара.
  
 */

// Програм илуструје рад са низовима, статичке методе параметре и ефекте замене 
// низовних параметара приликом позива метода.

class PokretanjeJednodimenzionalniNizFrekfencijeMetode {

   static int odrediDonjuGranicu(int[] rezultati) {
      int ret = rezultati[0];
      for (int i = 1; i < rezultati.length; i++)
         if (rezultati[i] < ret)
            ret = rezultati[i];
      return ret;
   }

   static int odrediGornjuGranicu(int[] rezultati) {
      int ret = rezultati[0];
      for (int i = 1; i < rezultati.length; i++)
         if (rezultati[i] > ret)
            ret = rezultati[i];
      return ret;
   }

   static void izracunajFrekfencije(int[] rezultati, int[] frekfencije, int donjaGranica) {
      for (int i = 0; i < frekfencije.length; i++)
         frekfencije[i] = 0;
      for (int x : rezultati)
         frekfencije[x - donjaGranica]++;
   }

   static void prikaziFrekfencijeNumericki(int[] frekfencije, int dg) {
      for (int i = 0; i < frekfencije.length; i++)
         System.out.printf("%d:%d %s", (i + dg),
               frekfencije[i],
               ((i + 1) % 8 == 0) ? "\n" : "\t");
   }

   static void prikaziFrekfencijeGraficki(int[] frekfencije, int dg) {
      for (int i = 0; i < frekfencije.length; i++) {
         System.out.printf("%3d:", i + dg);
         for (int j = 0; j < frekfencije[i]; j++)
            System.out.print("*");
         System.out.println();
      }
   }

   public static void main(String[] args) {
      int[] rezultati =
            {7, -3, 3, 3, 3, 4, 9, 7, 6, 3, 4, 5, 10, 4, 3, 5, 3,
                  4, 5, 3, 3, 2, 5, 7, 9, 1};
      System.out.println("Niz brojeva:");
      for (int x : rezultati)
         System.out.printf("%4d", x);
      int donjaGranica = odrediDonjuGranicu(rezultati);
      int gornjaGranica = odrediGornjuGranicu(rezultati);
      int[] brojPojava = new int[gornjaGranica - donjaGranica + 1];
      izracunajFrekfencije(rezultati, brojPojava, donjaGranica);
      System.out.println("\nBroj pojava (numericki prikaz):");
      prikaziFrekfencijeNumericki(brojPojava, donjaGranica);
      System.out.println("\nBroj pojava (histogram):");
      prikaziFrekfencijeGraficki(brojPojava, donjaGranica);
   }

}
