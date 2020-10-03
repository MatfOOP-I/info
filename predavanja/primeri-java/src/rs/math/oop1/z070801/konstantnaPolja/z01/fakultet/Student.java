/*

Јава класа која представља студента

*/

package rs.math.oop1.z070801.konstantnaPolja.z01.fakultet;

class Student {
   String ime;
   String prezime;
   String smer;
   int brojIndeksa;
   int godinaUpisa;
   int godinaStudija;
   int[] ocene;

   void init(String studIme, String studPrezime,
            String studSmer, int studBrojIndeksa,
            int studGodinaUpisa, int studGodinaStudija,
            int[] studOcene) {
      ime = studIme;
      prezime = studPrezime;
      smer = studSmer;
      brojIndeksa = studBrojIndeksa;
      godinaUpisa = studGodinaUpisa;
      godinaStudija = studGodinaStudija;
      ocene = new int[Predmet.BROJ];
      for (int i = 0; i < ocene.length; i++)
         ocene[i] = -1;
      if (ocene.length == studOcene.length)
         for (int i = 0; i < ocene.length; i++)
            ocene[i] = studOcene[i];
   }

   byte brojPolozenihIspita() {
      byte brojPolozenih = 0;
      for (int ocena : ocene)
         if (ocena > 5) {
            brojPolozenih++;
         }
      return brojPolozenih;
   }

   double prosekOcena() {
      int brojOcena = 0;
      double sumaOcena = 0;
      for (int ocena : ocene)
         if (ocena != -1) {
            brojOcena++;
            sumaOcena += ocena;
         }
      return (brojOcena > 0) ? (sumaOcena / brojOcena) : -1;
   }

   static Student ucitaj(java.util.Scanner sc,
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
      if (!Smer.jeKorektan(smer))
         smer = Smer.NEDEFINISAN;
      if (prikaziPitanje)
         System.out.print("Broj indeksa: ");
      int brojIndeksa = sc.nextInt();
      if (prikaziPitanje)
         System.out.print("Godina upisa: ");
      int godinaUpisa = sc.nextInt();
      if (prikaziPitanje)
         System.out.print("Godina studija: ");
      int godinaStudija = sc.nextInt();
      int[] ocene = new int[Predmet.BROJ];
      for (int i = 0; i < ocene.length; i++) {
         if (prikaziPitanje)
            System.out.print("Ocena iz predmeta '"
                     + Predmet.getNaziv(i) + "': ");
         ocene[i] = sc.nextInt();
      }
      rez.init(ime, prezime, smer, brojIndeksa, godinaUpisa,
               godinaStudija, ocene);
      return rez;
   }

   void prikazi() {
      System.out.printf("\nStudent: %s %s, %d/%d\n", ime,
               prezime, brojIndeksa, godinaUpisa);
      System.out.printf(
               "Smer: %s. Godina studija: %d\nOcene:\n",
               smer, godinaStudija);
      for (int i = 0; i < ocene.length; i++)
         System.out.printf("%6s:%s%s", Predmet.getSifra(i),
                  (ocene[i] == -1) ? "<nema>"
                           : String.valueOf(ocene[i]),
                  (i == ocene.length - 1) ? "\n" : " ");
   }

}
