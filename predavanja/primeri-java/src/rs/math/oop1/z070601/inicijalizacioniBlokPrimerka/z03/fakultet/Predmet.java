/*

Јава класа која представља прeдмет.

Засад садржи само број предмета.

*/

package rs.math.oop1.z070601.inicijalizacioniBlokPrimerka.z03.fakultet;

public class Predmet {

   public static final int brojPredmeta = 5;

   private static final String[] sifrePredmeta =
   { "P1", "P2", "UOR", "OOP", "UVIT" };

   private static final String[] naziviPredmeta =
   {        "                   Programiranje 1",
            "                   Programiranje 2",
            "      Uvod u Organizaciju Racunara",
            "Objektno Orjentisano Programiranje",
            " Uvod u Veb i Internet Tehnologije" };

   public static String getSifraPredmeta(int predmet) {
      return sifrePredmeta[predmet];
   }

   public static String getNazivPredmeta(int predmet) {
      return naziviPredmeta[predmet];
   }
}
