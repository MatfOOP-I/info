/*
  
Написати Јава програм који омогућује да се секвенца ниски прикажe у обрнутом 
редоследу, и то коришћењем стека који садржи ниске.

Структурe за реализацију стека ниски, која се користе у решењу, су издвојене у 
посебну класу.

Стек ниски је реализован на два начина: преко низа који може да расте по потреби
и преко повезане листе. 

Сам рад програма не зависи од тога која је реализација изабрана приликом креирања
стека.
 
 */

// Задатак илуструје превазилажење метода toString.
// Задатак илуструје коришћење анотације @Override.

package rs.math.oop1.z070502.prevazilazenje.z04.stek;

public class PokretanjeOkretanjeStek {

   public static void main(String[] args) {
      String[] sekvenca =
      { "jedan", "2", "tri", "4", "pet" };
      for (String s : sekvenca)
         System.out.printf("%s\t", s);
      System.out.println();
      //StekNiski stek = new StekNiskiPrekoPovezaneListe();
      Stek stek = new StekNiskiPrekoNiza();
      for (String s : sekvenca)
         stek.push(s);
      System.out.println("StekNiski: " + stek);
      while (stek.brojElemenata() > 0)
         System.out.printf("%s\t", stek.pop());
      System.out.println();
   }
}
