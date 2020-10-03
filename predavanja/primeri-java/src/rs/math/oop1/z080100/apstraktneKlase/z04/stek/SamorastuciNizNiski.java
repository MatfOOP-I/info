package rs.math.oop1.z080100.apstraktneKlase.z04.stek;

public class SamorastuciNizNiski {
   private String[] elementi;

   // inicijalizacioni blok primerka
   {
      elementi = new String[18];
   }

   public void postavi(String vrednost, int indeks) {
      if (indeks >= elementi.length) {
         String[] temp = elementi;
         int novaDimenzija = Integer.max(indeks, 2*elementi.length);
         elementi = new String[novaDimenzija];
         for (int i = 0; i < temp.length; i++)
            elementi[i] = temp[i];
      }
      elementi[indeks] = vrednost;
   }

   public String vrati(int indeks) {
      if (indeks < 0) {
         System.err.println("Greska: indeks je negativan!");
         return null;
      }
      if (indeks >= elementi.length) {
         System.err.println("Greska: indeks je veci od dimenzije niza!");
         return null;
      }
      return elementi[indeks];
   }

   public int dimenzija() {
      return (elementi.length);
   }

}
