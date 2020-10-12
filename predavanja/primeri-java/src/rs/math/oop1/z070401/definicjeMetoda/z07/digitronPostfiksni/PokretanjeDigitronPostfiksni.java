/*
  
Написати Јава програм који омогућује унос израза у постфиксном облику
и потом израчунава вредност унесеног израза.

У изразу се могу јавити четири основне бинаре операције (+,-,*,/) и унарна 
операција промене знака (~). 
  
Са израчунавањем се завршава када корисник унесе реч "kraj".
    
Функционалност потребну за израчунавање израза издвојити у посебну класу.

*/

// Програм илуструје издвајање функционалности у посебну целину, и коришење стека који 
// може да расте по потреби у циљу чувања оператора и операнада.

package rs.math.oop1.z070401.definicjeMetoda.z07.digitronPostfiksni;

public class PokretanjeDigitronPostfiksni {

   public static void main(String[] args) {
      DigitronPostfiksni digitron = new DigitronPostfiksni();
      digitron.init();
      java.util.Scanner skener = new java.util.Scanner(System.in);
      while (true) {
         System.out.println(
                  "Unesi izraz u postfiksnom obliku (kraj za zavrsetak)");
         String s = skener.nextLine().trim();
         if (s.equals("kraj"))
            break;
         System.out.println(
                  "Rezultat: " + digitron.izracunaj(s));
      }
      skener.close();
   }
}
