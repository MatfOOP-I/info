
class PokretanjeArraysPretragaNizCelih {

   public static void main(String[] args) {
      int[] niz = {23, -7, 5, 6, 4, 34, -23, 8};
      System.out.println("Na pocetku");
      for (int x : niz)
         System.out.print(x + " ");
      System.out.println();

      java.util.Arrays.sort(niz);
      System.out.println("Posle sortiranja");
      for (int x : niz)
         System.out.print(x + " ");
      System.out.println();

      System.out.print("Unesite broj koji se trazi: ");
      java.util.Scanner skener = new java.util.Scanner(System.in);
      int traziSe = skener.nextInt();
      int pozicija = java.util.Arrays.binarySearch(niz, 0, niz.length, traziSe);
      if (pozicija >= 0)
         System.out.printf("Broj %d se nalazi u nizu, na poziciji %d. \n", traziSe, pozicija);
      else {
         System.out.printf("Broj %d se ne nalazi u nizu.\n", traziSe);
         System.out.printf("Da bi se sacuvala uredjenost niza, treba ga ubaciti na indeks %d.\n", -(pozicija + 1));
      }
   }

}
