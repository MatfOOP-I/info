package rs.math.oop1.z160100.radSaTokovima.z01.tekstovneDatoteke;

import java.io.*;
import java.util.*;

/**
 * @version 1.12 2007-06-22
 * @author Cay Horstmann
 */
public class TextFileRead
{
   public static void main(String[] args)
   {
      try
      {
         Scanner in = new Scanner(new FileReader("employee3.dat"));
         Zaposleni[] newStaff = readData(in);
         in.close();

          for (Zaposleni e : newStaff)
            System.out.println(e);
      }
      catch (IOException exception)
      {
         exception.printStackTrace();
      }
   }

   private static Zaposleni[] readData(Scanner in)
   {
      // retrieve the array size
      int n = in.nextInt();
      in.nextLine(); // consume newline

      Zaposleni[] employees = new Zaposleni[n];
      for (int i = 0; i < n; i++)
      {
         employees[i] = new Zaposleni();
         employees[i].readData(in);
      }
      return employees;
   }
}

