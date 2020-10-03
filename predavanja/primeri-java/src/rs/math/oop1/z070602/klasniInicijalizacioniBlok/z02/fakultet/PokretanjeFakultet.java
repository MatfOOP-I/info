/*
 
 Написати Јава програм који омогућује рад са студентима и професорима.
 
 Подаци о студентима и професорима су организовани у посебним класама, 
 које се налазе у одвојеним датотекама.
 
   
 Активности студената и професора су оргаизовани тако да буду заједно
 са подацима. Информације о предметима су издвојене у посебну класу.
 
 */

// Задатак илуструје примену иницијализационих блокова примерка и
// статичких иницијализационих блокова.

package rs.math.oop1.z070602.klasniInicijalizacioniBlok.z02.fakultet;

public class PokretanjeFakultet {

   public static void main(String[] args) {
      Profesor prof1 = new Profesor();
      prof1.setIme("Petar");
      prof1.setPrezime("Petrovic");
      prof1.setKatedra("RI");
      prof1.setZvanje("docent");
      prof1.setPredmetPredaje(1, true);
      prof1.setPredmetPredaje(3, true);
      prof1.prikazi();
      System.out.printf("Predaje %d predmeta.\n",
               prof1.getPredmetPredajeBroj());
      System.out.println();
      Student stud1 = new Student();
      stud1.setIme("Ivan");
      stud1.setPrezime("Ivanovic");
      stud1.setSmer("R");
      // stud1.setBrojIndeksa(112);
      // stud1.setGodinaUpisa(2016);
      stud1.setGodinaStudija(1);
      stud1.setOcena(0, 9);
      stud1.setOcena(3, 6);
      Student stud2 = new Student();
      stud2.setIme("Marko");
      stud2.setPrezime("Markovic");
      // stud2.setBrojIndeksa(112);
      stud2.setGodinaUpisa(2016);
      stud2.setGodinaStudija(1);
      stud2.setSmer("M");
      stud2.setOcena(1, 9);
      stud2.setOcena(2, 6);
      stud2.setOcena(3, 8);
      stud2.setOcena(4, 8);
      Student stud3 = new Student();
      stud3.setIme("Janko");
      stud3.setPrezime("Jankovic");
      // stud3.setBrojIndeksa( 114);
      stud3.setGodinaUpisa(2015);
      stud3.setGodinaStudija(3);
      stud3.setSmer("R");
      stud3.setOcena(0, 9);
      stud3.setOcena(2, 7);
      stud3.setOcena(3, 9);
      stud3.setOcena(4, 9);
      Student[] sviStudenti =
      { stud1, stud2, stud3 };
      System.out.printf("\nSvi studenti\n============\n");
      for (int i = 0; i < sviStudenti.length; i++)
         sviStudenti[i].prikazi();
   }
}
