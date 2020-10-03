/*

Јава класа која представља студента

*/

package rs.math.oop1.z080204.interfejsi.z01.fakultet;

import java.util.*;

public class Student extends Covek {

   static int pocetnaVrednost;

   private String smer;
   private int brojIndeksa;
   private int godinaUpisa;
   private int godinaStudija;
   private int[] ocene;

   static {
      pocetnaVrednost = 2000 + (new Random().nextInt(100));
   }

   {
      int brojPredmeta = Predmet.brojPredmeta;
      ocene = new int[brojPredmeta];
      for (int i = 0; i < brojPredmeta; i++)
         ocene[i] = -1;
      brojIndeksa = pocetnaVrednost++;
      godinaUpisa = 2100;
   }

   public Student(String ime, String prezime, String smer,
            int brojIndeksa, int godinaUpisa,
            int godinaStudija) {
      super(ime, prezime);
      this.smer = smer;
      this.brojIndeksa = brojIndeksa;
      this.godinaUpisa = godinaUpisa;
      this.godinaStudija = godinaStudija;
   }

   public Student(String ime, String prezime, String smer,
            int brojIndeksa, int godinaUpisa,
            int godinaStudija, int[] ocene) {
      this(ime, prezime, smer, brojIndeksa, godinaUpisa,
               godinaStudija);
      // Treba proveriti da li je prosledjeni niz OK !!
      this.ocene = ocene;
   }

   public String getSmer() {
      return smer;
   }

   public void setSmer(String studSmer) {
      smer = studSmer;
   }

   public int getBrojIndeksa() {
      return brojIndeksa;
   }

   public void setBrojIndeksa(int studBrojIndeksa) {
      brojIndeksa = studBrojIndeksa;
   }

   public int getGodinaUpisa() {
      return godinaUpisa;
   }

   public void setGodinaUpisa(int studGodinaUpisa) {
      godinaUpisa = studGodinaUpisa;
   }

   public int getGodinaStudija() {
      return godinaStudija;
   }

   public void setGodinaStudija(int studGodinaStudija) {
      godinaStudija = studGodinaStudija;
   }

   public int getOcena(int predmet) {
      return ocene[predmet];
   }

   public void setOcena(int predmet, int ocena) {
      ocene[predmet] = ocena;
   }

   public byte getOceneBroj() {
      byte brojPolozenih = 0;
      for (int ocena : ocene)
         if (ocena > 5) {
            brojPolozenih++;
         }
      return brojPolozenih;
   }

   public double getOceneProsek() {
      int brojOcena = 0;
      double sumaOcena = 0;
      for (int ocena : ocene)
         if (ocena != -1) {
            brojOcena++;
            sumaOcena += ocena;
         }
      return (brojOcena > 0) ? (sumaOcena / brojOcena) : -1;
   }

   public void prikazi() {
      System.out.printf("Student: ");
      super.prikazi();
      System.out.printf("%d/%d\n", brojIndeksa,
               godinaUpisa);
      System.out.printf(
               "Smer: %s. Godina studija: %d\nOcene:\n",
               smer, godinaStudija);
      for (int i = 0; i < ocene.length; i++)
         System.out.printf("%s:%s%s",
                  Predmet.getSifraPredmeta(i),
                  (ocene[i] == -1) ? "<nema>"
                           : String.valueOf(ocene[i]),
                  (i == ocene.length - 1) ? "\n" : " ");
   }

   public static Student ucitaj(Scanner skener) {
      System.out.println("Ime i prezime studenta");
      String studIme = skener.next();
      String studPrezime = skener.next();
      System.out.println("Broj indeksa studenta");
      int studBrojIndeksa = 0;
      int studGodinaUpisa = 0;
      String brojIndeksa = skener.next().trim();
      int pozicija = brojIndeksa.indexOf('/');
      if (pozicija != -1) {
         studBrojIndeksa = Integer.parseInt(
                  brojIndeksa.substring(0, pozicija));
         studGodinaUpisa = Integer.parseInt(
                  brojIndeksa.substring(pozicija + 1));
      }
      System.out.println("Smer na kom studira student");
      String studSmer = skener.next();
      System.out.println("Godina studija za studenta");
      int studGodinaStudija = skener.nextInt();
      int[] studOcene = new int[Predmet.brojPredmeta];
      System.out.printf(
               "Unesi ocene iz %d predmeta (-1 znaci nije polagao)\n",
               studOcene.length);
      for (int i = 0; i < studOcene.length; i++) {
         System.out
                  .print(Predmet.getSifraPredmeta(i) + ":");
         studOcene[i] = skener.nextInt();
      }
      return new Student(studIme, studPrezime, studSmer,
               studBrojIndeksa, studGodinaUpisa,
               studGodinaStudija, studOcene);
   }

   /* OK */
   // public void prepisiOceneOd(Student drugiStudent) {
   // ocene = new int[drugiStudent.ocene.length];
   // for(int i=0; i<ocene.length; i++)
   // ocene[i] = drugiStudent.ocene[i];
   // }

   /* Nije OK ! */
   public void prepisiOceneOd(Student drugiStudent) {
      ocene = drugiStudent.ocene;
   }
}
