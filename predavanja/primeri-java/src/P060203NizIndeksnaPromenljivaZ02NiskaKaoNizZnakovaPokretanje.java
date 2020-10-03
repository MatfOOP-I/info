class PokretanjeNiskaKaoNizZnakovaPretaga {

   public static void main(String[] komandnaLinija) {
      String text = "beograd";
      String podstring = "raditi";
      boolean pronadjen = false;
      int max = text.length() - podstring.length();

      test:
      for (int i = 0; i <= max; i++) {
         int n = podstring.length();
         int j = i;
         int k = 0;
         while (n-- != 0) {
            if (text.charAt(j++) != podstring.charAt(k++)) {
               continue test;
            }
         }
         pronadjen = true;
         break test;
      }
      System.out.println(pronadjen ? "Pronadjen" : "Nije pronadjen");
   }
}
