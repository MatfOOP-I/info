package rs.math.oop1.z150602.katalozi.z01.hesKatalog;

import java.util.*;

public class MapTest
{
   public static void main(String[] args)
   {
      Map<String, Zaposleni> osoblje = new HashMap<>();
      osoblje.put("144-25-5464", new Zaposleni("Amy Lee", 10));
      osoblje.put("567-24-2546", new Zaposleni("Marko Markovic", 20));
      osoblje.put("157-62-7935", new Zaposleni("Gary Cooper", 100));
      osoblje.put("456-62-5527", new Zaposleni("Francesca Cruz"));

      // print all entries

      System.out.println(osoblje);

      // remove an entry

      osoblje.remove("567-24-2546");
      System.out.println("Uklonjen " + "567-24-2546");
      System.out.println(osoblje);

      // replace an entry

      osoblje.put("456-62-5527", new Zaposleni("Francesca Miller", 3));
      System.out.println("Francesca Miller" + "sa sifrom " +"456-62-5527");
      System.out.println(osoblje);

      // look up a value

      System.out.println(osoblje.get("157-62-7935"));

      // iterate through all entries

      for (Map.Entry<String, Zaposleni> entry : osoblje.entrySet())
      {
         String key = entry.getKey();
         Zaposleni value = entry.getValue();
         System.out.println("key=" + key + ", value=" + value);
      }
   }
}

/**
 * A minimalist employee class for testing purposes.
 */
class Zaposleni
{
  
  public Zaposleni(String n, double plata)
  {
     ime = n;
     this.plata = plata;
  }

   public Zaposleni(String n)
   {
      this( n, 0);
   }

   public String toString()
   {
      return "[ime=" + ime + ", plata=" + plata + "]";
   }

   private String ime;
   private double plata;
}
