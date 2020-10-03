package rs.math.oop1.z080204.interfejsi.z02.ljudi;

/**
 * Program ilustruje koncept nasleđivanja i interfejsa.
 */
public class PokretanjeLjudi2 {

   public static void main(String[] args) {
      Papagaj koko = new Papagaj();
      koko.predstaviSe();
      Deskripcija d0 = koko;
      d0.predstaviSe();

      Student marko = new Student("Marko", "Markovic", "I smer", "12/2009", 3);
      marko.setDobrota(75);

      Student janko = new Student("Janko", "Jankovic", "I smer", "12/2010", 3);
      janko.setPostenje(99);

      Nastavnik milica = new Nastavnik("Milica", "Jankovic", "OOP", 12);


      marko.predstaviSe();
      Deskripcija d = marko;
      d.predstaviSe();
      Kvalitet k = marko;
      System.out.println("dob: " + k.jeDobar() + " pos:" + k.jePosten());

      janko.predstaviSe();
      ((Deskripcija) janko).predstaviSe();
      System.out.println("dob: " + ((Kvalitet) janko).jeDobar() + " pos:"
            + ((Kvalitet) janko).jePosten());

      milica.predstaviSe();
      ((Deskripcija) milica).predstaviSe();
      System.out.println("dob: " + ((Kvalitet) milica).jeDobar() + " pos:"
            + ((Kvalitet) milica).jePosten());

   }

}
