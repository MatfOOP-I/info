/*

Јава класа која представља прeдмет.

Засад садржи само број предмета.

*/

package rs.math.oop1.z070403.metodiKlasni.z01.fakultet;

class Predmet {

   static int broj = 5;

   static String[] sifre =
   { "P1", "P2", "UOR", "OOP", "UVIT" };

   static String[] nazivi =
   { "Programiranje 1", "Programiranje 2",
            "Uvod u Organizaciju Racunara",
            "Objektno Orjentisano Programiranje",
            "Uvod u Veb i Internet Tehnologije" };

   static String getSifra(int i) {
      return sifre[i];
   }

   static String getNaziv(int i) {
      return nazivi[i];
   }

   static int indeksPoSifri(String sifra) {
      for (int i = 0; i < sifre.length; i++)
         if (sifre[i].trim().equals(sifra.trim()))
            return i;
      return -1;
   }

}
