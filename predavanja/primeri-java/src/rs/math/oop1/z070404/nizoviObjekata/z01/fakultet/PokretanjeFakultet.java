/*
 
 Написати Јава програм који омогућује рад са студентима и професорима.
 
 Подаци о студентима и професорима су организовани у посебним класама, 
 које се налазе у одвојеним датотекама.
 
   
 Активности студената и професора су оргаизовани тако да буду заједно
 са подацима.
 
 Информације о предметима су издвојене у посебну класу.
 
 */

// Програм илуструје учитавање објеката са улаза

package rs.math.oop1.z070404.nizoviObjekata.z01.fakultet;

public class PokretanjeFakultet {

   static Student ucitajStudenta(java.util.Scanner sc,
            boolean prikaziPitanje) {
      Student rez = new Student();
      if (prikaziPitanje)
         System.out.print("Ime: ");
      String ime = sc.nextLine();
      if (prikaziPitanje)
         System.out.print("Prezime: ");
      String prezime = sc.nextLine();
      if (prikaziPitanje)
         System.out.print("Smer: ");
      String smer = sc.nextLine();
      if (prikaziPitanje)
         System.out.print("Broj indeksa: ");
      int brojIndeksa = sc.nextInt();
      if (prikaziPitanje)
         System.out.print("Godina upisa: ");
      int godinaUpisa = sc.nextInt();
      if (prikaziPitanje)
         System.out.print("Godina studija: ");
      int godinaStudija = sc.nextInt();
      int[] ocene = new int[new Predmet().getBrojPredmeta()];
      for( int i =0; i < ocene.length; i++)
      {
         if( prikaziPitanje)
            System.out.print("Ocena iz predmeta '" + (i+1) + "': ");
         ocene[i] = sc.nextInt();
      }  
      rez.init(ime, prezime, smer, brojIndeksa, godinaUpisa,
               godinaStudija, ocene);
      return rez;
   }

   static Profesor ucitajProfesora(java.util.Scanner sc,
            boolean prikaziPitanje) {
      Profesor rez = new Profesor();
      if (prikaziPitanje)
         System.out.print("Ime: ");
      String ime = sc.nextLine();
      if (prikaziPitanje)
         System.out.print("Prezime: ");
      String prezime = sc.nextLine();
      if (prikaziPitanje)
         System.out.print("Katedra: ");
      String katedra = sc.nextLine();
      if (prikaziPitanje)
         System.out.print("Zvanje: ");
      String zvanje = sc.nextLine();
      boolean[] predaje = new boolean[new Predmet().getBrojPredmeta()];
      for( int i =0; i < predaje.length; i++)
      {
         if( prikaziPitanje)
            System.out.print("Predaje predmet '" + (i+1) + "(d/n)': ");
         if( sc.next().trim().toLowerCase().toCharArray()[0] == 'd')
            predaje[i] = true;
         else
            predaje[i] = false;
      }  
      rez.init(ime, prezime, katedra, zvanje, predaje);
      return rez;
   }

   public static void main(String[] args) {
      String s1 = "Petar \n Petrovic \n RI \n docent \n n d n d n";
      java.util.Scanner skener1 = new java.util.Scanner(s1);
      Profesor prof1 = ucitajProfesora(skener1, false);
      prof1.prikazi();
      System.out.printf("Predaje %d predmeta.\n",
               prof1.brojPredmetaKojePredaje());

      Student stud1 = new Student();
      int[] stud1ocene = {-1,9,6,8,8};
      stud1.init("Marko", "Markovic", "M", 112, 2015, 1, stud1ocene );
      stud1.prikazi();
      
      String s2 = "Ivan \n Ivanovic \n R \n 112 \n 2016 \n 2 \n -1 -1 9 9 6  ";
      java.util.Scanner skener2 = new java.util.Scanner(s2);
      Student stud2 = ucitajStudenta(skener2, false);
      stud2.prikazi();

      java.util.Scanner skener3 = new java.util.Scanner(
               System.in);
      Student stud3 = ucitajStudenta(skener3, true);
      stud3.prikazi();
      skener3.close();

      Student[] sviStudenti =
      { stud1, stud2, stud3 };
      System.out.printf("\nProseci ocena svih studenata\n============\n");
      for (int i = 0; i < sviStudenti.length; i++)
         System.out.println( sviStudenti[i].prosekOcena());
   }

}
