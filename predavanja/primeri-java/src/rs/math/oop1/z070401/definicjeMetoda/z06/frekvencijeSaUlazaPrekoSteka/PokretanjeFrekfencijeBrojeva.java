/*
  
Написати Јава програм који омогућује унос бројева из интервала
и приказује (у бројчаном облику и у облику хистограма) који су све бројеви унсесни.
  
Доња и горња граница интервала се уносе са стандардног улаз. 
Унос се завршава када корисник унесе број ван датог целобројног интервала.  
    
Податке потребне за одређивање и чување броја појава елемената датог низа, 
као и методе за израчунавање броја појава, као и за нумерички и хистограмски 
приказ добијених података издвојити у посебну класу.

*/

// Програм илуструје издвајање функционалности у посебну целину, преоптерећење метода 
// и коришење стека који може да расте по потреби у циљу чувања података чији број 
// иницијално није познат.

package rs.math.oop1.z070401.definicjeMetoda.z06.frekvencijeSaUlazaPrekoSteka;

public class PokretanjeFrekfencijeBrojeva {

   public static void main(String[] args) {
      System.out.println(
               "Unesi donju i gornju granicu intervala:");
      java.util.Scanner skener = new java.util.Scanner(System.in);
      int donja = skener.nextInt();
      int gornja = skener.nextInt();
      StekCelihBrojeva sekvenca = new StekCelihBrojeva();
      sekvenca.init();
      System.out.println(
               "Unesi elemente niza (unos broja van intervala oznacava kraj):");
      while (true) {
         int x = skener.nextInt();
         if (x < donja || x > gornja)
            break;
         sekvenca.push(x);
      }
      skener.close();
      Frekfencije brojPojava = new Frekfencije();
      brojPojava.izracunaj(donja, gornja, sekvenca);
      System.out.println(
               "\nBroj pojava (numericki prikaz):");
      brojPojava.prikaziNumericki();
      System.out.println("\nBroj pojava (histogram):");
      brojPojava.prikaziGraficki();
   }
}
