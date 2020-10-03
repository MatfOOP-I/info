
class PokretanjeObjectKreireanjePoredjenje {

   public static void main(String[] args) {
      Object objekat1 = new Object();
      System.out.println("objekat 1: " + objekat1);
      Object objekat2 = new Object();
      System.out.println("objekat 2: " + objekat2);

      if (objekat1 == objekat2)
         System.out.println("ova dva objekta su isti tj. identicni (==)");
      else
         System.out.println("ova dva objekta nisu isti tj. identicni (==)");
      if (objekat1.equals(objekat2))
         System.out.println("ova dva objekta su jednaki (equals)");
      else
         System.out.println("ova dva objekta nisu jednaki (equals)");

      System.out.printf( "\nheskod za objekat 1: %d\n", objekat1.hashCode());
      System.out.printf( "heskod (hex) za objekat 1: %x\n", objekat1.hashCode());
      System.out.printf( "heskod za objekat 2: %d\n", objekat2.hashCode());
      System.out.printf( "heskod (hex) za objekat 2: %x\n", objekat2.hashCode());

      System.out.println( "\nruntime klasa za objekat 1: " + objekat1.getClass());
      System.out.println( "runtime klasa za objekat 2: " + objekat2.getClass());

      if( objekat1 instanceof  Object )
         System.out.println("objekat 1 je primerak klase Object");
      else
         System.out.println("objekat 1 nije primerak klase Object");
      if( objekat2 instanceof  Object )
         System.out.println("objekat 2 je primerak klase Object");
      else
         System.out.println("objekat 2 nije primerak klase Object");
   }
}
