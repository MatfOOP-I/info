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

package rs.math.oop1.z080204.interfejsi.z04.stek;

import java.util.Scanner;

public class PokretanjeOkretanjeStek {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Unesi tekst(<Ctrl>+z ili <Ctrl>+d za kraj):");
      StekNiski stek = new StekNiskiPrekoListe();
      while (sc.hasNext())
         stek.push(sc.next());
      System.out.println("Broj elemenata na steku: "
            + stek.brojElemenata());
      while (stek.brojElemenata() > 0)
         System.out.printf("%s\t", stek.pop());
      System.out.println();
   }
}
