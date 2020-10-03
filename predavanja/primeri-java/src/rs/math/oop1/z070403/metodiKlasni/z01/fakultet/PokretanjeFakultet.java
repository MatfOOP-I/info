/*
 
 Написати Јава програм који омогућује рад са студентима и професорима.
 
 Подаци о студентима и професорима су организовани у посебним класама, 
 које се налазе у одвојеним датотекама.
 
   
 Активности студената и професора су оргаизовани тако да буду заједно
 са подацима.
  
 */

// Програм илуструје статичка поља (нпр. број предмета, као и шифре и
// називи предмета) и методе (нпр. за учитавање професора и студената)

package rs.math.oop1.z070403.metodiKlasni.z01.fakultet;

public class PokretanjeFakultet {

   public static void main(String[] args) {
      String sProf = "Petar \n Petrovic \n RI \n docent \n da ne da da da";
      java.util.Scanner skenerProf = new java.util.Scanner(sProf);
      Profesor prof = Profesor.ucitaj(skenerProf, false);
      prof.prikazi();
      System.out.printf("Predaje %d predmeta.\n",
               prof.brojPredmetaKojePredaje());
      
      java.util.Scanner skener1 = new java.util.Scanner(System.in);
      Student stud1 = Student.ucitaj(skener1, true);
      stud1.prikazi();
      System.out.printf("Broj polozenih ispita: %3d\n",
               stud1.brojPolozenihIspita());
      System.out.printf("Prosecna ocena: %6.2f\n",
               stud1.prosekOcena());
      Student stud2 = Student.ucitaj(skener1, true);
      stud2.prikazi();
      System.out.printf("Broj polozenih ispita: %3d\n",
               stud2.brojPolozenihIspita());
      System.out.printf("Prosecna ocena: %6.2f\n",
               stud2.prosekOcena());
      skener1.close();
      
   }

}
