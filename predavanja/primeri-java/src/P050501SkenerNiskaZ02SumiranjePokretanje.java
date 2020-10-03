
public class P050501SkenerNiskaZ02SumiranjePokretanje {


   public static void main(String[] args) {
      String izvor = "paja-patak miki-maus 12-23 dusko-dugousko";
      java.util.Scanner skener = new java.util.Scanner(izvor);
      skener.useDelimiter("-");
      StringBuilder rez = new StringBuilder();
      while (skener.hasNext()) {
         String s = skener.next();
         rez.append(s);
         rez.append("|");
      }
      skener.close();
      System.out.printf("nalepljene reci niske \"%s\":\n%s\n\n", izvor, rez);

   }
}
