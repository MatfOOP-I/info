/*
  
Написати Јава програм који чита са стандардног улаза све унесене речи и те речи
потом приказује на стандардни излаз у обрнутом редоследу.
    
Задатак ће се реаизовати коришењем струкуре података стек.

Број речи није унапред познат, па треба оформити стек који по потреби "расте".

Комбинација тастера којом корисник означава крај уноса зависи од оперативног
система рачунара на ком се извршава овај програм, обично је то <Ctrl>+z за 
Windows системе, односно <Ctrl>+d за Unix системе 

*/

// Програм илуструје коришење стека који може да расте по потреби у циљу
// чувања и преписа података.

package rs.math.oop1.z070401.definicjeMetoda.z05.stekPrekoNizaRaste;


public class PokretanjeObratnoSveReci {

   public static void main(String[] args) {
      System.out.println(
               "Unesi tekst(<Ctrl>+d ili <Ctrl>+z za kraj):");
      StekNiski reci = new StekNiski();
      reci.init();
      java.util.Scanner skener = new java.util.Scanner(System.in);
      while (skener.hasNext()) {
         String rec = skener.next();
         reci.push(rec);
      }
      skener.close();
      System.out.println(
               "\nReci teksta u obratnom redosledu su:");
      while (reci.brojElemenata() > 0)
         System.out.print(reci.pop() + " ");
   }
}
