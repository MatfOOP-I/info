public class P050302NiskeiZ01MetodiPokretanje {
   public static void main(String[] args) {
      String niska1 = new String("Ovo je jedna niska.");
      String niska2 = "   Ovo je druga niska.";

      System.out.printf("niska1: %s\n", niska1);
      System.out.printf("niska2: %s\n", niska2);

      System.out.printf("\nniska1.length(): %d\n", niska1.length());
      System.out.printf("\nniska2.trim(): %s\n", niska2.trim());
      System.out.printf("niska1.toLowerCase(): %s\n", niska1.toLowerCase());
      System.out.printf("niska1.toUpperCase(): %s\n", niska1.toUpperCase());

      int pozicija = 2;
      System.out.printf("\nniske1.charAt(%d): %c\n", pozicija, niska1.charAt(pozicija));
      pozicija = 10;
      System.out.printf("niska1.charAt(%d): %c\n", pozicija, niska1.charAt(pozicija));

      int pozicijaPocev = 1;
      int pozicijaDo = 5;
      System.out.printf("\nniska1.substring( %d, %d): %s\n", pozicijaPocev, pozicijaDo,
            niska1.substring(pozicijaPocev, pozicijaDo));

      System.out.printf("\nspoj niski: %s \n", niska1.concat(niska2));
      System.out.printf("spoj niski: %s \n", niska1 + niska2);

      char slovo = 'e';
      System.out.printf("\nniska1.indexOf('%c'): %d\n", slovo, niska1.indexOf(slovo));
      System.out.printf("niska1.lastIndexOf('%c'): %d\n", slovo, niska1.lastIndexOf(slovo));
      String obrazac = "je";
      System.out.printf("niska1.indexOf(\"%s\"): %d\n", obrazac, niska1.indexOf(obrazac));
      System.out.printf("niska1.lastIndexOf(\"%s\"): %d\n", obrazac, niska1.lastIndexOf(obrazac));
      obrazac = "Ov";
      System.out.printf("niska1.startsWith(\"%s\"): %b\n", obrazac, niska1.startsWith(obrazac));
      System.out.printf("niska1.endsWith(\"%s\"): %b\n", obrazac, niska1.endsWith(obrazac));
      obrazac = "a.";
      System.out.printf("niska1.startsWith(\"%s\"): %b\n", obrazac, niska1.startsWith(obrazac));
      System.out.printf("niska1.endsWith(\"%s\"): %b\n", obrazac, niska1.endsWith(obrazac));

      char novoSlovo = '_';
      System.out.printf("niska1.replace('%c','%c'): %s\n", slovo, novoSlovo, niska1.replace(slovo, novoSlovo));
      System.out.printf("\nniska1: %s\n", niska1);

      int broj = 42;
      String niskaFormat = "XXX  %d  XXX";
      String niskaReprezentacija = String.format(niskaFormat, broj);
      System.out.printf("\nreprezentacija broja %d po formatu \"%s\": \"%s\"\n",
            broj, niskaFormat, niskaReprezentacija);
      niskaFormat = "---%06x---";
      System.out.printf("reprezentacija broja %d po formatu \"%s\": \"%s\"\n",
            broj, niskaFormat, String.format(niskaFormat, broj));
      niskaFormat = "%o\t. ";
      System.out.printf("reprezentacija broja %d po formatu \"%s\": \"%s\"\n",
            broj, niskaFormat, String.format(niskaFormat, broj));
      broj = -71;
      niskaFormat = "XXX  %d  XXX";
      System.out.printf("reprezentacija broja %d po formatu \"%s\": \"%s\"\n",
            broj, niskaFormat, String.format(niskaFormat, broj));
      niskaFormat = "---%06x---";
      System.out.printf("reprezentacija broja %d po formatu \"%s\": \"%s\"\n",
            broj, niskaFormat, String.format(niskaFormat, broj));
      niskaFormat = "%o\t. ";
      System.out.printf("reprezentacija broja %d po formatu \"%s\": \"%s\"\n",
            broj, niskaFormat, String.format(niskaFormat, broj));

   }
}
