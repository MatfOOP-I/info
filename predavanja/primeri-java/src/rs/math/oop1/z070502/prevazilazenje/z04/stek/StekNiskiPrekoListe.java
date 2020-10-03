
/*

Класа за реализацију стека који садржи ниске.

Стек се реализује преко једноструко повезане листе. 

Стек може да расте по потреби.
 
 */

package rs.math.oop1.z070502.prevazilazenje.z04.stek;

public class StekNiskiPrekoListe extends Stek {

   private PovezanaLista elementi = new PovezanaLista();

   @Override
   public void push(String elem) {
      elementi.dodajElemenatNaPocetak(elem);
   }

   @Override
   public String pop() {
      String elem = elementi.ukloniElemenatSaPocetka();
      if (elem == null) {
         System.out.println("Greska POP: StekNiski je prazan!");
         return "<nema>";
      }
      return elem;
   }

   @Override
   public int brojElemenata() {
      String elem = elementi.getPrvi();
      if (elem == null)
         return 0;
      int n = 0;
      while (elem != null) {
         n++;
         elem = elementi.getSledeci();
      }
      return n;
   }

   @Override
   public String toString() {
      String s = "[";
      String elem = elementi.getPrvi();
      if (elem == null)
         return "[]";
      while (elem != null) {
         s += elem + ", ";
         elem = elementi.getSledeci();
      }
      return s.substring(0, s.length() - 2) + "]";
   }
}
