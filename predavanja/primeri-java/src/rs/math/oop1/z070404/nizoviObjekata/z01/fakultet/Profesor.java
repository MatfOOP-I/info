/*

Јава класа која представља професора

*/

package rs.math.oop1.z070404.nizoviObjekata.z01.fakultet;

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
      Predmet spisak = new Predmet();
      predaje = new boolean[spisak.getBrojPredmeta()];
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

   void prikazi() {
      System.out.printf("\nProfesor: %s %s\n", ime,
               prezime);
      System.out.printf(
               "Katedra: %s. Zvanje: %s\nPredaje sledece predmete:\n",
               katedra, zvanje);
      for (int i = 0; i < predaje.length; i++)
         System.out.printf("%4d:%s%s", (i + 1),
                  (predaje[i]) ? "da " : "ne ",
                  (i == predaje.length - 1) ? "\n" : " ");
   }

}
