/*
  
Написати Јава програм који омогућује да се секвенца реалних бројева
прикаже у обрнутом редоследу.
 
 */

// Програм илуструје реализацију стека  преко глобалних променљивих. 

class PokretanjeJednodimenzionalniNizOkretanjePrekoSteka {

   static double[] stek;
   static int vrhSteka;

   static void initStek(int dimenzija) {
      stek = new double[dimenzija];
      vrhSteka = -1;
   }

   static void push(double elem) {
      if (vrhSteka == stek.length - 1) {
         System.err.println("Greska PUSH: StekNiski je pun!");
         return;
      }
      stek[++vrhSteka] = elem;
   }

   static double pop() {
      if (vrhSteka == -1) {
         System.err.println("Greska POP: StekNiski je prazan!");
         return -1;
      }
      return stek[vrhSteka--];
   }

   static int brojElemenata() {
      return (vrhSteka + 1);
   }

   public static void main(String[] args) {
      double[] sekvenca =
            {13.4, 7.4, 6.3, 3.2, 8};
      System.out.println("Sekvenca");
      for (int i = 0; i < sekvenca.length; i++)
         System.out.printf("%10.4f", sekvenca[i]);
      initStek(sekvenca.length);
      int i = 0;
      while (i < sekvenca.length) {
         double x = sekvenca[i];
         push(x);
         i++;
      }
      System.out.println("\nObrnuta sekvenca");
      while (brojElemenata() > 0)
         System.out.printf("%10.4f", pop());
   }
}
