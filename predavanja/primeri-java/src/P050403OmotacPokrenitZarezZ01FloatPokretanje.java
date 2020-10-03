public class P050403OmotacPokrenitZarezZ01FloatPokretanje {
   public static void main(String[] args) {
      Float brojPokretniZarez1 = 42.0f;
      Float brojPokretniZarez2 = Float.parseFloat("42");
      Float brojPokretniZarez3 = Float.parseFloat("42e10");

      System.out.printf("brojPokretniZarez1: %f\n", brojPokretniZarez1);
      System.out.printf("brojPokretniZarez2: %s\n", brojPokretniZarez2);
      System.out.printf("brojPokretniZarez3: %s\n", brojPokretniZarez3);

      System.out.printf("\nbrojPokretniZarez1 hashCode() - dec: %d\n", brojPokretniZarez1.hashCode());
      System.out.printf("brojPokretniZarez1 hashCode() - hex: %x\n", brojPokretniZarez1.hashCode());
      System.out.printf("brojPokretniZarez2 hashCode() - dec: %d\n", brojPokretniZarez2.hashCode());
      System.out.printf("brojPokretniZarez2 hashCode() - hex: %x\n", brojPokretniZarez2.hashCode());
      System.out.printf("brojPokretniZarez3 hashCode() - dec: %d\n", brojPokretniZarez3.hashCode());
      System.out.printf("brojPokretniZarez2 hashCode() - hex: %x\n\n", brojPokretniZarez3.hashCode());


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

      System.out.printf("\n%s.intValue(): %d\n", brojPokretniZarez1, brojPokretniZarez1.intValue());
      System.out.printf("%s.intValue(): %d\n", brojPokretniZarez2, brojPokretniZarez2.intValue());
      System.out.printf("%s.intValue(): %d\n", brojPokretniZarez3, brojPokretniZarez3.intValue());
      System.out.printf("%s.isInfinite(): %b\n", brojPokretniZarez1, brojPokretniZarez1.isInfinite());
      System.out.printf("%s.isInfinite(): %b\n", brojPokretniZarez2, brojPokretniZarez2.isInfinite());
      System.out.printf("%s.isInfinite(): %b\n", brojPokretniZarez3, brojPokretniZarez3.isInfinite());
      System.out.printf("%s.isNaN(): %b\n", brojPokretniZarez1, brojPokretniZarez1.isNaN());
      System.out.printf("%s.isNaN(): %b\n", brojPokretniZarez2, brojPokretniZarez2.isNaN());
      System.out.printf("%s.isNaN(): %b\n", brojPokretniZarez3, brojPokretniZarez3.isNaN());

      float broj1 = 7f;
      float broj2 = -2.7e2f;
      float broj3 = 2.3f/0f;
      float broj4 = Float.NEGATIVE_INFINITY;
      float broj5 = Float.NaN;
      System.out.printf("\nbinarni zapis broja %f: %s\n", broj1, Integer.toBinaryString(Float.floatToIntBits(broj1)));
      System.out.printf("binarni zapis broja %f: %s\n", broj2, Integer.toBinaryString(Float.floatToIntBits(broj2)));
      System.out.printf("binarni zapis broja %f: %s\n", broj3, Integer.toBinaryString(Float.floatToIntBits(broj3)));
      System.out.printf("binarni zapis broja %f: %s\n", broj4, Integer.toBinaryString(Float.floatToIntBits(broj4)));
      System.out.printf("binarni zapis broja %f: %s\n", broj5, Integer.toBinaryString(Float.floatToIntBits(broj5)));

      float min = Float.min(brojPokretniZarez1.floatValue(), broj1);
      min = Float.min( min, broj2);
      System.out.printf("\nminimum brojeva %s, %f i %f: %f\n",  brojPokretniZarez1, broj1, broj2, min );
      float max = Float.max(brojPokretniZarez1.floatValue(), broj1);
      max = Float.max( max, broj2);
      System.out.printf("maksimum brojeva %s, %f i %f: %f\n",  brojPokretniZarez1, broj1, broj2, max );
      Float sum = Float.sum(brojPokretniZarez1.floatValue(), broj1);
      sum = Float.sum( sum, broj2);
      System.out.printf("suma brojeva %s, %f i %f: %f\n",  brojPokretniZarez1, broj1, broj2, sum );
   }

}
