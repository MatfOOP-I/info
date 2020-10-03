
class Auto {
   int brojTockova;
   int brojPutnika;
   float zapreminaMotora;
}

public class P050201ObjectiZ03KlasaPokretanjep {
   public static void main(String[] args) {
      Auto auto1 = new Auto();
      auto1.brojTockova = 4;
      auto1.brojPutnika = 4;
      auto1.zapreminaMotora = 1500;
      System.out.printf("auto 1: %s\n", auto1);
      Auto auto2 = new Auto();
      auto2.brojTockova = 4;
      auto2.brojPutnika = 4;
      auto2.zapreminaMotora = 1500;
      System.out.printf("auto 2: %s\n", auto2);
      Auto auto3 = auto1;
      System.out.printf("auto 3: %s\n", auto3);

      if (auto1 == auto2)
         System.out.printf("prva dva auta su isti (==)\n");
      else
         System.out.printf("prva dva auta nisu isti (==)\n");
      if (auto1.equals(auto2))
         System.out.printf("prva dva auta su jednaki (equals)\n");
      else
         System.out.printf("prva dva auta nisu jednaki (equals)\n");

      if (auto1 == auto3)
         System.out.printf("prvi i poslednji auto su isti (==)\n");
      else
         System.out.printf("prvi i poslednji auto nisu isti (==)\n");
      if (auto1.equals(auto3))
         System.out.printf("prvi i poslednji auto su jednaki (equals)\n");
      else
         System.out.printf("prvi i poslednji auto nisu jednaki (equals)\n");

      if (auto2 == auto3)
         System.out.printf("poslednja dva auta su isti (==)\n");
      else
         System.out.printf("poslednja dva auta nisu isti (==)\n");
      if (auto2.equals(auto3))
         System.out.printf("poslednja dva auta su jednaki (equals)\n");
      else
         System.out.printf("poslednja dva auta nisu jednaki (equals)\n");

      System.out.printf("\nheskod (hex) za auto 1: %x\n", auto1.hashCode());
      System.out.printf("heskod (hex) za auto 2: %x\n", auto2.hashCode());
      System.out.printf("heskod (hex) za auto 3: %x\n", auto3.hashCode());

      System.out.printf("\nruntime klasa za auto 1: %s\n", auto1.getClass());
      System.out.printf("runtime klasa za auto 2: %s\n", auto2.getClass());
      System.out.printf("runtime klasa za auto 3: %s\n\n", auto3.getClass());

      if (auto1 instanceof Auto)
         System.out.printf("auto 1 je primerak klase Auto\n");
      else
         System.out.printf("auto 1 nije primerak klase Auto\n");
      if (auto1 instanceof Object)
         System.out.printf("auto 1 je primerak klase Object\n");
      else
         System.out.printf("auto 1 nije primerak klase Object\n");
   }
}
