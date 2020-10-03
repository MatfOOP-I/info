package rs.math.oop1.z080302.visekriterijumskoUredjenje.z02.parNepar;

import java.util.Arrays;
import java.util.Comparator;

class ParNeparComparator implements Comparator {

   @Override
   public int compare(Object o1, Object o2) {
      if (!(o1 instanceof Integer))
         return -1;
      if (!(o2 instanceof Integer))
         return 1;
      int i1 = ((Integer) o1).intValue();
      int i2 = ((Integer) o2);
      if (i1 % 2 == 0) {
         if (i2 % 2 == 0)
            return i1 - i2;
         else
            return -1;
      } else {
         if (i2 % 2 == 0)
            return 1;
         else
            return i1 - i2;
      }
   }

}

public class PokretanjeUredjenjeCelihParNepar {



   public static void main(String[] args) {
      Integer[] niz = {-3, 4, -2, 1, 2, 0, 3, 4, -4};

      System.out.println("Pre podrazumevanog sortiranja");
      for (Integer x : niz)
         System.out.print(x + " ");
      System.out.println();

      Arrays.sort(niz);

      System.out.println("Posle podrazumevanog sortiranja");
      for (int x : niz)
         System.out.print(x + " ");
      System.out.println();

      Arrays.sort(niz, new ParNeparComparator());

      System.out.println("Posle par-nepar sortiranja");
      for (int x : niz)
         System.out.print(x + " ");
      System.out.println();

   }

}
