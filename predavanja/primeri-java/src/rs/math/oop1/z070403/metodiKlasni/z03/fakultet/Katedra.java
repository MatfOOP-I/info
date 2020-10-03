package rs.math.oop1.z070403.metodiKlasni.z03.fakultet;

public class Katedra {

   public static final String RACUNARTSVO_I_INFORMATIKA = "RI";
   public static final String ALGEBRA_I_LOGIKA = "AL";
   public static final String KOMPLEKSNA_ANALIZA = "KA";
   public static final String FUNKCIONALNA_ANALIZA = "FA";
   public static final String NUMERICKA_ANALIZA_I_OPTIMIZACIJA = "NMO";
   public static final String VEROVATNOCA_I_STATISTIKA = "VS";
   public static final String NEDEFINISANA = "?";

   public static boolean jeKorektna(String katedraOznaka) {
      katedraOznaka = katedraOznaka.toUpperCase();
      if (katedraOznaka.equals(RACUNARTSVO_I_INFORMATIKA)
               || katedraOznaka.equals(ALGEBRA_I_LOGIKA)
               || katedraOznaka.equals(KOMPLEKSNA_ANALIZA)
               || katedraOznaka.equals(FUNKCIONALNA_ANALIZA)
               || katedraOznaka.equals(NUMERICKA_ANALIZA_I_OPTIMIZACIJA)
               || katedraOznaka.equals(VEROVATNOCA_I_STATISTIKA))
         return true;
      return false;
   }

}
