public class P050401OmotacCelogBrojaZ03LongrPokretanje {
   public static void main(String[] args) {
      Long longBroj1 = 42L;
      Long longBroj2 = Long.parseLong("2600");
      Long longBroj3 = Long.parseLong("2A", 16);

      System.out.printf("longBroj1: %s\n", longBroj1);
      System.out.printf("longBroj2: %s\n", longBroj2);
      System.out.printf("longBroj3: %s\n", longBroj3);

      System.out.printf("\nheskod (hex) za longBroj1: %08x\n", longBroj1.hashCode());
      System.out.printf("heskod (dec) za longBroj1: %d\n", longBroj1.hashCode());
      System.out.printf("heskod (hex) za longBroj2: %08x\n", longBroj2.hashCode());
      System.out.printf("heskod (dec) za longBroj2: %d\n", longBroj2.hashCode());
      System.out.printf("heskod (hex) za longBroj3: %08x\n", longBroj3.hashCode());
      System.out.printf("heskod (dec) za longBroj3: %d\n\n", longBroj3.hashCode());

      if (longBroj1.equals(longBroj2))
         System.out.printf("prva dva broja su jednaki (equals)\n");
      else
         System.out.printf("prva dva broja nisu jednaki (equals)\n");
      if (longBroj1.equals(longBroj3))
         System.out.printf("prva i treci broj su jednaki (equals)\n");
      else
         System.out.printf("prva i treci broj nisu jednaki (equals)\n");
      if (longBroj2.equals(longBroj3))
         System.out.printf("poslednja dva broja su jednaki (equals)\n");
      else
         System.out.printf("poslednja dva broja nisu jednaki (equals)\n");
      
      int poredjenje = longBroj1.compareTo(longBroj2);
      if (poredjenje > 0)
         System.out.printf("longBroj1(%s) > longBroj2(%s)\n", longBroj1, longBroj2);
      else if (poredjenje < 0)
         System.out.printf("longBroj1(%s) < longBroj2(%s)\n", longBroj1, longBroj2);
      else
         System.out.printf("longBroj1(%s) == longBroj2(%s)\n", longBroj1, longBroj2);
      poredjenje = longBroj1.compareTo(longBroj3);
      if (poredjenje > 0)
         System.out.printf("longBroj1(%s) > longBroj3(%s)\n", longBroj1, longBroj3);
      else if (poredjenje < 0)
         System.out.printf("longBroj1(%s) < longBroj3(%s)\n", longBroj1, longBroj3);
      else
         System.out.printf("longBroj1(%s) == longBroj3(%s)\n", longBroj1, longBroj3);
      poredjenje = longBroj2.compareTo(longBroj3);
      if (poredjenje > 0)
         System.out.printf("longBroj2(%s) > longBroj3(%s)\n", longBroj2, longBroj3);
      else if (poredjenje < 0)
         System.out.printf("longBroj2(%s) < longBroj3(%s)\n", longBroj2, longBroj3);
      else
         System.out.printf("longBroj2(%s) == longBroj3(%s)\n", longBroj2, longBroj3);

      System.out.printf("\nlongBroj2.byteValue(): %d\n", longBroj2.byteValue());
      System.out.printf("longBroj2.shortValue(): %d\n", longBroj2.shortValue());
      System.out.printf("longBroj2.intValue(): %d\n", longBroj2.intValue());
      System.out.printf("longBroj2.longValue(): %d\n", longBroj2.longValue());
      System.out.printf("longBroj2.floatValue(): %f\n", longBroj2.floatValue());
      System.out.printf("longBroj2.doubleValue(): %f\n", longBroj2.doubleValue());
   }

}
