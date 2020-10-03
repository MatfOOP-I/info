class PokretanjeKomandnaLinijaZ01NalepljivanjePrikaz {


   public static void main(String[] argumentiKomandneLinije) {
      System.out.printf("Argumenti komandne linije:\n");
      for (String argument : argumentiKomandneLinije)
         System.out.printf("\"%s\" \n", argument);
      System.out.printf("\n");

      System.out.println("Argumenti komandne linije u obratnom redosledu:");
      for (int i = argumentiKomandneLinije.length - 1; i >= 0; i--) {
         String argument = String.format("\"%s\"", argumentiKomandneLinije[i]);
         System.out.println(argument);
      }
      System.out.println();
   }
}
