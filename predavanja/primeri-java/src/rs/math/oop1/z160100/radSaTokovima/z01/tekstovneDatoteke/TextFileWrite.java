package rs.math.oop1.z160100.radSaTokovima.z01.tekstovneDatoteke;

import java.io.*;

/**
 * @version 1.12 2007-06-22
 * @author Cay Horstmann
 */
public class TextFileWrite
{
   public static void main(String[] args)
   {
      Zaposleni[] osoblje = new Zaposleni[3];

      osoblje[0] = new Zaposleni("Janko Jankovic", 75000, 1987, 12, 15);
      osoblje[1] = new Zaposleni("Marko Markovic", 50000, 1989, 10, 1);
      osoblje[2] = new Zaposleni("Tony Tester", 40000, 1990, 3, 15);

      try
      {
         // save all employee records to the file employee.dat
         PrintWriter out = new PrintWriter("employee3.dat");
         writeData(osoblje, out);
         out.close();

          System.out.println("Zaposleni su upisani u datoteku employee3.dat.");
      }
      catch (IOException exception)
      {
         exception.printStackTrace();
      }
   }

   /**
    * Writes all employees in an array to a print writer
    * @param employees an array of employees
    * @param out a print writer
    */
   private static void writeData(Zaposleni[] employees, PrintWriter out) throws IOException
   {
      // write number of employees
      out.println(employees.length);

      for (Zaposleni e : employees)
         e.writeData(out);
   }

 }

