package rs.math.oop1.z070403.metodiKlasni.z03.fakultet;

public class Smer {

   public static final String R = "R";
   public static final String I = "I";
   public static final String M = "M";
   public static final String N = "N";
   public static final String V = "V";
   public static final String L = "L";
   public static final String AA = "AA";
   public static final String AF = "AF";
   public static final String AI = "AI";
   public static final String NEDEFINISAN = "?";

   public static boolean jeKorektan(String smerOznaka) {
      smerOznaka = smerOznaka.toUpperCase();
      if (smerOznaka.equals(R) || smerOznaka.equals(I) || smerOznaka.equals(M)
               || smerOznaka.equals(N) || smerOznaka.equals(V)
               || smerOznaka.equals(L) || smerOznaka.equals(AA)
               || smerOznaka.equals(AF) || smerOznaka.equals(AI))
         return true;
      return false;
   }

}
