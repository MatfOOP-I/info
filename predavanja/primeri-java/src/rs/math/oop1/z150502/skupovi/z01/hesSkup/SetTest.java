package rs.math.oop1.z150502.skupovi.z01.hesSkup;

import java.util.*;


public class SetTest
{
   public static void main(String[] args)
   {
      Set<String> reci = new HashSet<>(); // HashSet implements Set
      long ukupnoVreme = 0;

      Scanner in = new Scanner("ana voli milovana aaa bbb xxx ddd fff" );
      while (in.hasNext())
      {
         String word = in.next();
         long vreme = System.nanoTime();
         reci.add(word);
         vreme = System.nanoTime() - vreme;
         ukupnoVreme += vreme;
      }

      Iterator<String> iter = reci.iterator();
      for (int i = 1; i <= 200 && iter.hasNext(); i++)
         System.out.println(iter.next());
      System.out.println(". . .");
      System.out.println(reci.size() + " distinct words. " + ukupnoVreme/1e6 + " miliseconds.");
   }
}
