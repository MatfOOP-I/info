/*

Јава класа која представља професора

*/

package rs.math.oop1.z070402.pozivMetoda.z07.fakultet;

class Profesor {
   String ime;
   String prezime;
   String zvanje;
   String katedra;
   boolean[] predaje;

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
