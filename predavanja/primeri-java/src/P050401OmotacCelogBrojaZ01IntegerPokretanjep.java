class PokretanjeOmotacIntegerKreiranjePoredjenje {

   public static void main(String[] args) {
      Integer ceoBroj1 = new Integer(42);
      Integer ceoBroj2 = 42; //skraćeni zapis, autoboxing

      String niskaZaceoBroj1 = ceoBroj1.toString();
      System.out.printf("niska reprezentacija za ceoBroj1: %s\n", niskaZaceoBroj1);
      System.out.printf("ceoBroj2: %s\n", ceoBroj2);

      if (ceoBroj1 == ceoBroj2)
         System.out.printf("dva cela broja su isti (==)\n");
      else
         System.out.printf("dva cela broja nisu isti (==)\n");
      if (ceoBroj1.equals(ceoBroj2))
         System.out.printf("dva cela broja su jednaki (equals)\n");
      else
         System.out.printf("dva cela broja nisu jednaki (equals)\n");

      System.out.printf("\nheskod (hex) za ceoBroj1: %x\n", ceoBroj1.hashCode());
      System.out.printf("heskod (dec) za ceoBroj1: %d\n", ceoBroj1.hashCode());
      System.out.printf("heskod (hex) za ceoBroj2: %x\n", ceoBroj2.hashCode());
      System.out.printf("heskod (dec) za ceoBroj2: %d\n", ceoBroj2.hashCode());

      System.out.printf("\nruntime klasa za niska 1: %s\n", ceoBroj1.getClass());

      if (ceoBroj1 instanceof Integer)
         System.out.printf("ceoBroj1 je primerak klase Integer\n");
      else
         System.out.printf("ceoBroj1 nije primerak klase Integer\n");
      if (ceoBroj1 instanceof Object)
         System.out.printf("ceoBroj1 je primerak klase Object\n");
      else
         System.out.printf("ceoBroj1 nije primerak klase Object\n");
   }
}


