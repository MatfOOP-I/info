package rs.math.oop1.z070401.definicjeMetoda.z01stekPrekoNizaFiksan;

/*

Класа за реализацију стека који садржи целе бројеве.

Стек се реализује преко низа.
 
 */

class StekNiski {

   String[] elementi;
   int vrhSteka;

   void init(int dimenzija) {
      elementi = new String[dimenzija];
      vrhSteka = -1;
   }

   void push(String elem) {
      if (vrhSteka == elementi.length - 1) {
         System.out.println("Greska PUSH: StekNiski je pun!");
         return;
      }
      elementi[++vrhSteka] = elem;
   }

   String pop() {
      if (vrhSteka == -1) {
         System.out.println("Greska POP: StekNiski je prazan!");
         return "<nema>";
      }
      return elementi[vrhSteka--];
   }

   int brojElemenata() {
      return (vrhSteka + 1);
   }
}
