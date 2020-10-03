package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

public class DanUNedelji {
   public static final int PONEDELJAK = 1;
   public static final int UTORAK = 2;
   public static final int SREDA = 3;
   public static final int CETVRTAK = 4;
   public static final int PETAK = 5;
   public static final int SUBOTA = 6;
   public static final int NEDELJA = 7;

   public static String opis(int dan) {
      switch (dan) {
         case PONEDELJAK:
            return "ponedeljak";
         case UTORAK:
            return "utorak";
         case SREDA:
            return "sreda";
         case CETVRTAK:
            return "cetvrtak";
         case PETAK:
            return "petak";
         case SUBOTA:
            return "subota";
         case NEDELJA:
            return "nedelja";
         default:
            return "ovo ne bi smelo da se pojavi!";
      }
   }

}
