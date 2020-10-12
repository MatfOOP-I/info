/*

Класа за реализацију стека који садржи ниске.

Стек се реализује преко низа. 

Стек може да расте по потреби.
 
 */

package rs.math.oop1.z070401.definicjeMetoda.z06.frekvencijeSaUlazaPrekoSteka;

class StekCelihBrojeva {

   int[] elementi;
   int vrhSteka;

   void init() {
      elementi = new int[10];
      vrhSteka = -1;
   }

   void push(int elem) {
      if (vrhSteka == elementi.length - 1) {
         int[] temp = elementi;
         elementi = new int[2 * temp.length];
         for (int i = 0; i < temp.length; i++)
            elementi[i] = temp[i];
      }
      elementi[++vrhSteka] = elem;
   }

   int pop() {
      if (vrhSteka == -1) {
         System.out.println("Greska POP: StekNiski je prazan!");
         return 0;
      }
      return elementi[vrhSteka--];
   }

   int brojElemenata() {
      return (vrhSteka + 1);
   }
}
