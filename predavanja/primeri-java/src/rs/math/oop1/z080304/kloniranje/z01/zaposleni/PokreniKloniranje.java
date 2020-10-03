package rs.math.oop1.z080304.kloniranje.z01.zaposleni;


public class PokreniKloniranje {

   public static void main(String[] args) {
      try {
         Zaposleni original = new Zaposleni("Jovan", "Petović", "pripravnik", 300);
         Zaposleni kopija = original.clone();
         System.out.println("Posle kloniranja, a pre promena");
         System.out.println("original = " + original);
         System.out.println("kopija =   " + kopija);

         original.setPrezime("Stanisic");
         System.out.println("Posle postavljanja prezimena originala na 'Stanisic'");
         System.out.println("original = " + original);
         System.out.println("kopija =   " + kopija);

         kopija.povecajPlatu(10);
         System.out.println("Posle povecanja plate kopije za 10%");
         System.out.println("original = " + original);
         System.out.println("kopija =   " + kopija);

      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
   }
}

