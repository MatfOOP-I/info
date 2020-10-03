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

// Задатак илуструје наслеђивање, полиморфизам и концепт сакривања информација.

package rs.math.oop1.z100103.izuzeciIzbacivanje.z03.stekPrekoNizaKorisnickiIzuzetak;

public class PokretanjeOkretanjeStek {

   public static void main(String[] args) {
      StekNiski stek = new StekNiskiPrekoNizaSamorastuci();
      stek.push("miki maus");
      stek.push(null);
      stek.push("paja patak");
      stek.push("dusko dugousko");
      try {
         for (int i = 0; i < 5; i++)
            System.out.println(stek.pop());
      }
      catch(Exception e){
         System.err.println(e);
      }
   }
}
