/*

Јава класа која представља професора

*/

package rs.math.oop1.z070403.metodiKlasni.z01.fakultet;


class Profesor {
   String ime;
   String prezime;
   String zvanje;
   String katedra;
   boolean[] predaje;

   void init(String profIme, String profPrezime,
            String profKatedra, String profZvanje,
            boolean[] profPredaje) {
      ime = profIme;
      prezime = profPrezime;
      katedra = profKatedra;
      zvanje = profZvanje;
      predaje = new boolean[Predmet.broj];
      for (int i = 0; i < predaje.length; i++)
         predaje[i] = false;
      if (predaje.length == profPredaje.length)
         for (int i = 0; i < predaje.length; i++)
            predaje[i] = profPredaje[i];
   }

   byte brojPredmetaKojePredaje() {
      byte brojPredmeta = 0;
      for (boolean predmet : predaje)
         if (predmet)
            brojPredmeta++;
      return brojPredmeta;
   }

   static Profesor ucitaj(java.util.Scanner sc,
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
      boolean[] predaje = new boolean[Predmet.broj];
      for (int i = 0; i < predaje.length; i++) {
         if (prikaziPitanje)
            System.out.print("Predaje predmet '" + Predmet.getNaziv(i)
                     + "(d/n)': ");
         if (sc.next().trim().toLowerCase()
                  .toCharArray()[0] == 'd')
            predaje[i] = true;
         else
            predaje[i] = false;
      }
      rez.init(ime, prezime, katedra, zvanje, predaje);
      return rez;
   }

   void prikazi() {
      System.out.printf("\nProfesor: %s %s\n", ime,
               prezime);
      System.out.printf(
               "Katedra: %s. Zvanje: %s\nPredaje sledece predmete:\n",
               katedra, zvanje);
      for (int i = 0; i < predaje.length; i++)
         System.out.printf("%6s:%s%s", Predmet.getSifra(i),
                  (predaje[i]) ? "da " : "ne ",
                  (i == predaje.length - 1) ? "\n" : " ");
   }

}
