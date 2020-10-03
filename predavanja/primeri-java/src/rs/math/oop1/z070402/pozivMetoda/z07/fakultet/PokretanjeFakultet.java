/*
 
 Написати Јава програм који омогућује рад са студентима и професорима.
 
 Подаци о студентима и професорима су организовани у посебним класама, 
 које се налазе у одвојеним датотекама.
 
   
 Активности студената и професора су оргаизовани тако да буду заједно
 са подацима.
  
 */

// Програм илуструје рад са класама када су у класама учаурени и подаци и 
// методи - препоручује се да се тако ради.

package rs.math.oop1.z070402.pozivMetoda.z07.fakultet;

public class PokretanjeFakultet {

   static int brojPredmeta = 5;

   public static void main(String[] args) {
      Student stud1 = new Student();
      stud1.ime = "Ivan";
      stud1.prezime = "Ivanovic";
      stud1.smer = "R";
      stud1.brojIndeksa = 112;
      stud1.godinaUpisa = 2016;
      stud1.godinaStudija = 1;
      stud1.ocene = new int[brojPredmeta];
      for (int i = 0; i < brojPredmeta; i++)
         stud1.ocene[i] = -1;
      stud1.ocene[0] = 9;
      stud1.ocene[3] = 6;

      stud1.prikazi();
      System.out.printf("Broj polozenih ispita: %3d\n",
               stud1.brojPolozenihIspita());
      System.out.printf("Prosecna ocena: %6.2f\n",
               stud1.prosekOcena());

      Student stud2 = new Student();
      stud2.ime = "Marko";
      stud2.prezime = "Markovic";
      stud2.brojIndeksa = 112;
      stud2.godinaUpisa = 2016;
      stud2.godinaStudija = 1;
      stud2.smer = "M";
      stud2.ocene = new int[brojPredmeta];
      for (int i = 0; i < brojPredmeta; i++)
         stud2.ocene[i] = -1;
      stud2.ocene[1] = 9;
      stud2.ocene[2] = 7;
      stud2.ocene[3] = 8;
      stud2.ocene[4] = 8;

      stud2.prikazi();
      System.out.printf("Broj polozenih ispita: %3d\n",
               stud2.brojPolozenihIspita());
      System.out.printf("Prosecna ocena: %6.2f\n",
               stud2.prosekOcena());

      Profesor prof1 = new Profesor();
      prof1.ime = "Petar";
      prof1.prezime = "Petrovic";
      prof1.katedra = "RI";
      prof1.zvanje = "docent";
      prof1.predaje = new boolean[brojPredmeta];
      for (int i = 0; i < brojPredmeta; i++)
         prof1.predaje[i] = false;
      prof1.predaje[1] = true;
      prof1.predaje[3] = true;

      prof1.prikazi();
      System.out.printf("Predaje %d predmeta.\n",
               prof1.brojPredmetaKojePredaje());
   }

}
