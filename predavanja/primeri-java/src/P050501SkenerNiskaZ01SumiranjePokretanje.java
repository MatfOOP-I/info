
public class P050501SkenerNiskaZ01SumiranjePokretanje {


   public static void main(String[] args) {
      String izvor = "paja patak\n miki maus 12 23\n dusko dugousko";
      java.util.Scanner skener = new java.util.Scanner(izvor);
      StringBuilder rez = new StringBuilder();
      while (skener.hasNext()) {
         String s = skener.next();
         rez.append(s);
         rez.append("|");
      }
      skener.close();
      System.out.printf("nalepljene reci niske \n \"%s\":\n%s\n\n", izvor, rez);

      izvor = "1 2 3 4 -3 -8 0";
      skener = new java.util.Scanner(izvor);
      int suma = 0;
      while (skener.hasNext()) {
         int i = skener.nextInt();
         suma += i;
      }
      skener.close();
      System.out.printf("suma celih brojeva niske\n \"%s\":\n%d\n\n", izvor, suma);

      izvor = "1 2 3.5 4.3 -3e1";
      skener = new java.util.Scanner(izvor);
      double suma1 = 0;
      while (skener.hasNext()) {
         double x = skener.nextDouble();
         suma1 += x;
      }
      skener.close();
      System.out.printf("suma brojeva niske \"%s\":\n%f\n\n", izvor, suma1);

   }
}
