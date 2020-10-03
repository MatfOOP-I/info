package rs.math.oop1.z150503.redovi.z02.redSaPrioritetima;

import java.util.*;

/**
 * This program demonstrates the use of a priority queue.
 * @version 1.00 2004-08-03
 * @author Cay Horstmann
 */
public class PriorityQueueTest
{
   public static void main(String[] args)
   {
      PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
      pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9)); // G. Hopper
      pq.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10)); // A. Lovelace
      pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3)); // J. von Neumann
      pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22)); // K. Zuse

      System.out.println("Iterating over elements...");
      for (GregorianCalendar date : pq)
         System.out.println(date.get(Calendar.YEAR));
      System.out.println("Removing elements...");
      while (!pq.isEmpty())
         System.out.println(pq.remove().get(Calendar.YEAR));
      PriorityQueue<GregorianCalendar> pq2 = new PriorityQueue<>(
      		new Comparator<GregorianCalendar>()
					{
						@Override
						public int compare( GregorianCalendar o1, GregorianCalendar o2 )
						{
							return -o1.compareTo( o2 );
						}
					}
      		);
      pq2.addAll( pq );
      pq2.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9)); // G. Hopper
      pq2.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10)); // A. Lovelace
      pq2.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3)); // J. von Neumann
      pq2.add(new GregorianCalendar(1910, Calendar.JUNE, 22)); // K. Zuse
      System.out.println( "-------------------------------" );
      while (!pq2.isEmpty())
        System.out.println(pq2.remove().get(Calendar.YEAR));

   }
}
