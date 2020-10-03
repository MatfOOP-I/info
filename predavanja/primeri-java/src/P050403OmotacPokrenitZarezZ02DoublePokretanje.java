public class P050403OmotacPokrenitZarezZ02DoublePokretanje {
   public static void main(String[] args) {
      Double brojPokretniZarez1 = 42.0;
      Double brojPokretniZarez2 = Double.parseDouble("42");
      Double brojPokretniZarez3 = Double.parseDouble("42e10");

      System.out.printf("brojPokretniZarez1: %s\n", brojPokretniZarez1);
      System.out.printf("brojPokretniZarez2: %s\n", brojPokretniZarez2);
      System.out.printf("brojPokretniZarez3: %s\n", brojPokretniZarez3);

      if (brojPokretniZarez1.equals(brojPokretniZarez2))
         System.out.printf("prva dva broja su jednaki (equals)\n");
      else
         System.out.printf("prva dva boja nisu jednaki (equals)\n");
      if (brojPokretniZarez2.equals(brojPokretniZarez3))
         System.out.printf("poslednja dva broja su jednaki (equals)\n");
      else
         System.out.printf("pposlednja dva boja nisu jednaki (equals)\n");

      int poredjenje = brojPokretniZarez1.compareTo(brojPokretniZarez2);
      if (poredjenje > 0)
         System.out.printf("brojPokretniZarez1('%s') > brojPokretniZarez1('%s')\n",
               brojPokretniZarez1, brojPokretniZarez2);
      else if (poredjenje < 0)
         System.out.printf("brojPokretniZarez1('%s') < brojPokretniZarez2('%s')\n",
               brojPokretniZarez1, brojPokretniZarez2);
      else
         System.out.printf("brojPokretniZarez1('%s') == brojPokretniZarez2('%s')\n",
               brojPokretniZarez1, brojPokretniZarez2);
      poredjenje = brojPokretniZarez1.compareTo(brojPokretniZarez3);
      if (poredjenje > 0)
         System.out.printf("brojPokretniZarez1('%s') > brojPokretniZarez3('%s')\n",
               brojPokretniZarez1, brojPokretniZarez3);
      else if (poredjenje < 0)
         System.out.printf("brojPokretniZarez1('%s') < brojPokretniZarez3('%s')\n",
               brojPokretniZarez1, brojPokretniZarez3);
      else
         System.out.printf("brojPokretniZarez1('%s') == brojPokretniZarez3('%s')\n",
               brojPokretniZarez1, brojPokretniZarez3);
      poredjenje = brojPokretniZarez2.compareTo(brojPokretniZarez3);
      if (poredjenje > 0)
         System.out.printf("brojPokretniZarez2('%s') > brojPokretniZarez3('%s')\n",
               brojPokretniZarez2, brojPokretniZarez3);
      else if (poredjenje < 0)
         System.out.printf("brojPokretniZarez2('%s') < brojPokretniZarez3('%s')\n",
               brojPokretniZarez2, brojPokretniZarez3);
      else
         System.out.printf("brojPokretniZarez2('%s') == brojPokretniZarez3('%s')\n",
               brojPokretniZarez2, brojPokretniZarez3);

      System.out.printf("\nbrojPokretniZarez1 hashCode(): %d\n", brojPokretniZarez1.hashCode());
      System.out.printf("brojPokretniZarez2 hashCode(): %d\n", brojPokretniZarez2.hashCode());
      System.out.printf("brojPokretniZarez3 hashCode(): %d\n", brojPokretniZarez3.hashCode());

      System.out.printf("\n%s.intValue(): %d\n", brojPokretniZarez1, brojPokretniZarez1.intValue());
      System.out.printf("%s.intValue(): %d\n", brojPokretniZarez2, brojPokretniZarez2.intValue());
      System.out.printf("%s.intValue(): %d\n", brojPokretniZarez3, brojPokretniZarez3.intValue());
      System.out.printf("%s.isInfinite(): %b\n", brojPokretniZarez1, brojPokretniZarez1.isInfinite());
      System.out.printf("%s.isInfinite(): %b\n", brojPokretniZarez2, brojPokretniZarez2.isInfinite());
      System.out.printf("%s.isInfinite(): %b\n", brojPokretniZarez3, brojPokretniZarez3.isInfinite());
      System.out.printf("%s.isNaN(): %b\n", brojPokretniZarez1, brojPokretniZarez1.isNaN());
      System.out.printf("%s.isNaN(): %b\n", brojPokretniZarez2, brojPokretniZarez2.isNaN());
      System.out.printf("%s.isNaN(): %b\n", brojPokretniZarez3, brojPokretniZarez3.isNaN());

      double broj1 = -5;

      double min = Double.min(brojPokretniZarez1.doubleValue(), brojPokretniZarez2);
      min = Double.min(min, broj1);
      System.out.printf("\nminimum brojeva %f, %f i %f: %f\n",
            brojPokretniZarez1, brojPokretniZarez2, broj1, min);
      double max = Double.max(brojPokretniZarez1.floatValue(), brojPokretniZarez2);
      max = Double.max(max, broj1);
      System.out.printf("maksimum brojeva %f, %f i %f: %f\n",
            brojPokretniZarez1, brojPokretniZarez2, broj1, max);
      Double sum = Double.sum(brojPokretniZarez1.floatValue(), brojPokretniZarez2);
      sum = Double.sum(sum, broj1);
      System.out.printf("suma brojeva %s, %f i %f: %f\n",
            brojPokretniZarez1, brojPokretniZarez2, broj1, sum);
   }

}
