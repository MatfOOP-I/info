/*

Класа за реализацију стека који садржи бројеве у покретном зарезу.

Стек се реализује преко низа. 

Стек може да расте по потреби.
 
 
 */

package rs.math.oop1.z070401.definicjeMetoda.z07.digitronPostfiksni;

class StekRealnihBrojeva {

   double[] elementi;
   int vrhSteka;

   void init() {
      elementi = new double[8];
      vrhSteka = -1;
   }

   void push(double elem) {
      if (vrhSteka == elementi.length - 1) {
         double[] temp = elementi;
         elementi = new double[2 * temp.length];
         for (int i = 0; i < temp.length; i++)
            elementi[i] = temp[i];
      }
      elementi[++vrhSteka] = elem;
   }

   double pop() {
      if (vrhSteka == -1) {
         System.out.println("Greska POP: StekNiski je prazan!");
         return -1;
      }
      return elementi[vrhSteka--];
   }

   int brojElemenata() {
      return (vrhSteka + 1);
   }
}
