/*
 
 Написати Јава програм који омогућује рад са студентима и професорима.
 
 Подаци о студентима и професорима су организовани у посебним класама, 
 које се налазе у одвојеним датотекама.
 
   
 Активности студената и професора су оргаизовани тако да буду заједно
 са подацима. Информације о предметима су издвојене у посебну класу.
 
 */

// Задатак илуструје примену наслеђивања (Profesor, Student).
// Задатак илуструје пoлиморфизам (Covek).

package rs.math.oop1.z070502.prevazilazenje.z01.fakultet;

public class PokretanjeFakultet {

   public static void main(String[] args) {
      Profesor prof1 = new Profesor("Petar", "Petrovic",
               "docent", "RI");
      prof1.setPredmetPredaje(1, true);
      prof1.setPredmetPredaje(3, true);
      Student stud1 = new Student("Ivan", "Ivanovic", "R",
               112, 2016, 1);
      stud1.setOcena(0, 9);
      stud1.setOcena(3, 6);
      Student stud2 = new Student("Marko", "Markovic", "M",
               112, 2014, 1);
      stud2.setOcena(0, 9);
      stud2.setOcena(2, 6);
      stud2.setOcena(3, 8);
      stud2.setOcena(4, 8);
      Student stud3 = new Student("Janko", "Jankovic", "R",
               114, 2015, 3);
      stud3.setOcena(3, 10);
      System.out.println("Studenti:\n---------");
      Student[] sviStudenti =
      { stud1, stud2, stud3 };
      for (int i = 0; i < sviStudenti.length; i++)
         sviStudenti[i].prikazi();
      Covek[] sviLjudi =
      { prof1, stud1, stud2, stud3 };
      System.out.println("Ljudi:\n------");
      for (Covek c : sviLjudi)
         c.prikazi();
   }
}
