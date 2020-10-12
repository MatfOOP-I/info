/*
  
Написати Јава програм који пребројава елементе у низoвима бројева
и бројеве елемената приказује бројчаном облику и у облику хистограма.
    
Податке потребне за одређивање и чување броја појава елемената датог низа, 
као и методе за израчунавање броја појава, као и за нумерички и хистограмски 
приказ добијених података издвојити у посебну класу.

*/

// Програм илуструје како се функционалности израчунавања фрекфенције и њиховог 
// приказа могу енкапсулирати у класи.

package rs.math.oop1.z070401.definicjeMetoda.z03.frekvencije;

public class PokretanjeFrekfencije {

   public static void main(String[] args) {
      int[] niz1 =
      { 1, 2, 4, 0, 7, 6, 3, -2, 5, 6, 4, 3, 7, 3, 2, 5, 7,
               8, 5 };
      System.out.println("Prvi niz brojeva:");
      for (int x : niz1)
         System.out.printf("%4d", x);
      Frekfencije brojPojava = new Frekfencije();
      brojPojava.izracunaj(niz1);
      System.out.println(
               "\nBroj pojava za prvi niz (numericki prikaz):");
      brojPojava.prikaziNumericki();
      
      int[] niz2 =
      { 5, 5, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5 };
      System.out.println("\n\nDrugi niz brojeva:");
      for (int x : niz2)
         System.out.printf("%4d", x);
      brojPojava.izracunaj(niz2);
      System.out.println(
               "\nBroj pojava za drugi niz (histogram):");
      brojPojava.prikaziGraficki();
   }
}
