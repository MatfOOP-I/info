/*
  
Написати Јава програм који омогућује да се секвенца ниски прикажe у обрнутом 
редоследу, и то коришћењем стека који садржи ниске.

Структура за стек ниски, која се користе у решењу, је издвојена у посебну класу.

Стек ниски је реализован преко низа и може да расте по потреби.
 
 */

// Задатак илуструје примену једноструко повезане листе за реализацију стека.

package rs.math.oop1.z070603.konstruktori.z07.okretanjeSteka;

public class PokretanjeOkretanjeStek {

   public static void main(String[] args) {
      String[] sekvenca =
      { "jedan", "2", "tri", "4", "pet" };
      for (String s : sekvenca)
         System.out.printf("%s\t", s);
      System.out.println();
      StekNiskiPrekoListe stek = new StekNiskiPrekoListe();
      for (String s : sekvenca)
         stek.push(s);
      System.out.println("Broj elemenata na steku: "
               + stek.brojElemenata());
      while (stek.brojElemenata() > 0)
         System.out.printf("%s\t", stek.pop());
      System.out.println();
   }
}
