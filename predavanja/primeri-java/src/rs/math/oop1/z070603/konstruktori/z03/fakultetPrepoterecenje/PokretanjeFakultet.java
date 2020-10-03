/*
 
 Написати Јава програм који омогућује рад са студентима и професорима.
 
 Подаци о студентима и професорима су организовани у посебним класама, 
 које се налазе у одвојеним датотекама.
 
   
 Активности студената и професора су оргаизовани тако да буду заједно
 са подацима. Информације о предметима су издвојене у посебну класу.
 
 */

// Задатак илуструје примену конструктора (Profesor, Student).
// Задатак илуструје прeoптерећење конструктора (Profesor, Student).
// Задатак илуструје проблем када компоненте објекта могу да мењају стање (Student).

package rs.math.oop1.z070603.konstruktori.z03.fakultetPrepoterecenje;

public class PokretanjeFakultet {

   public static void main(String[] args) {
      boolean[] prof1Zaduzenja =
      { false, true, false, true, false };
      Profesor prof1 = new Profesor("Petar", "Petrovic",
               "docent", "RI", prof1Zaduzenja);
      prof1.prikazi();
      System.out.printf("Predaje %d predmeta.\n",
               prof1.getPredmetPredajeBroj());
      System.out.println();
      Student stud1 = new Student("Ivan", "Ivanovic", "R",
               112, 2016, 1);
      stud1.setOcena(0, 9);
      stud1.setOcena(3, 6);
      int[] stud2Ocene =
      { 9, -1, 6, 8, 8 };
      Student stud2 = new Student("Marko", "Markovic", "M",
               112, 2014, 1, stud2Ocene);
      int[] stud3Ocene =
      { -1, -1, 6, 8, -1 };
      Student stud3 = new Student("Milan", "Milanovic", "M",
               112, 2014, 1, stud3Ocene);
      Student stud4 = new Student("Janko", "Jankovic", "R",
               114, 2015, 3);
      stud4.prepisiOceneOd(stud1);
      ;
      Student[] sviStudenti =
      { stud1, stud2, stud3, stud4 };
      for (int i = 0; i < sviStudenti.length; i++)
         sviStudenti[i].prikazi();
      System.out
               .println("\nPromenjene su ocene samo za studenta "
                        + stud1.getIme() + " "
                        + stud1.getPrezime());
      stud1.setOcena(2, 7);
      for (int i = 0; i < sviStudenti.length; i++)
         sviStudenti[i].prikazi();
   }
}
