public class P050105IzlazIzProgramaZ01IlustracijaPokretanje {


   public static void main(String[] args) {
      int n = 49;
      System.out.println("faktori broja " + n + " su:");
      prikaziFaktore(n);
      System.out.println("ovo nece biti prikazano");
   }

   static void prikaziFaktore(int n) {
      for (int i = 1; i <= n; i++)
         if (n % i == 0)
            System.out.print(i + "\t");
      System.out.println();
      if (n % 2 == 0)
         System.exit(0);
      else
         System.exit(12);
      System.out.println("ovo nece biti prikazano");
   }
}
