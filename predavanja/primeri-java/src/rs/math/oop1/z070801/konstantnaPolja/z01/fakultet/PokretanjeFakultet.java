/*
 
 Написати Јава програм који омогућује рад са студентима и професорима.
 
 Подаци о студентима и професорима су организовани у посебним класама, 
 које се налазе у одвојеним датотекама.
 
   
 Активности студената и професора су оргаизовани тако да буду заједно
 са подацима.
  
 */

// Програм илуструје статичка поља - нпр. број предмета и методе
// нпр. за учитавање


package rs.math.oop1.z070801.konstantnaPolja.z01.fakultet;

public class PokretanjeFakultet {

   public static void main(String[] args) {
      
      String s = "Petar \n Petrovic \n RI \n docent \n da ne da da ne";
      java.util.Scanner skener = new java.util.Scanner(s);
      Profesor prof1 = Profesor.ucitaj(skener, false);
      prof1.prikazi();

      /*
      s = "Ivan \n Ivanovic \n R \n 112 \n 2016 \n 2 \n -1 -1 9 9 6  ";
      skenerNiska = new java.util.Scanner(s);
      Student stud = Student.ucitaj(skenerNiska, false);
      stud.prikazi();
      */
   }
}
