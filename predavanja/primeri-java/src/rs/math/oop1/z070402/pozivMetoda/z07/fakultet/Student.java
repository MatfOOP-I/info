/*

Јава класа која представља студента

*/

package rs.math.oop1.z070402.pozivMetoda.z07.fakultet;

class Student {
   String ime;
   String prezime;
   String smer;
   int brojIndeksa;
   int godinaUpisa;
   int godinaStudija;
   int[] ocene;

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

   void prikazi() {
      System.out.printf("\nStudent: %s %s, %d/%d\n", ime,
               prezime, brojIndeksa, godinaUpisa);
      System.out.printf(
               "Smer: %s. Godina studija: %d\nOcene:\n",
               smer, godinaStudija);
      for (int i = 0; i < ocene.length; i++)
         System.out.printf("%4d:%s%s", (i + 1),
                  (ocene[i] == -1) ? "<nema>"
                           : String.valueOf(ocene[i]),
                  (i == ocene.length - 1) ? "\n" : " ");
   }

}
