package rs.math.oop1.z070801.konstantnaPolja.z01.fakultet;

class Smer {

   static final String R = "R";
   static final String I = "I";
   static final String M = "M";
   static final String N = "N";
   static final String V = "V";
   static final String L = "L";
   static final String AA = "AA";
   static final String AF = "AF";
   static final String AI = "AI";
   static final String NEDEFINISAN = "?";

   static boolean jeKorektan(String smerOznaka) {
      smerOznaka = smerOznaka.toUpperCase();
      if (smerOznaka.equals(R) || smerOznaka.equals(I) || smerOznaka.equals(M)
               || smerOznaka.equals(N) || smerOznaka.equals(V)
               || smerOznaka.equals(L) || smerOznaka.equals(AA)
               || smerOznaka.equals(AF) || smerOznaka.equals(AI))
         return true;
      return false;
   }

}
