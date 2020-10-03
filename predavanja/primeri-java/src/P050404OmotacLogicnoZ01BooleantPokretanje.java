public class P050404OmotacLogicnoZ01BooleantPokretanje {
   public static void main(String[] args) {
      Boolean logickaVrednost1 = Boolean.TRUE;
      Boolean logickaVrednost2 = Boolean.parseBoolean("false");
      Boolean logickaVrednost3 = Boolean.valueOf("true");

      System.out.printf("logickaVrednost1: %s\n", logickaVrednost1);
      System.out.printf("logickaVrednost1: %s\n", logickaVrednost2);
      System.out.printf("logickaVrednost3: %s\n", logickaVrednost3);

      if (logickaVrednost1.equals(logickaVrednost2))
         System.out.printf("prva dva broja su jednaki (equals)\n");
      else
         System.out.printf("prva dva boja nisu jednaki (equals)\n");
      if (logickaVrednost2.equals(logickaVrednost3))
         System.out.printf("poslednja dva broja su jednaki (equals)\n");
      else
         System.out.printf("pposlednja dva boja nisu jednaki (equals)\n");

      int poredjenje = logickaVrednost1.compareTo(logickaVrednost2);
      if (poredjenje > 0)
         System.out.printf("logickaVrednost1('%s') > logickaVrednost1('%s')\n",
               logickaVrednost1, logickaVrednost2);
      else if (poredjenje < 0)
         System.out.printf("logickaVrednost1('%s') < logickaVrednost2('%s')\n",
               logickaVrednost1, logickaVrednost2);
      else
         System.out.printf("logickaVrednost1('%s') == logickaVrednost2('%s')\n",
               logickaVrednost1, logickaVrednost2);
      poredjenje = logickaVrednost1.compareTo(logickaVrednost3);
      if (poredjenje > 0)
         System.out.printf("logickaVrednost1('%s') > logickaVrednost3('%s')\n",
               logickaVrednost1, logickaVrednost3);
      else if (poredjenje < 0)
         System.out.printf("logickaVrednost1('%s') < logickaVrednost3('%s')\n",
               logickaVrednost1, logickaVrednost3);
      else
         System.out.printf("logickaVrednost1('%s') == logickaVrednost3('%s')\n",
               logickaVrednost1, logickaVrednost3);
      poredjenje = logickaVrednost2.compareTo(logickaVrednost3);
      if (poredjenje > 0)
         System.out.printf("logickaVrednost2('%s') > logickaVrednost3('%s')\n",
               logickaVrednost2, logickaVrednost3);
      else if (poredjenje < 0)
         System.out.printf("logickaVrednost2('%s') < logickaVrednost3('%s')\n",
               logickaVrednost2, logickaVrednost3);
      else
         System.out.printf("logickaVrednost2('%s') == logickaVrednost3('%s')\n",
               logickaVrednost2, logickaVrednost3);

      System.out.printf("\nlogickaVrednost1 hashCode(): %x\n", logickaVrednost1.hashCode());
      System.out.printf("logickaVrednost2 hashCode(): %x\n", logickaVrednost2.hashCode());
      System.out.printf("logickaVrednost3 hashCode(): %x\n", logickaVrednost3.hashCode());

      System.out.printf("\n%s.booleanValue(): %b\n", logickaVrednost1, logickaVrednost1.booleanValue());
      System.out.printf("%s.booleanValue(): %b\n", logickaVrednost2, logickaVrednost2.booleanValue());
      System.out.printf("%s.booleanValue(): %b\n", logickaVrednost3, logickaVrednost3.booleanValue());

      boolean b1 = true;
      boolean b2 = logickaVrednost1.booleanValue();
      System.out.printf("\n%b and %b: %b\n", b1, b2, Boolean.logicalAnd(b1, b2));
      System.out.printf("%b or %b: %b\n", b1, b2, Boolean.logicalOr(b1, b2));
      System.out.printf("%b xor %b: %b\n", b1, b2, Boolean.logicalXor(b1, b2));
   }

}
