/*

  Написати Јава програм који омогућује да се:

  1) оформи низ ниски произвољне димензије коју одређује корисник, такав да
  сви чланови низа добију унаред задату вредност (коју такође задаје корисник).

  2) оформи низ реалних бројева произвољне димензије (димензију низа одређује корисник)
  и да сви чланови низа добију унаред задату вредност (коју такође задаје корисник).

 */

// Програм илуструје учитавање вредности са стандардног улаза, коришћењем класе Scanner,
// као и постављање вредности за елементе низа коришћењем метода класе Arrays.
// У овом примеру, користи се наредба import ради краћег записа програма.

class PokretanjeArraysPopunjavanjeNiza {
   public static void main(String[] args) {

      java.util.Scanner skener = new java.util.Scanner(System.in);
      System.out.println("Dimenzija prvog niza");
      int n = skener.nextInt();
      String[] nizNiski = new String[n];
      System.out.println(
            "Vrednost niske - elementa prvog niza");
      String str = skener.next();
      java.util.Arrays.fill(nizNiski, str);
      for (String s : nizNiski)
         System.out.printf("%s ", s);
      System.out.println();

      System.out.println("Dimenzija drugog niza");
      n = skener.nextInt();
      double[] nizBrojeva = new double[n];
      System.out.println("Vrednost broja - elementa drugog niza");
      double x = skener.nextDouble();
      java.util.Arrays.fill(nizBrojeva, x);
      for (int i = 0; i < nizBrojeva.length; i++)
         System.out.printf("%8.2f ", nizBrojeva[i]);
      System.out.println();

      skener.close();
   }
}
