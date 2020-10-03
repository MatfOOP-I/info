class PokretanjeArgumentiPromenljiveDuzinePodeliPrikazi {

   static void prikazi(double... a) {
      for (double x : a)
         System.out.printf("%8.2f ", x);
      System.out.printf("\n");
   }

   static double[] podeli(int delilac, int... a) {
      double[] rez = new double[a.length];
      for (int i = 0; i < a.length; i++)
         rez[i] = (double) a[i] / delilac;
      return rez;
   }

   public static void main(String... args) {
      prikazi(podeli(2, 3));
      prikazi(podeli(2, 3, 4));
      prikazi(podeli(2, 3, 4, 5));
      prikazi(podeli(2, 3, 4, 5, 6, 7, 8));
      prikazi(podeli(2));
      int[] a = {3, 4, 5, 6};
      prikazi(podeli(2, a));
   }

}
