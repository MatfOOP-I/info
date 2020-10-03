class PokretanjeOmotacIntegerMetodi {
   public static void main(String[] args) {
      Integer ceoBroj1 = Integer.valueOf("42");
      Integer ceoBroj2 = Integer.parseInt("2600");
      Integer ceoBroj3 = Integer.parseInt("2A", 16);

      System.out.printf("ceoBroj1: %s\n", ceoBroj1);
      System.out.printf("ceoBroj2: %s\n", ceoBroj2);
      System.out.printf("ceoBroj3: %s\n", ceoBroj3);

      System.out.printf("\nheskod (hex) za ceoBroj1: %08x\n", ceoBroj1.hashCode());
      System.out.printf("heskod (dec) za ceoBroj1: %d\n", ceoBroj1.hashCode());
      System.out.printf("heskod (hex) za ceoBroj2: %08x\n", ceoBroj2.hashCode());
      System.out.printf("heskod (dec) za ceoBroj2: %d\n", ceoBroj2.hashCode());
      System.out.printf("heskod (hex) za ceoBroj3: %08x\n", ceoBroj3.hashCode());
      System.out.printf("heskod (dec) za ceoBroj3: %d\n\n", ceoBroj3.hashCode());

      int poredjenje = ceoBroj1.compareTo(ceoBroj2);
      if (poredjenje > 0)
         System.out.printf("ceoBroj1(%s) > ceoBroj2(%s)\n", ceoBroj1, ceoBroj2);
      else if (poredjenje < 0)
         System.out.printf("ceoBroj1(%s) < ceoBroj2(%s)\n", ceoBroj1, ceoBroj2);
      else
         System.out.printf("ceoBroj1(%s) == ceoBroj2(%s)\n", ceoBroj1, ceoBroj2);
      poredjenje = ceoBroj1.compareTo(ceoBroj3);
      if (poredjenje > 0)
         System.out.printf("ceoBroj1(%s) > ceoBroj3(%s)\n", ceoBroj1, ceoBroj3);
      else if (poredjenje < 0)
         System.out.printf("ceoBroj1(%s) < ceoBroj3(%s)\n", ceoBroj1, ceoBroj3);
      else
         System.out.printf("ceoBroj1(%s) == ceoBroj3(%s)\n", ceoBroj1, ceoBroj3);
      poredjenje = ceoBroj2.compareTo(ceoBroj3);
      if (poredjenje > 0)
         System.out.printf("ceoBroj2(%s) > ceoBroj3(%s)\n", ceoBroj2, ceoBroj3);
      else if (poredjenje < 0)
         System.out.printf("ceoBroj2(%s) < ceoBroj3(%s)\n", ceoBroj2, ceoBroj3);
      else
         System.out.printf("ceoBroj2(%s) == ceoBroj3(%s)\n", ceoBroj2, ceoBroj3);

      System.out.printf("\nceoBroj2.byteValue(): %d\n", ceoBroj2.byteValue());
      System.out.printf("ceoBroj2.intValue(): %d\n", ceoBroj2.intValue());
      System.out.printf("ceoBroj2.longValue(): %d\n", ceoBroj2.longValue());
      System.out.printf("ceoBroj2.doubleValue(): %f\n", ceoBroj2.doubleValue());

      System.out.printf("\nceoBroj3.byteValue(): %d\n", ceoBroj3.byteValue());
      System.out.printf("ceoBroj3.intValue(): %d\n", ceoBroj3.intValue());
      System.out.printf("ceoBroj3.longValue(): %d\n", ceoBroj3.longValue());
      System.out.printf("ceoBroj3.doubleValue(): %f\n", ceoBroj3.doubleValue());

      int x = 42;
      System.out.printf("\nInteger.toBinaryString(%d): %s\n", x, Integer.toBinaryString(x));
      System.out.printf("Integer.toOctalString(%d): %s\n", x, Integer.toOctalString(x));
      System.out.printf("Integer.toHexString(%d): %s\n", x, Integer.toHexString(x));
      System.out.printf("Integer.toString(%d): %s\n", x, Integer.toString(x));

      Integer max = Integer.max(ceoBroj1, ceoBroj2);
      System.out.printf("\nmax za %d i %d: %d\n", ceoBroj1, ceoBroj2, max);
      Integer min = Integer.min(ceoBroj1, ceoBroj2);
      System.out.printf("min za %d i %d: %d\n", ceoBroj1, ceoBroj2, min);
      Integer sum = Integer.sum(ceoBroj1, ceoBroj2);
      System.out.printf("suma za %d i %d: %d\n", ceoBroj1, ceoBroj2, sum);
   }
}
