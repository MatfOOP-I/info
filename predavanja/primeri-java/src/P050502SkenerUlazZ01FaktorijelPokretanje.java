public class P050502SkenerUlazZ01FaktorijelPokretanje {

   static long faktorijel(int n) {
      if (n == 0 || n == 1)
         return 1;
      return n * faktorijel(n - 1);
   }

   public static void main(String[] args) {
      System.out.printf("Unesite broj:\n");
      java.util.Scanner skener = new java.util.Scanner(System.in);
      int n = skener.nextInt();
      skener.close();
      for (int i = 0; i <= n; i++)
         System.out.printf("%3d! = %d\n", i, faktorijel(i));
   }
}
