
/*

Класа за реализацију стека који садржи ниске.

Стек се реализује преко низа. 

Стек може да расте по потреби.
 
 */

package rs.math.oop1.z100103.izuzeciIzbacivanje.z03.stekPrekoNizaKorisnickiIzuzetak;

public class StekNiskiPrekoNizaSamorastuci implements StekNiski {

   private String[] elementi;
   private int vrhSteka;

   // inicijalizacioni blok primerka
   {
      elementi = new String[8];
      vrhSteka = -1;
   }

   @Override
   public void push(String elem) {
      if (vrhSteka == elementi.length - 1) {
         String[] temp = elementi;
         elementi = new String[2 * temp.length];
         for (int i = 0; i < temp.length; i++)
            elementi[i] = temp[i];
      }
      elementi[++vrhSteka] = elem;
   }

   @Override
   public String pop() throws StekJePrazanException {
      if (vrhSteka == -1) {
         throw new StekJePrazanException();
      }
      return elementi[vrhSteka--];
   }

   @Override
   public int brojElemenata() {
      return (vrhSteka + 1);
   }
}
