package rs.math.oop1.z100101.tipoviIzuzetaka.z02.indeksVanGranica;

public class PokretanjeIndeksVanGranica2 {

   public static void main(String[] args) {
      long x[] = {1,2,3,4,5};
      try {
         System.out.println(x[0]);
         System.out.println(x[4]);
         //System.out.println(x[44]);
         //System.out.println(x[5]);
         System.out.println(x[-10]);
         System.out.println(x[-1]);
      }
      catch(ArrayIndexOutOfBoundsException aiob)
      {
         System.out.println(aiob);
      }
      System.out.println(x);
   }

}
