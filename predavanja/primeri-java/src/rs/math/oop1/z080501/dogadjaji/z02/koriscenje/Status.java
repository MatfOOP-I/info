package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

public class Status {
   public static final int SPAVANJE = 1;
   public static final int RAD = 2;
   public static final int UCENJE = 3;
   public static final int PROVOD = 4;
   public static final int ODMOR = 5;

   public static String opis(int dan) {
      switch (dan) {
         case SPAVANJE:
            return "spavanje";
         case RAD:
            return "rad";
         case UCENJE:
            return "ucenje";
         case PROVOD:
            return "provod";
         case ODMOR:
            return "odmor";
         default:
            return "ovo ne bi smelo da se pojavi!";
      }
   }

}
