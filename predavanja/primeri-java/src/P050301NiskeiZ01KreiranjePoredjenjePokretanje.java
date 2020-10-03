class PokretanjeNiskeKreiranjePoredjenje {

   public static void main(String[] args) {
      String niska1 = new String("Ovo je neki tekst.");
      String niska2 = "Ovo je neki tekst.";
      String niska3 = niska1;

      System.out.printf("niska 1: %s\n", niska1);
      System.out.printf("niska 2: %s\n", niska2);
      System.out.printf("niska 3: %s\n", niska3);

      if (niska1 == niska2)
         System.out.printf("prve dve niske su iste (==)\n");
      else
         System.out.printf("prve dve niske nisu iste (==)\n");
      if (niska1.equals(niska2))
         System.out.printf("prve dve niske su jednake (equals)\n");
      else
         System.out.printf("prve dve aute nisu jednaka (equals)\n");

      if (niska1 == niska3)
         System.out.printf("prva i poslednja niska su iste (==)\n");
      else
         System.out.printf("prva i poslednja niska nisu iste (==)\n");
      if (niska1.equals(niska3))
         System.out.printf("prva i poslednja niska su jednake (equals)\n");
      else
         System.out.printf("prva i poslednja niska nisu jednake (equals)\n");

      if (niska2 == niska3)
         System.out.printf("poslednje dve niske su iste (==)\n");
      else
         System.out.printf("poslednje dve niske nisu iste (==)\n");
      if (niska2.equals(niska3))
         System.out.printf("poslednje dve niske su jednake (equals)\n");
      else
         System.out.printf("poslednje dve niske nisu jednake (equals)\n");

      System.out.printf("heskod za niska 1: %d\n", niska1.hashCode());
      System.out.printf("heskod za niska 2: %d\n", niska2.hashCode());
      System.out.printf("heskod za niska 3: %d\n", niska3.hashCode());

      System.out.printf("runtime klasa za niska 1: %s\n", niska1.getClass());

      if (niska1 instanceof String)
         System.out.printf("niska 1 je primerak klase String\n");
      else
         System.out.printf("niska 1 nije primerak klase String\n");
      if (niska1 instanceof Object)
         System.out.printf("niska 1 je primerak klase Object\n");
      else
         System.out.printf("niska 1 nije primerak klase Object\n");
   }
}


