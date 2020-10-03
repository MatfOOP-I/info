
class PokretanjeArraysKopiranjeZNizCelih {

   private static void prikazi(int[] niz) {
      for (int x : niz)
         System.out.printf("%10d", x);
      System.out.printf("\n");
   }

   public static void main(String[] args) {
      int[] niz = {23, -7, 5, 6, 4, 34, -23};
      System.out.println("Ceo niz");
      prikazi(niz);

      int[] deoNiza = java.util.Arrays.copyOf(niz, 4);
      System.out.println("Deo niza (prva 4 clana)");
      prikazi(deoNiza);

      int[] prosirenNiz = java.util.Arrays.copyOf(niz, 11);
      System.out.println("Prosiren niz (sadrzi 11 elemenata)");
      prikazi(prosirenNiz);
   }

}


