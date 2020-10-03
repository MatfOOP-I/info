package rs.math.oop1.z090301.lokalneUnutrasnje.z02.telefoni;

public class Telefoni {
   static String reg = "[^0-9]";

   public static void validirajBrojTelefona(String broj) {
      //mora da bude finalna kako bi se videla unutar lokalne metode
      final int duzinaBroja = 10;

      class BrojTelefona {
         String formatiraniBroj = null;

         BrojTelefona(String broj) {
            String trenutniBroj = broj.replaceAll(reg, "");
            if (trenutniBroj.length() == duzinaBroja)
               formatiraniBroj = trenutniBroj;
            else
               formatiraniBroj = null;
         }

         public String vratiBroj() {
            return formatiraniBroj;
         }
      }
      BrojTelefona mojBroj = new BrojTelefona(broj);
      if (mojBroj.vratiBroj() == null)
         System.out.println("Broj nije dobar");
      else
         System.out.println("Broj je dobar");
   }

   public static void main(String... args) {
      validirajBrojTelefona("123-456-7890");
   }
}


