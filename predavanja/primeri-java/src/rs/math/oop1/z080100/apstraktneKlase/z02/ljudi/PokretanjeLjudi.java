package rs.math.oop1.z080100.apstraktneKlase.z02.ljudi;

/**
 * Program ilustruje koncept nasleđivanja i apstraktnih klasa.
 */
public class PokretanjeLjudi {

   public static void main(String[] args) {
      Student marko = new Student("Marko", "Markovic", "",
            "I smer", "12/2009", 3);
      Apsolvent janko = new Apsolvent("Janko", "Jankovic", "",
            "I smer", "12/2010", 3, 10);
      Nastavnik milica = new Nastavnik("Milica", "Petrovic", "",
            "OOP", 12);

      marko.predstaviSe();
      janko.predstaviSe();
      milica.predstaviSe();
      System.out.println();

      Covek c = marko;
      c.predstaviSe();
      c = janko;
      c.predstaviSe();
      c = milica;
      c.predstaviSe();
   }

}
