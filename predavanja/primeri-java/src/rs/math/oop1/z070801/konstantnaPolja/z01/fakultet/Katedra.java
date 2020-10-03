package rs.math.oop1.z070801.konstantnaPolja.z01.fakultet;

class Katedra {

   static final String RACUNARTSVO_I_INFORMATIKA = "RI";
   static final String ALGEBRA_I_LOGIKA = "AL";
   static final String KOMPLEKSNA_ANALIZA = "KA";
   static final String FUNKCIONALNA_ANALIZA = "FA";
   static final String NUMERICKA_ANALIZA_I_OPTIMIZACIJA = "NMO";
   static final String VEROVATNOCA_I_STATISTIKA = "VS";
   static final String NEDEFINISANA = "?";

   static boolean jeKorektna(String katedraOznaka) {
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
