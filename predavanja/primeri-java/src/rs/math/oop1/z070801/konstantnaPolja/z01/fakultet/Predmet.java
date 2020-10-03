/*

Јава класа која представља прeдмет.

Засад садржи само број предмета.

*/

package rs.math.oop1.z070801.konstantnaPolja.z01.fakultet;

class Predmet {

   static final int BROJ = 5;

   static final String[] SIFRE =
   { "P1", "P2", "UOR", "OOP", "UVIT" };

   static final String[] NAZIVI =
   { "Programiranje 1", "Programiranje 2",
            "Uvod u Organizaciju Racunara",
            "Objektno Orjentisano Programiranje",
            "Uvod u Veb i Internet Tehnologije" };
   
   static String getSifra(int i) {
      return SIFRE[i];
   }

   static String getNaziv(int i) {
      return NAZIVI[i];
   }

   static int indeksPoSifri(String sifra) {
      for (int i = 0; i < SIFRE.length; i++)
         if (SIFRE[i].trim().equals(sifra.trim()))
            return i;
      return -1;
   }

}
