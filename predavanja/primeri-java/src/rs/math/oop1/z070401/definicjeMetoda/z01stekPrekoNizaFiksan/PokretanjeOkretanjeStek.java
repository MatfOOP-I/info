/*
  
Написати Јава програм који омогућује да се две секвенце реалних бројева
и једна секвенца ниски прикажу у обрнутом редоследу, и то тако
да се прво прикаже прво обрнута прва, па обрнута трећа и на крају обрнута
друга секвенце.

Структуре за стек целих и реалних бројева, које се користе у решењу, су 
издвојене у посебну класу.
 
 */

// Програм илуструје реализацију стека. Стек не може да расте.
// Стекови за разне типове података су реализовани као одвојене класе.

package rs.math.oop1.z070401.definicjeMetoda.z01stekPrekoNizaFiksan;

public class PokretanjeOkretanjeStek {

   public static void main(String[] args) {
      double[] sekvenca1 =
      { 13.4, 7.4, 6.3, 3.2, 4, 51, 6.2, 4.7, 3, 14.5, -7.6,
               0, 25 };
      double[] sekvenca2 =
      { -3.4, -0.4, -3.3, 83.2, -4 };
      String[] sekvenca3 =
      { "jedan", "2", "tri", "4", "pet" };
      
      System.out.println("Sekvence");
      for (double x : sekvenca1)
         System.out.printf("%10.4f", x);
      System.out.println();
      for (double x : sekvenca2)
         System.out.printf("%10.4f", x);
      System.out.println();
      for (String s : sekvenca3)
         System.out.printf("%s\t", s);
      
      StekRealnihBrojeva stek1 = new StekRealnihBrojeva();
      stek1.init(sekvenca1.length);
      for (double x : sekvenca1)
         stek1.push(x);
      StekRealnihBrojeva stek2 = new StekRealnihBrojeva();
      stek2.init(sekvenca2.length);
      for (double x : sekvenca2)
         stek2.push(x);
      StekNiski stek3 = new StekNiski();
      stek3.init(sekvenca3.length);
      for (String s : sekvenca3)
         stek3.push(s);
      
      System.out.println("\nObrnute sekvence");
      while (stek1.brojElemenata() > 0)
         System.out.printf("%10.4f", stek1.pop());
      System.out.println();
      while (stek3.brojElemenata() > 0)
         System.out.printf("%s\t", stek3.pop());
      System.out.println();
      while (stek2.brojElemenata() > 0)
         System.out.printf("%10.4f", stek2.pop());
   }
}
