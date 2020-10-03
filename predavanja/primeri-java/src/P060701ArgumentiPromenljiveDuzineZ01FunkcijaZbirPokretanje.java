class PokretanjeArgumentiPromenljiveDuzineZbir {


//   static int zbir(int a1, int a2) {
//      return a1 + a2;
//   }
//
//   static int zbir(int a1, int a2, int a3) {
//      return a1 + a2 + a3;
//   }

   static int zbir(int... a) {
      int ret = 0;
      for (int x : a)
         ret += x;
      return ret;
   }

   public static void main(String[] args) {
      System.out.println(zbir(1, 2));
      System.out.println(zbir(1, 2, 3));
      System.out.println(zbir(1, 2, 3, 4, 5, 6));
      System.out.println(zbir(1));
      System.out.println(zbir());
      int[] a = {1, 2, 3, 4};
      System.out.println(zbir(a));
   }

}
