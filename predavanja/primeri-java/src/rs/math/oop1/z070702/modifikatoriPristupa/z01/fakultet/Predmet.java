/*

Јава класа која представља прeдмет.

Засад садржи само број предмета.

*/

package rs.math.oop1.z070702.modifikatoriPristupa.z01.fakultet;

public class Predmet {

   public static final int BROJ = 5;

   private static final String[] SIFRE =
   { "P1", "P2", "UOR", "OOP", "UVIT" };

   private static final String[] NAZIVI =
   { "Programiranje 1", "Programiranje 2",
            "Uvod u Organizaciju Racunara",
            "Objektno Orjentisano Programiranje",
            "Uvod u Veb i Internet Tehnologije" };
   
   public static String getSifra(int i) {
      return SIFRE[i];
   }

   public static String getNaziv(int i) {
      return NAZIVI[i];
   }

   public static int indeksPoSifri(String sifra) {
      for (int i = 0; i < SIFRE.length; i++)
         if (SIFRE[i].trim().equals(sifra.trim()))
            return i;
      return -1;
   }

}
