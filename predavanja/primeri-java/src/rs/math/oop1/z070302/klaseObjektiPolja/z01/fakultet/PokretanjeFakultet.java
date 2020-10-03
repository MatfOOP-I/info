/*
 
 Написати Јава програм који омогућује рад са студентима и професорима.
 
 Подаци о студентима и професорима су организовани у посебним класама, 
 које се налазе у одвојеним датотекама.
 
 */

// Програм илуструје рад са класама када се у класама налазе само подаци - не 
// препоручује се да се тако ради

package rs.math.oop1.z070302.klaseObjektiPolja.z01.fakultet;

public class PokretanjeFakultet {

   static byte brojPredmeta = 8;

   static byte brojPolozenihIspita(Student student) {
      byte brojPolozenih = 0;
      for (int ocena : student.ocene)
         if (ocena > 5) {
            brojPolozenih++;
         }
      return brojPolozenih;
   }

   static double prosekOcena(Student student) {
      int brojOcena = 0;
      double sumaOcena = 0;
      for (int ocena : student.ocene)
         if (ocena != -1) {
            brojOcena++;
            sumaOcena += ocena;
         }
      return (brojOcena > 0) ? (sumaOcena / brojOcena) : -1;
   }

   static void prikazi(Student student) {
      System.out.printf("\nStudent: %s %s, %d/%d\n", student.ime, student.prezime, student.brojIndeksa,
            student.godinaUpisa);
      System.out.printf("Smer: %s. Godina studija: %d\nOcene:\n", student.smer, student.godinaStudija);
      for (int i = 0; i < brojPredmeta; i++)
         System.out.printf("%4d:%s%s", (i + 1), (student.ocene[i] == -1) ? "<nema>" : String.valueOf(student.ocene[i]),
               (i == brojPredmeta - 1) ? "\n" : " ");
   }

   static byte brojPredmetaKojePredaje(Profesor profesor) {
      byte brojPredmeta = 0;
      for (boolean predmet : profesor.predaje)
         if (predmet)
            brojPredmeta++;
      return brojPredmeta;
   }

   static void prikazi(Profesor profesor) {
      System.out.printf("\nProfesor: %s %s\n", profesor.ime, profesor.prezime);
      System.out.printf("Katedra: %s. Zvanje: %s\nPredaje sledece predmete:\n", profesor.katedra, profesor.zvanje);
      for (int i = 0; i < brojPredmeta; i++)
         System.out.printf("%4d:%s%s", (i + 1), (profesor.predaje[i]) ? "da " : "ne ",
               (i == brojPredmeta - 1) ? "\n" : " ");
   }

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
      prikazi(stud1);

      System.out.printf("Broj polozenih ispita: %3d\n", brojPolozenihIspita(stud1));
      System.out.printf("Prosecna ocena: %6.2f\n", prosekOcena(stud1));

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
      prikazi(stud2);
      System.out.printf("Broj polozenih ispita: %3d\n", brojPolozenihIspita(stud2));
      System.out.printf("Prosecna ocena: %6.2f\n", prosekOcena(stud2));

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
      prikazi(prof1);
      System.out.printf("Predaje %d predmeta.\n", brojPredmetaKojePredaje(prof1));
   }

}
